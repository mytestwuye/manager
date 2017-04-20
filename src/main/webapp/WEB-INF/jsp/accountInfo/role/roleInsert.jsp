<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/13
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="basePath" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/11
  Time: 18:17
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>操作记录查看</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <style>
        form {
            padding: 29px;
        }
    </style>
</head>
<body>

<!-- 新增 -->
<div id="createDialog" class="crudDialog container">
    <form>
        <div class="form-group">
            <label for="roleId"></label>
            <input id="roleId" type="text" class="form-control" value="角色ID由系统自动生成" disabled>
        </div>
        <div class="form-group">
            <label for="roleName1">角色名字</label>
            <input id="roleName1" type="text" class="form-control">
        </div>
        <button type="button" class="btn btn-warning btn-block" id="submit">点击新增</button>
    </form>
</div>


</body>
<script src="${basePath}/plugins/jquery-3.2.1.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    $(document).on('click', '#submit', function () {
        var roleNameVal = $("#roleName1").val();
        if (roleNameVal == '' || roleNameVal == null) {
            layer.msg('角色名字不能为空', {icon: 5});
            return false;
        }
        $.ajax({
            type: 'post',
            contentType: "application/json",
            url: '${pageContext.request.contextPath}/account/role/insert.json',
            data: JSON.stringify({
                roleName: roleNameVal
            }),
            success: function (result) {
                if (result.status == 102) {
                    window.parent.layer.alert('添加成功', {icon: 6});
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);  //再执行关闭
                }
                else if (result.status == 006) {
                    window.parent.layer.msg('重复添加角色');
                }
                else if (result.status == 0x2) {
                    window.parent.layer.msg('失败了，检查下哪里错了', {icon: 5});
                }
                else {
                    window.parent.layer.msg('服务器异常，请重试', function () {
                    });
                }
            },
            error: function () {
                window.parent.layer.msg('服务器异常，请重试！', {icon: 5});
            }
        })
    });
</script>
</html>