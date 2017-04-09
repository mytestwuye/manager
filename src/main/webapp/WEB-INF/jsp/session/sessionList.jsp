<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/9
  Time: 14:41
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
    <title>会话查看</title>
    <link href="${pageContext.request.contextPath}/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div><div id="main">
    <div id="toolbar">
        <a class="waves-effect waves-button" href="javascript:;" onclick="forceoutAction()"><i class="zmdi zmdi-run"></i> 强制退出</a>
    </div>
    <table id="table"></table>
</div></div>
</body>

<script src="${pageContext.request.contextPath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/BootstrapMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/device.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/js/admin.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>

<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/session/list',
            height: getHeight(),
            striped: true,
            search: false,
            showRefresh: true,
            showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            searchOnEnterKey: true,
            idField: 'loginHistoryId',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'ck', checkbox: true},
                {field: 'loginHistoryId', title: '编号', sortable: true, align: 'center'},
                {field: 'historyAccountId', title: '账号', sortable: true, align: 'center'},
                {field: 'loginBrowser', title: '浏览器', sortable: true, align: 'center'},
                {field: 'lastLoginTime', title: '最后访问时间'},
                {field: 'loginOsVersion', title: '操作系统', align: 'center'},
                {field: 'lastLoginIp', title: '访问者IP', align: 'center'},
                {field: 'loginUserAgent', title: '用户标识', align: 'center'},
                {field: 'status', title: '状态', align: 'center', formatter: 'statusFormatter'}
            ]
        });
    });
    // 格式化状态
    function statusFormatter(value, row, index) {
        if (value == 'on_line') {
            return '<span class="label label-success">在线</span>';
        }
        if (value == 'off_line') {
            return '<span class="label label-default">离线</span>';
        }
        if (value == 'force_logout') {
            return '<span class="label label-danger">踢离</span>';
        }
    }
    // 强制退出
    var forceoutDialog;
    function forceoutAction() {
        var rows = $table.bootstrapTable('getSelections');
        if (rows.length == 0) {
            $.confirm({
                title: false,
                content: '请至少选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        } else {
            forceoutDialog = $.confirm({
                type: 'red',
                animationSpeed: 300,
                title: false,
                content: '确认强制退出该会话吗？',
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'waves-effect waves-button',
                        action: function () {
                            var ids = new Array();
                            for (var i in rows) {
                                ids.push(rows[i].id);
                            }
                            $.ajax({
                                type: 'get',
                                url: '${basePath}/manage/session/forceout/' + ids.join(","),
                                success: function(result) {
                                    if (result.code != 1) {
                                        if (result.data instanceof Array) {
                                            $.each(result.data, function(index, value) {
                                                $.confirm({
                                                    theme: 'dark',
                                                    animation: 'rotateX',
                                                    closeAnimation: 'rotateX',
                                                    title: false,
                                                    content: value.errorMsg,
                                                    buttons: {
                                                        confirm: {
                                                            text: '确认',
                                                            btnClass: 'waves-effect waves-button waves-light'
                                                        }
                                                    }
                                                });
                                            });
                                        } else {
                                            $.confirm({
                                                theme: 'dark',
                                                animation: 'rotateX',
                                                closeAnimation: 'rotateX',
                                                title: false,
                                                content: result.data.errorMsg,
                                                buttons: {
                                                    confirm: {
                                                        text: '确认',
                                                        btnClass: 'waves-effect waves-button waves-light'
                                                    }
                                                }
                                            });
                                        }
                                    } else {
                                        forceoutDialog.close();
                                        $table.bootstrapTable('refresh');
                                    }
                                },
                                error: function(XMLHttpRequest, textStatus, errorThrown) {
                                    $.confirm({
                                        theme: 'dark',
                                        animation: 'rotateX',
                                        closeAnimation: 'rotateX',
                                        title: false,
                                        content: textStatus,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    },
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        }
    }
</script>
</html>