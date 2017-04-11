package com.suny.association.controller;

import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/list.json" ,method = RequestMethod.GET)
    @ResponseBody
    public Map query(@RequestParam(value = "offset",required = false,defaultValue = "0") int offset,
                     @RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        List<Roles> rolesList=rolesService.list(offset,limit);
        int total = rolesService.queryCount();
        Map tableDate = new HashMap();
        tableDate.put("rows", rolesList);
        tableDate.put("total", total);
        return tableDate;
    }

    @RequestMapping(value = "/index.html" ,method = RequestMethod.GET)
    public String index(){
        return "/accountInfo/role/roleList";
    }
}
