package com.suny.association.controller;

import com.suny.association.enums.LoginEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.DecryptUtil;
import com.suny.association.utils.JSONResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Comments:   基础公共Controller
 * Author:   孙建荣
 * Create Date: 2017/03/05 11:05
 */
@Controller
public class BaseController {
    
    private final IAccountService accountService;
    
    private final IMemberService memberService;
    
    @Autowired
    public BaseController(IMemberService memberService, IAccountService accountService) {
        this.memberService = memberService;
        this.accountService = accountService;
    }
    
    
    /**
     * 直接输入根目录的话就是直接跳转到登陆页面
     *
     * @return 登陆页面
     */
    @RequestMapping("/")
    public String indexPage() {
        return "Login";
    }
    
    /**
     * 进入到登陆页面
     *
     * @return 登陆的页面
     */
    @RequestMapping("/Login.html")
    public String getIndex() {
        return "/Login";
    }
    
    
    /**
     * 登陆成功后的跳转操作
     *
     * @return 管理页面
     * @throws Exception 反正就是异常
     */
    @RequestMapping("/AdminManager.html")
    public ModelAndView adminManager() throws Exception {
        return new ModelAndView("AdminManager");
    }
    
    
    /**
     * 强行访问没有权限的页面处理
     *
     * @return 错误页面
     */
    @RequestMapping(value = "/FailPage.html")
    public String failPage() {
        return "Error";
    }
    
    
    /**
     * 验证用户输入的情况
     *
     * @param username 登陆的用户名
     * @param password 登陆的用户密码
     * @return 经过shiro验证的结果
     */
    @RequestMapping(value = "/CheckLogin.json", method = RequestMethod.POST)
    @ResponseBody
    public JSONResultUtil checkLogin(String username, String password, String code,
                                     HttpServletRequest request) {
        if (!request.getSession().getAttribute("code").equals(code)) {
            return JSONResultUtil.failResult(LoginEnum.VALIDATE_CODE_ERROR);
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, DecryptUtil.encryptToMD5(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
                //通过账号表里面的memberId查询到一个成员的信息
                Account account = accountService.selectByUserName(username);
                Member member = memberService.selectById(account.getAccountMemberId());
                request.getSession().setAttribute("member", member);
            }
            
        } catch (Exception ex) {
            throw new BusinessException(LoginEnum.USERID_OR_PASSWORD_ERROR);
        }
        
        return JSONResultUtil.successResult(LoginEnum.LOGIN_SYSTEM);
    }
    
    /**
     * 退出登录
     */
    @RequestMapping(value = "/Logout.do", method = RequestMethod.GET)
    @ResponseBody
    public JSONResultUtil logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JSONResultUtil.successResult(LoginEnum.LOGOUT_SYSTEM_SUCCESS);
    }
    
    
}









