package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.EncryptUtil;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.suny.association.utils.LoginUtils.getClientIpAdder;

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
    public ModelAndView loginPage() {
        return new ModelAndView("/loginPage");
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
                                  HttpServletRequest request) {
        /*   方便本机测试，把验证码验证环节去除      */
//        String sessionCode = (String) request.getSession().getAttribute("code");
       /* if (!matchCode(formCode, sessionCode)) {
            return JsonResult.failResult(BaseEnum.VALIDATE_CODE_ERROR);
        }*/
        boolean authStatus = authAction(request, username, password);
        if (authStatus) {
            saveLoginInfo(request, username, true);
            saveLoginUser(request, username);
            return JsonResult.successResult(BaseEnum.LOGIN_SYSTEM);
        }
        saveLoginInfo(request, username, false);
        return JsonResult.failResult(BaseEnum.LOGIN_FAILURE);

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
     * 匹配表单填写的验证码跟session中储存的验证码
     *
     * @param formCode    表单提交的验证码
     * @param sessionCode session里面报存的验证码
     * @return 比较的结果
     */
    private boolean matchCode(String formCode, String sessionCode) {
        return !formCode.equals("") && sessionCode.equals(formCode);
    }

    /**
     * 提交给shiro认证用户的密码跟用户名
     *
     * @param request  request请求
     * @param username 用户名
     * @param password 密码
     */
    private boolean authAction(HttpServletRequest request, String username, String password) {
        /*UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encryptToMD5(password));
        Subject currentUser = SecurityUtils.getSubject();
        //如果还没有登录就 //使用shiro来验证
        if (!currentUser.isAuthenticated()) {
            token.setRememberMe(true);
            currentUser.login(token);      //验证角色和权限
        } else if (currentUser.isAuthenticated()) {
            saveLoginInfo(request, username, false);
            throw new BusinessException(BaseEnum.REPEAT_LOGIN);
        } else {
            saveLoginInfo(request, username, false);
            throw new BusinessException(BaseEnum.PASS_ERROR);
        }*/
        /*    手动写权限控制，注释shiro代码   */
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
    public JsonResult logoutAction() {
        return JsonResult.successResult(BaseEnum.LOGOUT_SUCCESS);
    }


}









