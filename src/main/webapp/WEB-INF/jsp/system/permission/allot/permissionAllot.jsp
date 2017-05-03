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
        <tr>
            <td>超级管理员</td>
            <td>删除账号，增加账号</td>
            <td><a href="#">分配权限</a></td>
        </tr>
        </tbody>

    </table>
</div>
</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
</html>





















