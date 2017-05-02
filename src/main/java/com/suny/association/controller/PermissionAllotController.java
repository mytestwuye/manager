package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Comments:   权限的具体分配，可用对角色进行分配指定权限
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:02
 */
@RequestMapping("/system/permission/allot")
@Controller
public class PermissionAllotController {


    @SystemControllerLog(description = "权限分配页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/system/permission/allot/permissionallot";
    }

}
