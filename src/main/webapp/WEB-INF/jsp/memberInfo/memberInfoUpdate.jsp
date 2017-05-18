<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/5/14
  Time: 11:35
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
    <%--<link href="${basePath}/plugins/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet"/>--%>
    <style>

    </style>
    <title>成员数据上传</title>
</head>
<body>
<div class="container">
    <div class="form-group col-md-12 has-feedback" id="file">
        <hr>
        <p class="lead">上传模板前，请严格按照Excel模板进行修改信息，否则将会上传不成功，严格按照模板的顺序进行填写</p>
        <div class="col-md-4 input-group">
            <a href="${basePath}/member/downloadMemberTemplate.json">下载Excel模板</a>
        </div>
        <hr>
        <label for="lefile" class="control-label col-md-4">选择文件:</label>
        <div class="col-md-4 input-group">
            <input id="lefile" type="file"
                   accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                   style="display:none">
            <span class="input-group-addon" onclick="$('input[id=lefile]').click();"
                  style="cursor: pointer; background-color: #e7e7e7"><i class="fa fa-folder-open"></i>Browse</span>
            <label for="photoCover"></label><input id="photoCover" class="form-control" type="text">
            <span class="fa fa-download form-control-feedback" style="cursor: pointer;pointer-events: auto;"></span>
        </div>
        <hr>
        <div class="col-md-4 input-group">
            <label></label>
            <button id="submit" class="btn-success btn-lg">上传</button>
        </div>
    </div>
</div>
</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    var submitFile = $("#submit");
    $('input[id=lefile]').change(function () {
        $('#photoCover').val($(this).val());
    });

    submitFile.click(function () {
        var file = $('#lefile')[0].files[0];
        if (file == null) {
            layer.alert("请选择文件再进行上传");
            return false;
        }
        var fileName = file.name.substring(file.name.lastIndexOf(".") + 1).toLowerCase();
        if (fileName != "xls" && fileName != "xlsx") {
            layer.alert("请选择Excel文件上传！扩展名不对");
            return false;
        }
        var fileExtension = file.type;
        if (fileExtension != "application/vnd.ms-excel" && fileExtension != "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
            layer.alert("请选择Excel文件上传！文件格式有误");
            return false;
        }
        console.log(file);
        var formData = new FormData();
        formData.append('excelFile', file);
        $.ajax({
            url: '${basePath}/member/uploadMemberInfo.json',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false
        }).done(function (result) {
            var status = result.status;
            if (status == 898) {
                layer.alert("文件名存在欺骗性，重新检查");
            } else if (status == 8) {
                layer.alert("在这个Excel中没有读取到一条符合要求的成员信息");
            } else if (status == 2) {
                layer.alert("全部插入失败，请检查文件是否存在不合理的地方");
            } else if (status == 109) {
                var data = result.data;
                var message = "插入失败的成员信息为:";
                for (var i = 0; i < data.length; i++) {
                    var memberName = data[i].memberName;
                    var memberClassName = data[i].memberClassName;
                    var memberGradeNumber = data[i].memberGradeNumber;
                    message = message + "【" + memberGradeNumber + "届" + memberClassName + memberName + "】\r\n";
                    console.log("插入失败的成员信息为【" + memberGradeNumber + "届【" + memberClassName + "】" + memberName);
                }
                layer.alert("插入部分成功,未成功的可能由于数据库已经存在或者由于程序原因请人工添加");
                layer.alert("插入失败的条数为" + data.length);
                layer.alert(message);
            } else {
                layer.alert("刷新下是否成功");
            }
        }).fail(function () {
            layer.alert("出了点小问题，再试试吧");
        });
    })

</script>
</html>









