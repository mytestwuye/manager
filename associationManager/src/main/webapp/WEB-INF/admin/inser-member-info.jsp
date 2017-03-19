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
    <link href="${pageContext.request.contextPath}/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
</head>
<body>
<form class="form-line col-xs-10" role="form" style="padding: 25px; text-align: center" method="post" ACTION="#">
    <label>
        <input name="memberId" value="${member.memberId}" hidden>
    </label>
    <div class="form-group">
        <label for="member-name" class="col-sm-2 control-label">姓名</label>
        <input class="form-control " value="" id="member-name" name="member-name" placeholder="请在这里输入成员姓名">
    </div>
    <div class="form-group">
        <label for="member-class" class="col-sm-2 control-label">班级</label>
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
            <c:forEach items="${departmentList}" var="department">
                <option value="${department.departmentId}" name="departmentOption">
                    <c:out value="${department.departmentName}"/>
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
            <button type="submit" class="btn btn-danger" onclick="insertMemberInfo()">点击添加</button>
        </div>
    </div>
</form>



<%--正文区结束--%>
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
</body>
<script>
  function insertMemberInfo(){
      var memberNameVal = $("#member-name").val();
      var memberClassVal = $("#member-class").val();
      var selectMemberSexVal = $("#member-sex").val();
      var selectMemberGradeOptionVal = $("#selectMemberGradeOption").val();
      var selectDepartmentOptionVal = $("#selectDepartmentOption").val();
      var selectMemberRoleOptionVal = $("#selectMemberRoleOption").val();
      var selectMemberManagerOptionVal = $("#selectMemberManagerOption").val();
      var selectMemberStatusOptionVal = $("#selectMemberStatusOption").val() == true ? "1" : "0";
      //验证表单
      if(validMemberNameVal(memberNameVal) && ValidMemberClassVal(memberClassVal)){
          $.ajax({
              type:'post',
              url:'${pageContext.request.contextPath}/member/insertMemberInfo.json',
              data:{
                  memberName : memberNameVal,
                  memberClassName :memberClassVal,
                  memberSex : selectMemberSexVal,
                  memberGradeNumber :selectMemberGradeOptionVal,
                  memberManagerId: selectMemberManagerOptionVal,
                  memberDepartmentId: selectDepartmentOptionVal,
                  memberStatus: selectMemberStatusOptionVal,
                  memberRoleId: selectMemberRoleOptionVal
              },
              success:function(result){
                  if (result.status == 1) {
                      //当你在iframe页面关闭自身时
                      window.parent.layer.alert('新增成功了，刷新下页面看效果吧', {icon: 6});
                      var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                      parent.layer.close(index); //再执行关闭
                      $("#mytab",window.parent.document).bootstrapTable("refresh");
                      return;
                  }
                  window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});
              },
              error:function(result){
                  if (result.status == 0) {
                      window.parent.layer.msg('失败了。。你再检查下哪里！', {icon: 5});
                  }
              }
          })
      }

  }

  function validMemberNameVal(memberNameVal){
      if(memberNameVal==null || memberNameVal =="" ){
          window.parent.layer.msg('姓名一定要输入', function(){
              //关闭后的操作
          });
          return false;
      }
      return true


  }

  /**
 * @return {boolean}
 */
function ValidMemberClassVal(memberClassVal){
      if(memberClassVal==null || memberClassVal =="" ){
          window.parent.layer.msg('班级一定要输入', function(){
        //关闭后的操作
          });
          return false;
      }
      return true
  }
</script>
</html>