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
    <div class="col-lg-1">
        <button class="btn-success"><a href="${basePath}/member/downloadMemberTemplate.json">下载模板</a></button>
    </div>
    <input id="excelFile" name="excelFile" class="file-loading"
           type="file" accept=".xls,.xlsx" data-min-file-count="1"> <br>
</div>
</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="${basePath}/plugins/bootstrap-fileinput/js/zh.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script>
    var excelFile;
    excelFile = $("#excelFile");

    $(function () {
        //0.初始化fileinput
        var oFileInput = new FileInput();
        oFileInput.Init("excelFile", "${basePath}/member/uploadMemberInfo.json");
    });

    //初始化fileinput
    var FileInput = function () {
        var oFile = {};

        //初始化fileinput控件（第一次初始化）
        oFile.Init = function (ctrlName, uploadUrl) {
            var control = $('#' + ctrlName);

            //初始化上传控件的样式
            control.fileinput({
                language: 'zh', //设置语言
                uploadUrl: uploadUrl, //上传的地址
                allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
                showUpload: true, //是否显示上传按钮
                showPreview: true,
                showCaption: false,//是否显示标题
                browseClass: "btn btn-primary", //按钮样式
                maxFileCount: 1, //表示允许同时上传的最大文件个数
                enctype: 'multipart/form-data',
                validateInitialCount: true,
                previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
            });

            //导入文件上传完成之后的事件
            $("#excelFile").on("fileuploaded", function (event, data, previewId, index) {
                //noinspection JSDuplicatedDeclaration
                var data = data.response;
                if (data == undefined) {
                    toastr.error('文件格式类型不正确');
                    return;
                }
                //1.初始化表格
                var oTable = new TableInit();
                oTable.Init(data);
//                $("#div_startimport").show();
            });
        };
        return oFile;
    };

    /*var excelFile;
     excelFile = $("#excelFile");
     excelFile.fileinput({
     uploadUrl: "",//上传的地址
     uploadAsync: true,
     language: "zh",//设置语言
     showCaption: true,//是否显示标题
     showUpload: true, //是否显示上传按钮
     browseClass: "btn btn-primary", //按钮样式
     allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
     maxFileCount: 1,//最大上传文件数限制
     previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
     allowedPreviewTypes: null,
     previewFileIconSettings: {
     'xlsx': '<i class="glyphicon glyphicon-file"></i>',
     'xls': '<i class="glyphicon glyphicon-file"></i>'
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
     }).on("fileuploaded", function (event, data, previewId, index) {
     if (data.response) {
     alert("上传成功!");
     }
     window.parent.location.href = "/member/memberInfo/memberManager";
     });

     excelFile.on("filebatchselected", function (event, files) {
     $(this).fileinput("upload");
     });*/


</script>
</html>









