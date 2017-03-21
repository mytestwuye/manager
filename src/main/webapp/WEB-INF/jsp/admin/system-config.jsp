<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/15/015
  Time: 19:22
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
    <title>这是个测试</title>
</head>
<body>
<h1>测试</h1>
<a href="${pageContext.request.contextPath}/crud.html">点击弹出拟态框</a>
</body>
</html>