<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/13
  Time: 17:41
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
    <title>角色修改</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        form{
            padding: 29px;
        }
    </style>
</head>
<body>

<!-- 新增 -->
<div id="createDialog" class="crudDialog">
    <form>
        <div>角色ID</div>
        <div class="form-group">
            <label for="roleId"></label>
            <input id="roleId" type="text" class="form-control" value="${role.roleId}" disabled>
        </div>
        <div>当前角色名字</div>
        <div class="form-group">
            <label for="roleName_old"></label>
            <input id="roleName_old" type="text" class="form-control" value="${role.roleName}" disabled>
        </div>
        <div class="form-group">
            <label for="roleName_new">修改角色名字</label>
            <input id="roleName_new" type="text" class="form-control" >
        </div>
        <button type="button" class="btn btn-warning btn-block" id="submit">点击修改</button>
    </form>
</div>


</body>
<script src="${basePath}/plugins/jquery-3.2.1.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    $(document).on('click','#submit',function () {
        var roleNameVal=$("#roleName_new").val();
        var roleIdVal=$("#roleId").val();
        if(roleIdVal == '' || roleIdVal == null){
            layer.msg('恶意篡改数据',{icon:5});
            return false;
        }
        if(roleNameVal == '' || roleNameVal == null){
            layer.msg('角色名字不能为空',{icon:5});
            return false;
        }
        $.ajax({
            type:'post',
            contentType: "application/json",
            url: '${basePath}/account/role/update.json',
            data:JSON.stringify({
                roleId:roleIdVal,
                roleName:roleNameVal
            }),
            success :function(result){
                if(result.status == 104){
                    window.parent.layer.alert('修改成功', {icon: 6});
                    //noinspection JSDuplicatedDeclaration
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);  //再执行关闭
                }
                else if (result.status == 5) {
                    window.parent.layer.alert('恶意篡改数据，不存在角色id', {icon: 5});
                    //noinspection JSDuplicatedDeclaration
                    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index);  //再执行关闭
                }
                else if (result.status == 4) {
                    window.parent.layer.msg('失败了，检查下哪里错了', {icon: 5});
                }
                else if(result.status == 202){
                    window.parent.layer.msg('必要字段为空,请检查您的输入', {icon: 5});
                }
                else {
                    window.parent.layer.msg('服务器异常，请重试', function(){
                    });
                }
            },
            error:function(){
                window.parent.layer.msg('服务器异常，请重试！', {icon: 5});
            }
        })
    });
</script>
</html>