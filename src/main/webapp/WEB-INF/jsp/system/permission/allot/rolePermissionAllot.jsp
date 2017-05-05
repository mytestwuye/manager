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
    <title>权限分配</title>
</head>
<body>
<tr>
    <c:forEach items="${permissionList}" var="havePermissionList">
        角色名称:
        <td>${havePermissionList.roleId.roleName}</td>
        角色解释:
        <td>${havePermissionList.roleId.description}</td>
        拥有的权限:<td>

        <c:forEach items="${havePermissionList.permissionArrayList}" var="permissionList">
            【${permissionList.description}】
        </c:forEach>

        </td>


    </c:forEach>
</tr>


</body>
</html>