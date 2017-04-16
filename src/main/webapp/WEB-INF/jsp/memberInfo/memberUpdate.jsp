<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/17/017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form class="form-line col-xs-10" role="form" style="padding: 25px; text-align: center">
    <label>
        <input name="memberId" value="${member.memberId}" hidden>
    </label>
    <div class="form-group">
        <label for="member-name" class="col-sm-2 control-label">姓名</label>
        <input class="form-control " value="${member.memberName}" id="member-name" name="member-name" disabled>
    </div>

    <%-- <div class="form-group">
         <label for="selectMemberManagerOption" class="col-sm-2 control-label">管理员</label>
         <select class="form-control" id="selectMemberManagerOption" name="memberManagerId">
             <option value="">自己就是管理</option>
             <c:forEach items="${managerList}" var="manager">
                 <option value="${manager.memberId}" name="memberManagerOption">
                     <c:out value="${manager.memberName}"/>
                 </option>
             </c:forEach>
         </select>
     </div>--%>
    <div class="form-group">
        <label for="selectDepartmentOption" class="col-sm-2 control-label">部门</label>
        <select class="form-control" id="selectDepartmentOption" name="memberDepartment.departmentId">
            <c:forEach items="${departmentList}" var="role">
                <option value="${role.departmentId}" name="departmentOption">
                    <c:out value="${role.departmentName}"/>
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="selectMemberStatusOption" class="col-sm-2 control-label">状态</label>
        <select class="form-control" id="selectMemberStatusOption" name="memberStatus">
            <option value="1">正常</option>
            <option value="0">冻结</option>

        </select>
    </div>
    <div class="form-group">
        <label for="selectMemberRoleOption" class="col-sm-2 control-label">角色</label>
        <select class="form-control" id="selectMemberRoleOption" name="memberRoleId">
            <c:forEach items="${memberRolesList}" var="memberRole">
                <option value="${memberRole.memberRoleId}">
                    <c:out value="${memberRole.memberRoleName}"/></option>
            </c:forEach>


        </select>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button class="btn btn-danger" type="button" id="submit" onclick="sendUpdate()">点击修改</button>
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
        //选中成员当前自己的所属部门
        $("#selectDepartmentOption").each(function () {
            $("#selectDepartmentOption").val(${member.memberDepartment.departmentId});
        });
        //选中成员自己的所属部门
        $("#selectMemberRoleOption").each(function () {
            $("#selectMemberRoleOption").val(${member.memberRoles.memberRoleId});
        });
        //选中成员管理员
        /* $("#selectMemberManagerOption").each(function () {
         $("#selectMemberManagerOption").val();
         });*/
        //选中账号状态
        $("#selectMemberStatusOption").each(function () {
            $("#selectMemberStatusOption").val(memberStatus);
        });
    });

    var memberStatus =${member.memberStatus} ==true ? "1" : "0";
    /**
     * 发送更新请求
     */
    function sendUpdate() {
        var selectDepartmentOptionVal = parseInt($("#selectDepartmentOption").val());
        var selectMemberRoleOptionVal = parseInt($("#selectMemberRoleOption").val());
        var selectMemberStatusOptionVal = $("#selectMemberStatusOption").val() == true;
        var memberNameVal = $("#member-name").val();
        $.ajax({
            type: 'post',
            contentType: "application/json",
            url: '${pageContext.request.contextPath}/member/update.json',
            data: JSON.stringify({
                memberId: ${member.memberId},
                memberName: memberNameVal,
                memberDepartment: {
                    departmentId: selectDepartmentOptionVal
                },
                memberStatus: selectMemberStatusOptionVal,
                memberRoles: {
                    memberRoleId: selectMemberRoleOptionVal
                }
            }),
            success: function (result) {
                if (result.status == 104) {
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
                    window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});
                }
            }
        })


    }
    /**
     * 刷新表格
     */
    function refreshTable() {
        $("#mytab", window.parent.document).bootstrapTable("refresh");
    }
</script>
</html>