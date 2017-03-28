package com.suny.association.controller;

import com.suny.association.enums.LoginEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.utils.EncryptUtil;
import com.suny.association.utils.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Comments:   基础公共Controller
 * Author:   孙建荣
 * Create Date: 2017/03/05 11:05
 */
@Controller
@RequestMapping("/base")
public class LoginController {
    
    private final IAccountService accountService;
    
    @Autowired
    public LoginController(IAccountService accountService) {
        this.accountService = accountService;
    }
    
    
    @RequestMapping("/loginPage.html")
    public ModelAndView loginPage() {
        return new ModelAndView("/loginPage");
    }
    
    
    @RequestMapping(value = "/errorPage.html")
    public ModelAndView errorPage() {
        return new ModelAndView("/errorPage");
    }
    
    
    @RequestMapping(value = "/loginAction.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginAction(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("formCode") String formCode,
                                  HttpServletRequest request) {
        String sessionCode = (String) request.getSession().getAttribute("code");
        if (!matchCode(formCode, sessionCode)) {
            return JsonResult.failResult(LoginEnum.VALIDATE_CODE_ERROR);
        }
        authAction(username, password);
        saveLoginUser(request, username);
        return JsonResult.successResult(LoginEnum.LOGIN_SYSTEM);
    }
    
    
    private boolean matchCode(String formCode, String sessionCode) {
        return !formCode.equals("") && sessionCode.equals(formCode);
    }
    
    private void authAction(String username, String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, EncryptUtil.encryptToMD5(password));
            Subject currentUser = SecurityUtils.getSubject();
            //如果还没有登录就 //使用shiro来验证
            if (!currentUser.isAuthenticated()) {
                token.setRememberMe(true);
                currentUser.login(token);      //验证角色和权限
            }
            else{
                throw new BusinessException(LoginEnum.REPEAT_LOGIN);
            }
        } catch (Exception ex) {
            throw new BusinessException(LoginEnum.UNDERPASS_ERROR);
        }
    }
    
    private void saveLoginUser(HttpServletRequest request, String username) {
        Member member = accountService.queryByName(username).getAccountMember();
        request.getSession().setAttribute("member", member);
    }
    
    
    @RequestMapping("/goAdminPage.html")
    public ModelAndView goAdminPage() throws Exception {
        return new ModelAndView("adminManager");
    }
    
    
    @RequestMapping(value = "/logoutAction.do", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult logoutAction() {
        SecurityUtils.getSubject().logout();
        return JsonResult.successResult(LoginEnum.LOGOUT_SUCCESS);
    }
    
    
}









