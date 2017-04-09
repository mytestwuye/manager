<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/7
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑信息</title>
    <link href="${pageContext.request.contextPath}/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
</head>
<body>
<form class="form-line col-xs-10" style="padding: 25px; text-align: center" >
    <label>
        <input name="account_id" value="${account.accountId}" hidden>
    </label>

    <div class="form-group">
        <label for="account_name" class="col-sm-2 control-label">用户名</label>
        <input class="form-control " value="${account.accountName}" id="account_name" name="account_name" >
    </div>
    <div class="form-group">
        <label for="selectRoleOption" class="col-sm-2 control-label">角色</label>
        <select class="form-control" id="selectRoleOption">
            <c:forEach items="${rolesList}" var="role">
                <option value="${role.roleId}">
                    <c:out value="${role.roleName}"/>
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
        <label for="account_phone" class="col-sm-2 control-label">绑定手机号码</label>
        <input class="form-control " value="${account.accountPhone}" id="account_phone" name="account_phone">
    </div>

    <div class="form-group">
        <label for="account_email" class="col-sm-2 control-label">绑定邮箱</label>
        <input class="form-control " value="${account.accountEmail}" id="account_email" name="account_email">
    </div>


    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button class="btn btn-danger"  type="button" id="submit" >点击修改</button>
        </div>
    </div>
</form>

</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/BootstrapMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/device.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
<script>
    $(function () {
        //选中成员当前自己的所属角色
        $("#selectRoleOption").each(function () {
            $("#selectRoleOption").val(${account.accountRoles.roleId});
        });
        //选中账号状态
        $("#selectAccountStatusOption").each(function () {
            $("#selectAccountStatusOption").val(accountStatus);
        });
    });

    var accountStatus = ${account.accountStatus} == "1"? 1:0;

    /**
     * 发送更新请求
     */
    $("#submit").click(
            function() {
                console.log("plan to send ajax ");
                var selectRoleOptionVal = parseInt($("#selectRoleOption").val());
                var selectAccountStatusOptionVal = parseInt($("#selectAccountStatusOption").val());
                var accountPhoneVal = $("#account_phone").val();
                var accountEmailVal = $("#account_email").val();
                $.ajax({
                    type: 'post',
                    cache: false,
                    dataType:'json',  //数据传输格式
                    contentType : "application/json ; charset=utf-8",
                    url: '${pageContext.request.contextPath}/account/update.json',
                    data: JSON.stringify({
                        accountId: ${account.accountId},
                        accountName: '${account.accountName}',
                        accountPhone: accountPhoneVal,
                        accountEmail: accountEmailVal,
                        accountRoles: {
                            roleId: selectRoleOptionVal
                        },
                        accountStatus: selectAccountStatusOptionVal
                    }),
                    success: function (result) {
                        if (result.status == 203) {
                            //当你在iframe页面关闭自身时
                            window.parent.layer.alert('更新成功了，刷新下页面看效果吧', {icon: 6});
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            refreshTable();
                            return;
                        }
                        window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});

                    },
                    error: function (result) {
                        if (result.status == 0) {
                            window.parent.layer.msg('系统异常', {icon: 5});
                        }
                    }
                })
            }
    )

    /**
     * 刷新表格
     */
    function refreshTable() {
        $("#mytab", window.parent.document).bootstrapTable("refresh");
    }
</script>
</html>