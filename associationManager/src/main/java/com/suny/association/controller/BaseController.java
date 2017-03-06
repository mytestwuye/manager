package com.suny.association.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/05 11:05
 */
@Controller
public class BaseController {

    @RequestMapping("/index.html")
    public String hello() {
        return "/index.jsp";
    }
}
