<%--suppress JSJQueryEfficiency --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/8
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>增加账号信息</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        .strongText {
            color: #ff0000;
        }
    </style>
</head>
<body>
<form class="form-line col-xs-10" style="padding: 25px; text-align: center">
    <label>
        <input name="account_id" value="" hidden>
    </label>

    <div class="form-group">
        <label for="account_name" class="col-sm-2 control-label">用户名【英文字母加数字的组合】<strong class="strongText">(必填)</strong></label>
        <input class="form-control " value="" id="account_name" name="account_name">
    </div>


    <div class="form-group">
        <label for="account_password" class="col-sm-2 control-label">账号密码<strong
                class="strongText">(选填，不填写则系统自动生成)</strong></label>
        <input class="form-control " value="" id="account_password" name="account_password">
    </div>
    <div class="form-group">
        <label for="selectRoleOption" class="col-sm-2 control-label">角色</label>
        <select class="form-control" id="selectRoleOption">
            <c:forEach items="${rolesList}" var="role">
                <option value="${role.roleId}">
                    <c:out value="${role.description}"/>
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="selectAccountStatusOption" class="col-sm-2 control-label">状态</label>
        <select class="form-control" id="selectAccountStatusOption" name="memberStatus">
            <option value="1">正常</option>
            <option value="0">冻结</option>

        </select>
    </div>
    <div class="form-group">
        <label for="account_phone" class="col-sm-2 control-label">绑定手机号码<strong class="strongText">(必填)</strong></label>
        <input class="form-control " value="" id="account_phone" name="account_phone">
    </div>

    <div class="form-group">
        <label for="account_email" class="col-sm-2 control-label">绑定邮箱<strong class="strongText">(必填)</strong></label>
        <input class="form-control " value="" id="account_email" name="account_email">
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button class="btn btn-danger" type="button" id="submit">点击新增一条账号信息</button>
        </div>
    </div>
</form>

</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    /**
     * 发送更新请求
     */
    $("#submit").click(
            function () {
                var selectRoleOptionVal = parseInt($("#selectRoleOption").val());
                var selectAccountStatusOptionVal = parseInt($("#selectAccountStatusOption").val());
                var accountPhoneVal = $("#account_phone").val();
                var accountEmailVal = $("#account_email").val();
                var accountPasswordVal = $("#account_password").val();
                var accountNameVal = $("#account_name").val();
                if (accountNameVal == '' || accountNameVal.length < 6) {
                    //noinspection JSDuplicatedDeclaration
                    var nowLength = parseInt(accountNameVal.length);
                    //noinspection JSDuplicatedDeclaration
                    var mustLength = 6 - nowLength;
                    layer.alert('用户名必须为英文，并且长度大于<span style="color:red;font-size: 22px">6</span>位,你当前输入的号码长度为为【<span style="color:red;font-size: 22px">' + nowLength + '</span>】位，至少还需要输入【<span style="color:red;font-size: 22px">' + mustLength + '</span>】位', {icon: 5});
                    $("#account_name").focus();
                    $('#account_name').css('border', '2px solid red');
                    return false;
                }
                else if (accountPhoneVal == '' || !/^1[34578]\d{9}$/.test(accountPhoneVal)) {
                    //noinspection JSDuplicatedDeclaration
                    var nowLength = parseInt(accountPhoneVal.length);
                    //noinspection JSDuplicatedDeclaration
                    var mustLength = 11 - nowLength;
                    $("#account_password").css('border', '');
                    $('#account_phone').focus();
                    $("#account_phone").css('border', '2px solid red');
                    if (mustLength > 0) {
                        layer.alert("手机号码必填,格式为【11位以13，14，15，17，18开头】的手机号码,你当前输入的号码长度为为【<span style='color:red;font-size: 22px'>" + nowLength + "</span>】位，还需要输入【<span style='color:red;font-size: 22px'>" + mustLength + "</span>】位", {icon: 5});
                    }
                    else {
                        layer.alert('手机号码格式有误', {icon: 5});
                    }
                    return false;
                }
                else if (accountEmailVal == '' || !/.+@.+\.[a-zA-Z]{2,4}$/.test(accountEmailVal)) {
                    $("#account_phone").css('border', '');
                    $("#account_email").focus();
                    $("#account_email").css('border', '2px solid red');
                    layer.alert('邮箱格式不正确', {icon: 5});
                    return false;
                }
                var flag = 1;
                var submitBtn = $("#submit");
                if (flag) {
                    $.ajax({
                        type: 'post',
                        cache: false,
                        dataType: 'json',  //数据传输格式
                        contentType: "application/json ; charset=utf-8",
                        url: '${basePath}/account/insert.json',
                        data: JSON.stringify({
                            accountName: accountNameVal,
                            accountPassword: accountPasswordVal,
                            accountPhone: accountPhoneVal,
                            accountEmail: accountEmailVal,
                            accountRoles: {
                                roleId: selectRoleOptionVal
                            },
                            accountStatus: selectAccountStatusOptionVal
                        }),
                        beforeSend: function () {
                            flag = 0;
                            submitBtn.attr("disabled", "true");
                            submitBtn.text("提交中，请勿重复提交");
                        },
                        success: function (result) {
                            $("#account_name").css('border', '');
                            $("#account_email").css('border', '');
                            $("#account_phone").css('border', '');
                            var statusCode = result.status;
                            if (statusCode == 202) {
                                //当你在iframe页面关闭自身时
                                window.parent.layer.alert('必要字段为空，请检查', {icon: 6});
                            }
                            else if (statusCode == 108) {
                                window.parent.layer.alert('用户名重复，请重新填写', {icon: 6});
                                $("#account_name").focus();
                                $('#account_name').css('border', '2px solid red');
                            }
                            else if (statusCode == 107) {
                                window.parent.layer.alert('手机号码重复，请重新填写', {icon: 6});
                                $("#account_name").css('border', '');
                                $("#account_phone").focus();
                                $('#account_phone').css('border', '2px solid red');
                            }
                            else if (statusCode == 106) {
                                window.parent.layer.alert('邮箱重复，请重新填写', {icon: 6});
                                $("#account_phone").css('border', '');
                                $("#account_email").focus();
                                $('#account_email').css('border', '2px solid red');
                            }
                            else if (result.status == 102) {
                                $("#account_email").css('border', '');
                                //当你在iframe页面关闭自身时
                                window.parent.layer.alert('新增成功了，刷新下页面看效果吧', {icon: 6});
                                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                parent.layer.close(index); //再执行关闭
                                refreshTable();
                            }
                            else {
                                window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});
                            }
                            flag = 0;
                            submitBtn.removeAttr("disabled");
                            submitBtn.text("点击添加");
                        },
                        error: function () {
                            flag = 0;
                            submitBtn.removeAttr("disabled");
                            submitBtn.text("点击添加");
                            window.parent.layer.msg('系统异常！', {icon: 5});
                        }
                    });
                }

            }
    );

    /**
     * 刷新表格
     */
    function refreshTable() {
        $("#mytab", window.parent.document).bootstrapTable("refresh");
    }
</script>
</html>