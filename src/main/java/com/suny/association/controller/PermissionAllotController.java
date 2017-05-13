package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Permission;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IPermissionAllotService;
import com.suny.association.service.interfaces.IPermissionService;
import com.suny.association.service.interfaces.IRolesService;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Comments:   权限的具体分配，可用对角色进行分配指定权限
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:02
 */
@RequestMapping("/system/permission/allot")
@Controller
public class PermissionAllotController extends BaseController {

    private final IRolesService rolesService;

    private final IPermissionAllotService permissionAllotService;

    private final IPermissionService permissionService;

    @Autowired
    public PermissionAllotController(IRolesService rolesService, IPermissionAllotService permissionAllotService, IPermissionService permissionService) {
        this.rolesService = rolesService;
        this.permissionAllotService = permissionAllotService;
        this.permissionService = permissionService;
    }


    @SystemControllerLog(description = "【修改权限】删除权限后增加权限")
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestParam(value = "permissionArray[]") Integer[] permissionArray, Integer roleId) {

        if (rolesService.queryById(roleId) != null) {
            //  在修改权限之前先把角色所有的权限先清除
            if (permissionAllotService.queryByRoleId(roleId).size() > 0) {
                permissionAllotService.deleteById(roleId);
            }
            // 假如数组里面只有9999的话说明删除所有权限
            if (permissionArray[0] == 9999) {
                return JsonResult.successResult(BaseEnum.UPDATE_SUCCESS);
            }
            // 实例化一个【权限角色中间表】实体对象
            PermissionAllot pa = new PermissionAllot();
            //  实例化一个LIst来装权限的集合
            List<Permission> perList = new ArrayList<>();
            //  实例化一个角色
            Roles r = new Roles();
            //   给角色实体设置角色id
            r.setRoleId(roleId);
            //    给【权限角色中间表】实体对象添加角色属性
            pa.setRoleId(r);
            for (Integer aPermissionArray : permissionArray) {
                //   循环实例化一个权限实体，然后填充数据，最后添加到权限lIst里面去
                Permission per = new Permission();
                per.setpermissionId(aPermissionArray);
                perList.add(per);
            }
            // 把权限集合设置到【权限角色中间表】实体对象中
            pa.setPermissionArrayList(perList);
            permissionAllotService.insert(pa);
            return JsonResult.successResult(BaseEnum.UPDATE_SUCCESS);

        }
        return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
    }

    @SystemControllerLog(description = "指定角色权限分配")
    @RequestMapping(value = "/update.html/{roleId}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("roleId") int roleId, ModelAndView modelAndView) {
        //  查询一个角色对应的权限
        List<PermissionAllot> permissionList = permissionAllotService.queryByRoleId(roleId);
        //    查询数据库所有的权限
        List<Permission> permissions = permissionService.queryAll();
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("permissions", permissions);
        modelAndView.setViewName("system/permission/allot/rolePermissionAllot");
        return modelAndView;
    }

    @SystemControllerLog(description = "查看权限分配页面")
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
