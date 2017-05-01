package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IRolesService;
import com.suny.association.utils.ConversionUtil;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

/**
 * Comments:  账号角色控制器
 * Author:   孙建荣
 * Create Date: 2017/04/11 18:15
 */
@Controller
@RequestMapping("/account/role")
public class RoleController {

    private final IRolesService rolesService;

    @Autowired
    public RoleController(IRolesService rolesService) {
        this.rolesService = rolesService;
    }

    @SystemControllerLog(description = "删除账号角色")
    @RequestMapping(value = "/delete.json/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(@PathVariable("roleId") Integer roleId) {
        if (rolesService.queryQuote(roleId).size() >= 1) {
            return failResult(BaseEnum.HAVE_QUOTE);
        } else if (rolesService.queryById(roleId) == null) {
            return failResult(BaseEnum.DELETE_FAILURE);
        }
        rolesService.deleteById(roleId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    @SystemControllerLog(description = "更新账号角色")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public JsonResult update(@RequestBody Roles roles) {
        if (roles.getRoleId() == null || rolesService.queryById(roles.getRoleId()) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if ("".equals(roles.getDescription()) || roles.getDescription() == null) {
            return failResult(BaseEnum.FIELD_NULL);
        }
        rolesService.update(roles);
        return successResult(BaseEnum.UPDATE_SUCCESS);
    }


    @RequestMapping(value = "/update.html/{roleId}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable int roleId
            , ModelAndView modelAndView) {
        Roles role = rolesService.queryById(roleId);
        if (role == null) {
            int DEFAULT_ID = 0;
            role = rolesService.queryById(DEFAULT_ID);
            modelAndView.addObject("role", role);
            return modelAndView;
        }
        modelAndView.addObject("role", role);
        modelAndView.setViewName("/accountInfo/role/roleUpdate");
        return modelAndView;
    }


    /**
     * 插入数据请求
     *
     * @param roles 数据
     * @return 插入数据的结果
     */
    @SystemControllerLog(description = "新增账号角色")
    @ResponseBody
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public JsonResult insert(@RequestBody Roles roles) {
        if ("".equals(roles.getDescription()) || roles.getDescription() == null) {
            return failResult(BaseEnum.FIELD_NULL);
        }
        if (rolesService.queryByName(roles.getDescription()) != null) {
            return failResult(BaseEnum.REPEAT_ADD);
        }
        rolesService.insert(roles);
        return successResult(BaseEnum.ADD_SUCCESS);
    }

    @RequestMapping(value = "/insert.html", method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/accountInfo/role/roleInsert");
        return modelAndView;
    }

    /**
     * 带查询条件的查询
     *
     * @param offset 从第几条记录开始查询
     * @param limit  查询几条数据
     * @return 带查询条件的数据
     */
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Roles> rolesList = rolesService.list(ConversionUtil.convertToCriteriaMap(offset, limit));
        int total = rolesService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(rolesList, total);
    }

    @SystemControllerLog(description = "查看账号角色页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/accountInfo/role/roleList";
    }
}
