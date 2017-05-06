<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/5/2
  Time: 13:28
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
    <title>权限分配页面</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>角色名称</th>
            <th>拥有的权限</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${permissionAllotList}" var="roles">
            <tr>
                <td>${roles.roleId.description}</td>
                <td>
                    <c:forEach items="${roles.permissionArrayList}" var="permission">
                        【${permission.description}】
                    </c:forEach>
                </td>
                <td><a href="#" onclick="changeRolePermission(${roles.roleId.roleId})">分配权限</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    function changeRolePermission(roleId) {
        layer.open({
            type: 2,
            content: '${basePath}/system/permission/allot/update.html/' + roleId,
            area: ['520px', '630px'],
            maxmin: true
        });
    }
</script>
</html>





















