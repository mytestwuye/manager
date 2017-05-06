package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Permission;
import com.suny.association.service.interfaces.IPermissionService;
import com.suny.association.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.ConversionUtil.convertToBootstrapTableResult;
import static com.suny.association.utils.ConversionUtil.convertToCriteriaMap;
import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

/**
 * Comments:   权限具体的管理，不含权限的分配
 * Author:   孙建荣
 * Create Date: 2017/05/02 12:58
 */
@RequestMapping("/system/permission")
@Controller
public class PermissionController extends BaseController {

    private final IPermissionService permissionService;

    @Autowired
    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    /**
     * 插入一条账号信息
     *
     * @param permission 要插入的权限信息
     * @return 插入的json数据结果
     */
    @RequiresPermissions("system:permission:insert")
    @SystemControllerLog(description = "插入权限信息")
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Permission permission) {
        if (permission.getpermissionName().equals("") || permission.getpermissionName() == null) {
            return JsonResult.failResult(BaseEnum.FIELD_NULL);
        } else if (permissionService.queryByName(permission.getpermissionName()) != null) {
            return JsonResult.failResult(BaseEnum.REPEAT_ADD);
        }
        permissionService.insert(permission);
        return successResult(BaseEnum.ADD_SUCCESS);
    }


    /**
     * 新增权限页面
     *
     * @param modelAndView 模型数据跟视图
     * @return 新增权限页面
     */
    @RequiresPermissions("system:permission:insert")
    @RequestMapping(value = "/insert.html", method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        modelAndView.setViewName("system/permission/permissionInsert");
        return modelAndView;
    }

    /**
     * 删除一条账号信息请求
     *
     * @param permissionId 账号
     * @return 操作结果
     */
    @RequiresPermissions("system:permission:delete")
    @SystemControllerLog(description = "删除权限信息")
    @RequestMapping(value = "/deleteById.json/{permissionId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteById(@PathVariable("permissionId") int permissionId) {
        if (permissionService.queryPermissionQuote(permissionId).size() > 0) {
            return failResult(BaseEnum.HAVE_QUOTE);
        }
        if (permissionService.queryById(permissionId) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if (permissionId <= 37) return failResult(BaseEnum.SYSTEM_LIMIT);
        permissionService.deleteById(permissionId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    /**
     * 更新权限信息
     *
     * @param permission 权限信息
     * @return 更新数据的结果
     */
    @RequiresPermissions("system:permission:update")
    @SystemControllerLog(description = "更新权限信息")
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Permission permission) {
        if (permission.getpermissionId() < 37) {
            return failResult(BaseEnum.SYSTEM_LIMIT);
        }
        permissionService.update(permission);
        return successResult(BaseEnum.UPDATE_SUCCESS);
    }


    /**
     * 请求更新一个账号页面
     *
     * @param id           要更新信息的账号
     * @param modelAndView 模型数据跟视图地址
     * @return 模型数据跟视图地址
     */
    @RequiresPermissions("system:permission:update")
    @RequestMapping(value = "/update.html/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Permission permission = permissionService.queryById(id);
        modelAndView.addObject("permission", permission);
        modelAndView.setViewName("/system/permission/permissionUpdate");
        return modelAndView;
    }


    /**
     * 带查询条件的查询
     *
     * @param offset 从第几行开始查询
     * @param limit  查询几条数据
     * @param status 查询的账号状态
     * @return 带查询条件的结果集
     */
    @RequiresPermissions("system:permission:read")
    @SystemControllerLog(description = "查询所有的权限信息")
    @RequestMapping(value = "/queryAll.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryAll(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                        @RequestParam(value = "status", required = false, defaultValue = "3") int status) {
        int totalCount = permissionService.queryCount();
        Map<Object, Object> criteriaMap = convertToCriteriaMap(offset, limit, status);
        List<Permission> permissionList = permissionService.list(criteriaMap);
        return convertToBootstrapTableResult(permissionList, totalCount);
    }

    @RequiresPermissions("system:permission:read")
    @SystemControllerLog(description = "查看权限管理页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/system/permission/permissionList";
    }

}
