<%--suppress JSJQueryEfficiency --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/5/2
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
    <title>增加权限</title>
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
        <a href="#" onclick="showShiroExample()">点击查看权限名实例</a>
    </label>

    <div class="form-group">
        <label for="permission_name" class="col-sm-2 control-label">权限名【必须为英文,符合shiro的规则】<strong
                class="strongText">(必填)</strong></label>
        <input class="form-control " value="" id="permission_name" name="permission_name">
    </div>


    <div class="form-group">
        <label for="permission_description" class="col-sm-2 control-label">权限中文解释<strong
                class="strongText">(选填，建议填写)</strong></label>
        <input class="form-control " value="" id="permission_description" name="permission_description">
    </div>
    <div class="form-group">
        <label for="permission_status" class="col-sm-2 control-label">状态</label>
        <select class="form-control" id="permission_status" name="permission_status">
            <option value="1">正常</option>
            <option value="0">冻结</option>

        </select>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button class="btn btn-danger" type="button" id="submit">点击添加一个权限信息</button>
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
                var permissionNameVal = $("#permission_name").val();
                var permissionDescriptionVal = $("#permission_description").val();
                var permissionStatusVal = parseInt($("#permission_status").val());
                var reg = /^[a-zA-Z:]+$/;
                if (!reg.test(permissionNameVal)) {
                    layer.alert('权限名必须为英文');
                    $("#permission_name").focus();
                    $('#permission_name').css('border', '2px solid red');
                    return false;
                }
                $('#permission_name').css('border', '');
                $.ajax({
                    type: 'post',
                    cache: false,
                    dataType: 'json',  //数据传输格式
                    contentType: "application/json; charset=utf-8",
                    url: '${basePath}/system/permission/insert.json',
                    data: JSON.stringify({
                        permissionName: permissionNameVal,
                        description: permissionDescriptionVal,
                        permissionStatus: permissionStatusVal
                    }),
                    success: function (result) {
                        $("#permissionName").css('border', '');
                        $("#description").css('border', '');
                        $("#permissionStatus").css('border', '');
                        var statusCode = result.status;
                        if (statusCode == 202) {
                            //当你在iframe页面关闭自身时
                            window.parent.layer.alert('必要字段为空，请检查', {icon: 6});
                        }
                        else if (statusCode == 006) {
                            window.parent.layer.alert('权限名重复，请重新填写', {icon: 6});
                            $("#permissionName").focus();
                            $('#permissionName').css('border', '2px solid red');
                        }
                        else if (result.status == 102) {
                            $("#permissionName").css('border', '');
                            //当你在iframe页面关闭自身时
                            window.parent.layer.alert('新增成功了，刷新下页面看效果吧', {icon: 6});
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            refreshTable();
                        }
                        else {
                            window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});
                        }
                    },
                    error: function () {
                        window.parent.layer.msg('系统异常！', {icon: 5});
                    }
                });
            }
    );

    /**
     * 刷新表格
     */
    function refreshTable() {
        $("#mytab", window.parent.document).bootstrapTable("refresh");
    }

    function showShiroExample() {
        window.parent.layer.alert('例子：【插入账号权限】account:insert ，【读写账号权限】account:read ', {icon: 6});
    }
</script>
</html>