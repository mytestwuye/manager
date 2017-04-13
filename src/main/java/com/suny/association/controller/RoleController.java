package com.suny.association.controller;

import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IRolesService;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

/**
 * Comments:
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

    @RequestMapping(value = "/delete.json/{roleId}",method = RequestMethod.GET)
    public JsonResult delete(@PathVariable Integer roleId){
        if(rolesService.queryQuote(roleId).size() >= 1){
            return failResult(BaseEnum.HAVA_QUOTE);
        }
        else if(rolesService.queryById(roleId) == null ){
            return failResult(BaseEnum.DELETE_FAILURE);
        }
        rolesService.deleteById(roleId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    @ResponseBody
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public JsonResult update(@RequestBody Roles roles) {
        if (roles.getRoleId() == null || rolesService.queryById(roles.getRoleId()) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if ("".equals(roles.getRoleName()) || roles.getRoleName() == null) {
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
        modelAndView.addObject("role",role);
        modelAndView.setViewName("/accountInfo/role/roleUpdate");
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public JsonResult insert(@RequestBody Roles roles) {
        if ("".equals(roles.getRoleName()) || roles.getRoleName() == null) {
            return failResult(BaseEnum.FIELD_NULL);
        }
        if (rolesService.queryByName(roles.getRoleName()) != null) {
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

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Roles> rolesList = rolesService.list(offset, limit);
        int total = rolesService.queryCount();
        Map<String, Object> tableDate = new HashMap<>();
        tableDate.put("rows", rolesList);
        tableDate.put("total", total);
        return tableDate;
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/accountInfo/role/roleList";
    }
}
