package com.suny.association.controller;

import com.suny.association.enums.ErrorCode;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.utils.DecriptUtils;
import com.suny.association.utils.JSONUtils;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/05 11:05
 */
@Controller
public class BaseController {
    
    @Autowired
    private IAccountService accountService;
    
    @Autowired
    private AccountMapper accountMapper;
    
    @RequestMapping(value = "/archives-manager.html")
    public String systemConfig(){
        return "/admin/archives-manager";
    }
    
    @RequestMapping(value = "/crud.html")
    public String crud(){
        return "/admin/crud";
    }
    
    /**
     * 进入到主页面
     *
     * @param request 请求参数
     * @return 页面
     * @throws Exception
     */
    @RequestMapping("/")
    public ModelAndView getIndex(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView("redirect:login.jsp");
        return modelAndView;
    }
    
    
    //跳转到登录页面
    @RequestMapping("/login")
    public ModelAndView login() throws Exception {
        ModelAndView mav = new ModelAndView("/login.jsp");
        return mav;
    }
    
    //跳转到登录成功页面
    @RequestMapping("/loginsuccess.html")
    public ModelAndView loginsuccess() throws Exception {
        ModelAndView mav = new ModelAndView("loginsuccess");
        return mav;
    }
    
    
    /**
     * 验证用户名和密码
     *
     * @return
     */
    @RequestMapping(value = "/checkLogin.json", method = RequestMethod.POST)
    @ResponseBody
    public String checkLogin(String username, String password) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, DecriptUtils.encryptToMD5(password));
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()) {
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
            }
        } catch (Exception ex) {
            System.out.println("查询出了点问题");
            throw new BusinessException(ErrorCode.LOGIN_VERIFY_FAILURE);
        }
        result.put("success", true);
        return JSONUtils.toJson(result);
    }
    
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public String logout() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JSONUtils.toJson(result);
    }
    
    
}









