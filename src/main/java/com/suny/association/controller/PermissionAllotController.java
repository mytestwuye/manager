package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.pojo.po.Permission;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IPermissionAllotService;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Comments:   权限的具体分配，可用对角色进行分配指定权限
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:02
 */
@RequestMapping("/system/permission/allot")
@Controller
public class PermissionAllotController {

    private final IRolesService rolesService;

    private final IPermissionAllotService permissionAllotService;

    @Autowired
    public PermissionAllotController(IRolesService rolesService, IPermissionAllotService permissionAllotService) {
        this.rolesService = rolesService;
        this.permissionAllotService = permissionAllotService;
    }

    @SystemControllerLog(description = "指定角色权限分配")
    @RequestMapping("/update.html/{roleId}")
    public ModelAndView update(@PathVariable("roleId") int roleId, ModelAndView modelAndView) {
        List<Permission> permissionList = permissionAllotService.queryByRoleId(roleId);
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("system/permission/allot/rolePermissionAllot");
        return modelAndView;
    }


    @SystemControllerLog(description = "权限分配页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        List<Roles> roleList = rolesService.queryAll();
        List<PermissionAllot> permissionAllotList = permissionAllotService.queryAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.addObject("permissionAllotList", permissionAllotList);
        modelAndView.setViewName("system/permission/allot/permissionAllot");
        return modelAndView;
    }

}
