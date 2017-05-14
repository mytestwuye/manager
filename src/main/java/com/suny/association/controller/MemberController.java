package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IDepartmentService;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.ConversionUtil;
import com.suny.association.utils.CustomDate;
import com.suny.association.utils.JsonResult;
import com.suny.association.utils.ValidActionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Comments:   成员信息管理类Controller
 * Author:   孙建荣
 * Create Date: 2017/03/15 20:46
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    private final IMemberService memberService;

    private final IDepartmentService departmentService;

    private final IMemberRolesService memberRolesService;

    private final IAccountService accountService;


    @Autowired
    public MemberController(IDepartmentService departmentService, IMemberService memberService, IMemberRolesService memberRolesService, IAccountService accountService) {
        this.departmentService = departmentService;
        this.memberService = memberService;
        this.memberRolesService = memberRolesService;
        this.accountService = accountService;
    }


    /**
     * 插入成员信息操作
     *
     * @param member 成员信息
     * @return 插入的结果
     */
    @SystemControllerLog(description = "插入成员信息")
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Member member) {
        if (member.getMemberName() == null || "".equals(member.getMemberName())) {
            return JsonResult.failResult(BaseEnum.FIELD_NULL);
        } else if ("".equals(member.getMemberClassName()) || member.getMemberClassName() == null) {
            return JsonResult.failResult(BaseEnum.FIELD_NULL);
        }
        if (!(ValidActionUtil.isContainChinese(member.getMemberName()))) {
            return JsonResult.failResult(BaseEnum.MUST_CHINESE);
        }
        memberService.insert(member);
        return JsonResult.successResult(BaseEnum.ADD_SUCCESS);
    }


    /**
     * 进行新增成员信息页面
     *
     * @param modelAndView 带有数据库的数据模型
     * @return 数据跟视图地址
     */
    @SystemControllerLog(description = "新增成员页面")
    @RequestMapping(value = "/insertPage.html", method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        List<Member> managerList = memberService.queryNormalManager();
        List<Department> departmentList = departmentService.queryAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryAll();
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.addObject("memberGradeList", CustomDate.getLastYearAndThisYears());
        modelAndView.setViewName("memberInfo/memberInsert");
        return modelAndView;
    }

    @SystemControllerLog(description = "通过Excel文件批量新增数据")
    @RequestMapping(value = "/uploadMemberInfo.json", method = RequestMethod.POST)
    public JsonResult uploadMemberInfo(@RequestParam("excelFile") MultipartFile excelFile) {
        if (excelFile == null) {
            return null;
        }
        String fileType = excelFile.getContentType();
        if (!Objects.equals(fileType, "xls")) {
            return null;
        }
        String name = excelFile.getName();
        return JsonResult.successResult(BaseEnum.SELECT_FAILURE);
    }


    @SystemControllerLog(description = "上传成员数据页面")
    @RequestMapping(value = "/uploadMemberInfo.html", method = RequestMethod.GET)
    public String uploadMemberInfoPage() {
        return "memberInfo/memberInfoUpdate";
    }


    @SystemControllerLog(description = "删除成员信息")
    @RequestMapping(value = "/deleteById.json/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteById(@PathVariable("id") Long id) {
        if (memberService.queryByLongId(id) == null) {
            return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
        }
        if (accountService.queryQuoteByMemberId(id) != null) {
            return JsonResult.failResult(BaseEnum.HAVE_QUOTE);
        }
        memberService.deleteByLongId(id);
        return JsonResult.successResult(BaseEnum.DELETE_SUCCESS);
    }

    @SystemControllerLog(description = "更新成员信息")
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Member member) {
        if (member.getMemberName() == null || "".equals(member.getMemberName())) {
            return JsonResult.failResult(BaseEnum.FIELD_NULL);
        }
        if (!member.getMemberStatus()) {
            return JsonResult.failResult(BaseEnum.FIELD_NULL);
        }
        memberService.update(member);
        return JsonResult.successResult(BaseEnum.UPDATE_SUCCESS);
    }

    @RequestMapping(value = "/update.html/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.queryById(id);
        List<Member> managerList = memberService.queryNormalManager();
        List<Department> departmentList = departmentService.queryAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryAll();
        modelAndView.addObject("member", member);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.setViewName("memberInfo/memberUpdate");
        return modelAndView;
    }

    @SystemControllerLog(description = "查询冻结的成员")
    @RequestMapping(value = "/queryFreeze.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult queryFreeze() {
        List<Member> memberList = memberService.queryNormalMember();
        if (memberList != null) {
            return JsonResult.successResultAndData(BaseEnum.SELECT_SUCCESS, memberList);
        }
        return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
    }

    @SystemControllerLog(description = "查询正常的成员")
    @RequestMapping(value = "/queryNormal.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult queryNormal() {
        List<Member> memberList = memberService.queryNormalMember();
        if (memberList != null) {
            return JsonResult.successResultAndData(BaseEnum.SELECT_SUCCESS, memberList);
        }
        return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
    }

    @RequestMapping(value = "/queryAll.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryAll(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                        @RequestParam(value = "departmentname", required = false) String departmentname,
                                        @RequestParam(value = "status", required = false) int status) {
        Map<Object, Object> tableDate = new HashMap<>();
        if ("".equals(departmentname)) {
            departmentname = null;
        }
        List<Member> memberList = memberService.list(ConversionUtil.convertToCriteriaMap(offset, limit, departmentname, status));
        if (memberList.size() != 0 && !memberList.isEmpty()) {
            int total = memberService.queryCount();
            tableDate.put("rows", memberList);
            tableDate.put("total", total);
            return tableDate;
        }
        tableDate.put("rows", null);
        tableDate.put("total", 0);
        return tableDate;
    }

    @SystemControllerLog(description = "查询指定成员")
    @RequestMapping(value = "/queryById.do/{memberId}", method = RequestMethod.GET)
    public JsonResult queryById(@PathVariable("memberId") Integer memberId) {
        Member member = memberService.queryById(memberId);
        return JsonResult.successResultAndData(BaseEnum.SELECT_SUCCESS, member);
    }

    @SystemControllerLog(description = "查看成员管理页面")
    @RequestMapping(value = "/memberManager.html", method = RequestMethod.GET)
    public String managerPage() {
        return "memberInfo/memberManager";
    }

}
