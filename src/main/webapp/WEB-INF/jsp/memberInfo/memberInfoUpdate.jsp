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
    <link href="${basePath}/plugins/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet"/>
    <title>成员数据上传</title>
</head>
<body>
<div class="container" style=" width: 830px;height: 400px;margin-top: 200px;">
    <form role="form" id="importFile" method="post"
          enctype="multipart/form-data">
        <input id="excelFile" name="excelFile" class="file-loading"
               type="file" accept=".xls,.xlsx" data-min-file-count="1"
               data-show-preview="true"> <br>
    </form>
</div>
</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="${basePath}/plugins/bootstrap-fileinput/js/zh.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    $("#excelFile").fileinput({
        uploadUrl: "${basePath}/member/uploadMemberInfo.json",//上传的地址
        uploadAsync: true,
        language: "zh",//设置语言
        showCaption: true,//是否显示标题
        showUpload: true, //是否显示上传按钮
        browseClass: "btn btn-primary", //按钮样式
        allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
        maxFileCount: 1,//最大上传文件数限制
        uploadAsync: true,
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
        allowedPreviewTypes: null,
        previewFileIconSettings: {
            'docx': '<i class="glyphicon glyphicon-file"></i>',
            'xlsx': '<i class="glyphicon glyphicon-file"></i>',
            'pptx': '<i class="glyphicon glyphicon-file"></i>',
            'jpg': '<i class="glyphicon glyphicon-picture"></i>',
            'pdf': '<i class="glyphicon glyphicon-file"></i>',
            'zip': '<i class="glyphicon glyphicon-file"></i>',
        },
        uploadExtraData: function () {
            var extraValue = null;
            var radios = document.getElementsByName('excelType');
            for (var i = 0; i < radios.length; i++) {
                if (radios[i].checked) {
                    extraValue = radios[i].value;
                }
            }
            return {"excelType": extraValue};
        }
    });

    $("#excelFile").on("fileuploaded", function (event, data, previewId, index) {
        alert("上传成功!");
    });
</script>
</html>









