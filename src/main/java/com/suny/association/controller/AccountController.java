package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.service.interfaces.IRolesService;
import com.suny.association.utils.JsonResult;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.suny.association.utils.ConversionUtil.convertToBootstrapTableResult;
import static com.suny.association.utils.ConversionUtil.convertToCriteriaMap;
import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

/**
 * Comments:   账号控制器
 * Author:   孙建荣
 * Create Date: 2017/03/22 22:12
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AccountController.class);
    private final IAccountService accountService;
    private final IMemberService memberService;
    private final IRolesService rolesService;

    @Autowired
    public AccountController(IAccountService accountService, IMemberService memberService, IRolesService rolesService) {
        this.accountService = accountService;
        this.memberService = memberService;
        this.rolesService = rolesService;
    }

    /**
     * 插入一条账号信息
     *
     * @param account 要插入的账号信息
     * @return 插入的json数据结果
     */
    @SystemControllerLog(description = "插入账号信息")
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Account account) {
        Map resultMap = updateOrInsert(account);
        if (!(Boolean) resultMap.get("status")) {
            return (JsonResult) resultMap.get("result");
        }
        if ("".equals(account.getAccountPassword())) {
            account.setAccountPassword(null);
        }
        accountService.insert(account);
        return successResult(BaseEnum.ADD_SUCCESS);
    }


    /**
     * 新增账号页面
     *
     * @param modelAndView 模型数据跟视图
     * @return 新增账号页面
     */
    @RequestMapping(value = "/insert.html", method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        List<Account> account = accountService.queryAll();
        List<Member> memberList = memberService.queryAll();
        List<Roles> rolesList = rolesService.queryAll();
        modelAndView.addObject("account", account);
        modelAndView.addObject("memberList", memberList);
        modelAndView.addObject("rolesList", rolesList);
        modelAndView.setViewName("accountInfo/accountInsert");
        return modelAndView;
    }


    /**
     * 删除一条账号信息请求
     *
     * @param accountId 账号
     * @return 操作结果
     */
    @SystemControllerLog(description = "删除账号信息")
    @RequestMapping(value = "/deleteById.json/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteById(@PathVariable("accountId") Long accountId) {
        Account accountQuote = accountService.queryQuoteByAccountId(accountId);
        if (accountQuote != null && (null != accountQuote.getAccountMember())) {
            return failResult(BaseEnum.HAVE_QUOTE);
        }
        if (accountService.queryByLongId(accountId) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        accountService.deleteByLongId(accountId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    /**
     * 插入账号 || 更新账号信息 通用的验证
     *
     * @param account 账号信息
     * @return 验证结果，是一个map，包含枚举结果跟Boolean类型验证结果
     */
    private Map updateOrInsert(Account account) {
        Map<Object, Object> resultMap = new HashMap<>();
        Account byNameResult = accountService.queryByName(account.getAccountName());
        Account byPhoneResult = accountService.queryByPhone(account.getAccountPhone());
        Account byMailResult = accountService.queryByMail(account.getAccountEmail());
        if ("".equals(account.getAccountName()) || (account.getAccountName() == null)) {
            resultMap.put("result", failResult(BaseEnum.FIELD_NULL));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byNameResult && !Objects.equals(byNameResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_USERNAME));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byPhoneResult && !Objects.equals(byPhoneResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_PHONE));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byMailResult && !Objects.equals(byMailResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_EMAIL));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        resultMap.put("status", Boolean.TRUE);
        return resultMap;
    }


    /**
     * 更新账号信息
     *
     * @param account 账号实体信息
     * @return 更新数据的结果
     */
    @SystemControllerLog(description = "更新账号信息")
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Account account) {
        Map resultMap = updateOrInsert(account);
        Account byIdResult = accountService.queryByLongId(account.getAccountId());
        if (byIdResult == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if (!(Boolean) resultMap.get("status")) {
            return (JsonResult) resultMap.get("result");
        }
        accountService.update(account);
        return successResult(BaseEnum.UPDATE_SUCCESS);
    }

    /**
     * 请求更新一个账号页面
     *
     * @param id           要更新信息的账号
     * @param modelAndView 模型数据跟视图地址
     * @return 模型数据跟视图地址
     */
    @RequestMapping(value = "/update.html/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        //    获取shiro认证后的身份信息
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isPermitted("account:read")) {
        System.out.println("有【account:read 读取账号信息页面】这个权限");
              /*         这里是项目的代码，非测试代码             */
        Account account = accountService.queryById(id);
        List<Member> memberList = memberService.queryAll();
        List<Roles> rolesList = rolesService.queryAll();
        modelAndView.addObject("account", account);
        modelAndView.addObject("memberList", memberList);
        modelAndView.addObject("rolesList", rolesList);
        modelAndView.setViewName("/accountInfo/accountUpdate");
        return modelAndView;
//        } else {
        // 没有权限就手动抛出shiro里面的一个没有权限的异常，仅作测试
//            throw new UnauthorizedException();
//        }
    }

    @SystemControllerLog(description = "查看账号管理页面")
    @RequestMapping(value = "/accountManager.html", method = RequestMethod.GET)
    public String index() {
        //    获取shiro认证后的身份信息
//        Subject subject = SecurityUtils.getSubject();
        //     使用编程式的shiro判断是否有权限，有权限则进入管理页面
//        if (subject.isPermitted("account:read")) {
        return "accountInfo/accountManager";
//        }
        // 没有权限就手动抛出shiro里面的一个没有权限的异常，仅作测试
//        throw new UnauthorizedException();
    }


    /**
     * 带查询条件的查询
     *
     * @param offset 从第几行开始查询
     * @param limit  查询几条数据
     * @param status 查询的账号状态
     * @return 带查询条件的结果集
     */
    @SystemControllerLog(description = "查询账号信息")
    @RequestMapping(value = "/queryAll.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryAll(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                        @RequestParam(value = "status", required = false, defaultValue = "3") int status) {
        int totalCount = accountService.queryCount();
        Map<Object, Object> criteriaMap = convertToCriteriaMap(offset, limit, status);
        List<Account> accountList = accountService.list(criteriaMap);
        return convertToBootstrapTableResult(accountList, totalCount);
    }


    /**
     * 修改自己账号的密码
     *
     * @param request     request请求
     * @param accountId   请求修改密码账号的Id
     * @param passWord    原始密码
     * @param newPassword 新密码
     * @return 修改密码的结果，要进行很多业务逻辑的判断
     */
    @RequestMapping("/changePassword.json")
    public JsonResult changePassword(HttpServletRequest request,
                                     @RequestParam Long accountId,
                                     @RequestParam String passWord,
                                     @RequestParam String newPassword) {
        Account account = (Account) request.getSession().getAttribute("account");
        if (account.getAccountId().equals(accountId)) {
            if ("".equals(passWord) || "".equals(newPassword)) {
                logger.warn("两个密码不能为空，必须都有值");
                return JsonResult.failResult(BaseEnum.FIELD_NULL);
            }
            if (passWord.length() < 9 || newPassword.length() < 9) {
                logger.warn("207字段的长度有错误，密码强制性必须大于9位");
                return JsonResult.failResult(BaseEnum.FIELD_LENGTH_WRONG);
            }
            Account databaseAccount = accountService.queryByLongId(accountId);
            if (databaseAccount == null) {
                logger.error("数据库不存在要更改密码的账号,可能存在用户恶意修改密码风险");
                return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
            } else {
                if (!account.getAccountPassword().equals(passWord)) {
                    logger.warn("208, 输入的原密码跟数据库的原密码不一致");
                    return JsonResult.failResult(BaseEnum.OLD_PASSWORD_WRONG);
                } else if (passWord.equals(newPassword)) {
                    logger.warn("209,两次密码一样");
                    return JsonResult.failResult(BaseEnum.TWICE_PASSWORD_EQUALS);
                } else {
                    int successNum = accountService.changePassword(accountId, newPassword);
                    if (successNum == 1) {
                        logger.info("更新密码成功");
                        return JsonResult.successResult(BaseEnum.UPDATE_SUCCESS);
                    }
                    logger.warn("更新密码失败");
                    return JsonResult.successResult(BaseEnum.UPDATE_FAILURE);
                }
            }
        }
        logger.info("session中的账号跟要修改的账号ID不一样，恶意修改密码");
        return JsonResult.failResult(BaseEnum.MALICIOUS_OPERATION);
    }


    @SystemControllerLog(description = "查看个人中心")
    @RequestMapping(value = "/getUserInfo.html", method = RequestMethod.GET)
    public ModelAndView getUserInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/userInfo");
        return modelAndView;
    }


}
