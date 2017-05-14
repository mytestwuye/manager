package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.EncryptUtil;
import com.suny.association.utils.JsonResult;
import com.suny.association.utils.TokenProcessor;
import com.suny.association.utils.ValidActionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.suny.association.utils.WebUtils.getClientIpAdder;

/**
 * Comments:   基础公共Controller
 * Author:   孙建荣
 * Create Date: 2017/03/05 11:05
 */
@Controller
@RequestMapping("/base")
public class LoginController {

    private final IAccountService accountService;

    private final ILoginHistoryService loginHistoryService;

    @Autowired
    public LoginController(IAccountService accountService, ILoginHistoryService loginHistoryService) {
        this.accountService = accountService;
        this.loginHistoryService = loginHistoryService;
    }


    /**
     * 登录页面
     */
    @RequestMapping(value = "/loginPage.html", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        String token = TokenProcessor.getInstance().makeToken();
        request.getSession().setAttribute("token", token);
        System.out.println("产生的令牌值是" + token);
        return "/loginPage";
    }


    /**
     * 全局错误页面
     */
    @RequestMapping(value = "/errorPage.html", method = RequestMethod.GET)
    public ModelAndView errorPage() {
        return new ModelAndView("/errorPage");
    }


    /**
     * 提交登录信息操作
     *
     * @param username 登录用户名
     * @param password 登录密码
     * @param formCode 表单过来的验证码
     * @param request  request请求
     * @return 验证的json结果
     */
    @RequestMapping(value = "/loginAction.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginAction(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("formCode") String formCode,
                                  @RequestParam("token") String token,
                                  HttpServletRequest request) {
        /*   首先验证表单提交的token跟session里面的token是否相等，相等就说明不是重复提交  */
        if (!isRepeatSubmit(token, request)) {
            request.getSession().removeAttribute("token");
            String sessionCode = (String) request.getSession().getAttribute("code");
            /*  匹配session里面的验证码跟表单上的验证码是否相等    */
            if (!ValidActionUtil.matchCode(formCode, sessionCode)) {
                return JsonResult.failResult(BaseEnum.VALIDATE_CODE_ERROR);
            }
            /*  匹配认证状态   */
            boolean authStatus = authAction(username, password);
            if (authStatus) {
                saveLoginInfo(request, username, true);
                saveLoginUser(request, username);
                return JsonResult.successResult(BaseEnum.LOGIN_SYSTEM);
            }
            saveLoginInfo(request, username, false);
            return JsonResult.failResult(BaseEnum.LOGIN_FAILURE);
        }
        System.out.println("重复提交表单");
        return JsonResult.failResult(BaseEnum.REPEAT_SUBMIT);
    }

    /**
     * 报存用户登录信息
     *
     * @param request  请求数据
     * @param username 登录的用户名
     */
    private void saveLoginInfo(HttpServletRequest request, String username, boolean authStatus) {
        String loginIp = getClientIpAdder(request);
        String userAgent = request.getHeader("user-agent");
        loginHistoryService.makeUpLoginInfo(userAgent, username, loginIp, authStatus);
    }

    /**
     * 验证token是否相同，防止CSRF或者重复提交表单
     *
     * @param token   令牌值
     * @param request request值
     * @return 比较的结果
     */
    private boolean isRepeatSubmit(String token, HttpServletRequest request) {
        // 如果token是空的则说明重复提交了表单
        if ("".equals(token) || token == null) {
            return true;
        }
        String sessionToken = (String) request.getSession().getAttribute("token");
        if (sessionToken == null) {
            return true;
        }
        if (sessionToken.equals(token)) {
            return false;
        }
        return false;
    }


    /**
     * 提交给shiro认证用户的密码跟用户名
     *
     * @param username 用户名
     * @param password 密码
     */
    private boolean authAction(String username, String password) {
        Account account = accountService.queryByName(username);
        return account != null && account.getAccountPassword().equals(EncryptUtil.encryptToMD5(password));

    }

    /**
     * shiro验证成功后报存用户的登录信息
     *
     * @param request  request请求
     * @param username 登录的用户名
     */
    private void saveLoginUser(HttpServletRequest request, String username) {
        Member member = accountService.queryByName(username).getAccountMember();
        Account account = accountService.queryByName(username);
        request.getSession().setAttribute("member", member);
        request.getSession().setAttribute("account", account);
    }


    /**
     * 登录成功后的操作
     *
     * @return 管理员中心
     */
    @RequestMapping(value = "/goAdminPage.html", method = RequestMethod.GET)
    public ModelAndView goAdminPage() {
        return new ModelAndView("adminManager");
    }

    /**
     * 用户点击退出的操作
     *
     * @return 注销登录，然后返回注销结果
     */
    @SystemControllerLog(description = "注销操作")
    @RequestMapping(value = "/logoutAction.do", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult logoutAction(HttpServletRequest request) {
        // 防止自动创建session，传入false阻止自动创建
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("account");
            session.removeAttribute("member");
            return JsonResult.successResult(BaseEnum.LOGOUT_SUCCESS);
        }
        return JsonResult.failResult(BaseEnum.LOGOUT_FAIL);
    }


}









