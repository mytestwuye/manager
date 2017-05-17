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
import com.suny.association.utils.*;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comments:   成员信息管理类Controller
 * Author:   孙建荣
 * Create Date: 2017/03/15 20:46
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

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
    public JsonResult uploadMemberInfo(@RequestParam("excelFile") MultipartFile excelFile) throws IOException {
        String fileType = excelFile.getContentType();
        /*  获取上传文件名 */
        String fileName = ((CommonsMultipartFile) excelFile).getFileItem().getName();
        /* 获取上传文件名的文件后缀名    */
        String fileExtension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
        CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) excelFile;
        DiskFileItem diskFileItem = (DiskFileItem) commonsMultipartFile.getFileItem();
        File file = diskFileItem.getStoreLocation();
        /* 获取文件名的后缀名，检查是否存在欺骗   */
        if (!ExcelUtils.parseExcelFileType(fileType, fileExtension)) {
            logger.warn("上传的文件貌似有点小问题，可能是后缀名欺骗");
//            return JsonResult.failResult(BaseEnum.FILE_EXTENSION_WARN);
//            return "memberInfo/memberManager";
        }
        /* 查看成功插入的行数  */
        int successRow = memberService.batchInsertFromExcel(file, fileExtension);
//        return "memberInfo/memberManager";
        logger.info("开始返回json");
        return JsonResult.successResult(BaseEnum.SELECT_FAILURE);
    }


    /**
     * 下载成员信息模板，上传者要按照模板的要求进行修改Excel文档，否则系统将忽略上传请求
     *
     * @param request  request请求
     * @param response response请求
     */
    @RequestMapping(value = "downloadMemberTemplate.json", method = RequestMethod.GET)
    public void downloadMemberTemplate(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "memberTemplate.xlsx";
        ServletContext servletContext = request.getServletContext();
        /*  获取放置模板文件的目录    */
        String realPath = servletContext.getRealPath("/WEB-INF/template");
        /*  得到一个真实的文件存放地址，代表一个文件 */
        Path file = Paths.get(realPath, fileName);
        /* 判断文件是否存在，否则会发生异常   */
        if (Files.exists(file)) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            try {
                logger.info("正在向客户端输出成员信息Excel模板");
                Files.copy(file, response.getOutputStream());
            } catch (IOException e) {
                logger.error("捕获了异常，向客户端发送Excel文件时发生错误");
                e.printStackTrace();
            }
        }
        logger.warn("要下载的文件{}不存在", fileName);
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
