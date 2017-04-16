<%--@elvariable id="member" type="com.suny.association.pojo.po.Member"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/19/019
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增成员信息</title>
    <link href="${pageContext.request.contextPath}/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <style>
        .strongText {
            color: #ff0000;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" style="padding: 25px; text-align: center">
        <label>
            <input name="memberId" value="${member.memberId}" hidden>
        </label>
        <div class="form-group">
            <label for="member-name" class="col-sm-2 control-label">姓名<strong class="strongText">(必填)</strong></label>
            <input class="form-control " value="" id="member-name" name="member-name" placeholder="请在这里输入成员姓名">
        </div>
        <div class="form-group">
            <label for="member-class" class="col-sm-2 control-label">班级<strong class="strongText">(必填)</strong></label>
            <input class="form-control " value="" id="member-class" name="member-class" placeholder="请在这里输入成员的班级">
        </div>
        <div class="form-group">
            <label for="member-sex" class="col-sm-2 control-label">性别</label>
            <select class="form-control" id="member-sex" name="member-sex">
                <option name="sex" value="0">男</option>
                <option name="sex" value="1">女</option>
            </select>
        </div>
        <div class="form-group">
            <label for="selectMemberGradeOption" class="col-sm-2 control-label">年级</label>
            <select class="form-control" id="selectMemberGradeOption" name="memberGradeNumber">
                <c:forEach items="${memberGradeList}" var="memberGrade">
                    <option name="" value="${memberGrade}">
                        <c:out value="${memberGrade}届"/>
                    </option>
                </c:forEach>
            </select>
        </div>


        <div class="form-group">
            <label for="selectMemberManagerOption" class="col-sm-2 control-label">管理员</label>
            <select class="form-control" id="selectMemberManagerOption" name="memberManagerId">
                <option value="">自己就是管理</option>
                <c:forEach items="${managerList}" var="manager">
                    <option value="${manager.memberId}" name="memberManagerOption">
                        <c:out value="${manager.memberName}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="selectDepartmentOption" class="col-sm-2 control-label">部门</label>
            <select class="form-control" id="selectDepartmentOption" name="memberDepartmentId">
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
                <button class="btn btn-danger" type="button" onclick="insertMemberInfo()">点击添加</button>
            </div>
        </div>
    </form>
</div>

<%--正文区结束--%>
<script src="${pageContext.request.contextPath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/BootstrapMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/device.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
</body>
<script>
    function insertMemberInfo() {
        var memberNameVal = $("#member-name").val();
        var memberClassVal = $("#member-class").val();
        var selectMemberSexVal = $("#member-sex").val() == true;
        var selectMemberGradeOptionVal = parseInt($("#selectMemberGradeOption").val());
        var selectDepartmentOptionVal = parseInt($("#selectDepartmentOption").val());
        var selectMemberRoleOptionVal = parseInt($("#selectMemberRoleOption").val());
        var selectMemberManagerOptionVal = parseInt($("#selectMemberManagerOption").val());
        var selectMemberStatusOptionVal = $("#selectMemberStatusOption").val() == true;
        //验证表单
        if (validMemberNameVal(memberNameVal) && ValidMemberClassVal(memberClassVal)) {
            $.ajax({
                type: 'post',
                dataType: 'json',
                contentType: "application/json",
                url: '${pageContext.request.contextPath}/member/insert.json',
                data: JSON.stringify({
                    memberName: memberNameVal,
                    memberClassName: memberClassVal,
                    memberSex: selectMemberSexVal,
                    memberGradeNumber: selectMemberGradeOptionVal,
                    memberDepartment: {
                        departmentId: selectDepartmentOptionVal
                    },
                    memberStatus: selectMemberStatusOptionVal,
                    memberRoles: {
                        memberRoleId: selectMemberRoleOptionVal
                    },
                    memberManager: {
                        memberId: selectMemberManagerOptionVal
                    }
                }),
                success: function (result) {
                    var statusCode = result.status;
                    if (statusCode == 102) {
                        //当你在iframe页面关闭自身时
                        window.parent.layer.alert('新增成功了，刷新下页面看效果吧', {icon: 6});
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        $("#mytab", window.parent.document).bootstrapTable("refresh");

                    }
                    else if (statusCode == 202) {
                        window.parent.layer.msg('必须要填写每个字段！', {icon: 5});
                    }
                    else if (statusCode == 205) {
                        window.parent.layer.msg('姓名必须是中文', {icon: 5});
                    }

                },
                error: function () {
                    window.parent.layer.msg('服务器无响应！', {icon: 5});
                }
            })
        }

    }


    function validMemberNameVal(memberNameVal) {
        if (memberNameVal == null || memberNameVal == "") {
            $("#member-name").focus();
            $("#member-name").css('border', '2px solid red');
            window.parent.layer.msg('姓名必须输入，并且为中文！', {icon: 5});
            return false;
        }
        if(validChinese(memberNameVal) === false){
            $("#member-name").focus();
            $("#member-name").css('border', '2px solid red');
            window.parent.layer.msg('必须为中文！', {icon: 5});
            return false;
        }
        return true;

    }

    /**
     * @return {boolean}
     */
    function ValidMemberClassVal(memberClassVal) {
        $("#member-name").css('border', '');
        if (memberClassVal == null || memberClassVal == "") {
            $("#member-class").focus();
            $("#member-class").css('border', '2px solid red');
            window.parent.layer.msg('班级必须输入，并且为中文！', {icon: 5});
            return false;
        }
        if(validChinese(memberClassVal) ===false){
            $("#member-class").focus();
            $("#member-class").css('border', '2px solid red');
            window.parent.layer.msg('班级必须全部为中文！', {icon: 5});
        }
        return true;
    }

    function validChinese(strVal){
        var reg = /^[\u4E00-\u9FA5]+$/;
        return reg.test(strVal);
    }
</script>
</html>