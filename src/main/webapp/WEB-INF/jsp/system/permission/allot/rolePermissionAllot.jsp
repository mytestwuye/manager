<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/5/5
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <title>权限分配</title>
</head>
<body>

<div class="container">
    <c:forEach items="${permissionList}" var="havePermissionList">
        <div class="">
            <input id="roleId" type="hidden" value="${havePermissionList.roleId.roleId}">
            <h2> 角色名称: <strong>${havePermissionList.roleId.roleName}</strong></h2>
            <h2> 角色解释: <strong>${havePermissionList.roleId.description}</strong></h2>
            <h3>拥有的权限:</h3>
        </div>
        <c:forEach items="${havePermissionList.permissionArrayList}" var="permissionList">
            【${permissionList.description}】
        </c:forEach>
        <h3>分配权限</h3>
        <div class="check-box">
            <label><input type="checkbox" onclick="selectAll()"></label>全选
            <label><input type="checkbox" onclick="removeAll()"></label>全不选
            <label><input type="checkbox" onclick="invertSelect()"></label>反选
            <c:forEach items="${permissions}" var="permission">
                <label>
                    <input type="checkbox" value="${permission.permissionId}" class="permiss"
                           name="permiss"> ${permission.description}
                </label>
            </c:forEach>
        </div>


    </c:forEach></div>
<div class="form-control">
    <div class="col-sm-10 col-sm-offset-2">
        <button type="button" class="btn btn-default" onclick="updatePermission()">点击修改角色权限</button>
    </div>
</div>


</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    function selectAll() {
        $("input[name='permiss']").attr("checked", "true");
    }
    function removeAll() {
        $("input[name='permiss']").removeAttr("checked");
    }
    function invertSelect() {
        $("input[name='permiss']").each(function () {
            if ($(this).attr("checked")) {
                $(this).removeAttr("checked");
            }
            else {
                $(this).attr("checked", "true")
            }
        })
    }
    function updatePermission() {
        var roleIdVal = parseInt($("#roleId").val());
        var checked = [];
        $(".permiss:checked").each(function () {
            checked.push($(this).val());
        });
        // 假如一个框都没有选中则说明删除所有权限
        console.log(checked);
        if (checked.length == 0) {
            checked.push(9999);
        }
        $.ajax({
            type: "POST",
            url: "${basePath}/system/permission/allot/update.json",
            dateType: "json",
            data: {
                permissionArray: checked,
                roleId: roleIdVal
            },
            success: function (result) {
                var resultCode = result.status;
                if (resultCode == 104) {
                    layer.alert("更改权限成功了，刷新下查看效果吧", {icon: 6});
                    setTimeout('closeWindows()', 3000);

                } else if (resultCode == 103) {
                    layer.alert("删除全部权限，刷新下查看效果吧", {icon: 6});
                    setTimeout('closeWindows()', 3000);
                }
                else if (resultCode == 5) {
                    layer.msg('没有这个角色', {icon: 5});
                    setTimeout('closeWindows()', 3000);
                }
                else {
                    layer.msg('失败了', {icon: 5});
                    setTimeout('closeWindows()', 3000);
                }
            },
            error: function () {
                layer.msg('服务器出了点小插曲');
            }
        })
    }

    function closeWindows() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }

</script>
</html>














