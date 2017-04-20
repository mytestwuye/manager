<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/19
  Time: 12:53
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
    <title>异议考勤记录审批记录</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
</head>
<body>
<div>
    <div class="panel-body" style="padding-bottom:0;">
        <div id="toolbar">
            <%--<a class="waves-effect waves-button" href="javascript:;" onclick="forceoutAction()"><i
                    class="zmdi zmdi-run"></i> 强制退出</a>--%>
        </div>
        <table id="table"></table>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/plugins/BootstrapMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
<script>
    function refresh() {
        $("#table").bootstrapTable("refresh");
    }
    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();
        //根据窗口调整表格高度
        $(window).resize(function () {
            $('#table').bootstrapTable('resetView', {
                height: tableHeight()
            })
        });
    });


    function tableHeight() {
        return $(window).height() - 20;
    }


    var TableInit = function () {
        var oTableInit = {};
        //初始化Table
        oTableInit.Init = function () {
            layer.load(0, {shade: false, time: 1000}); //0代表加载的风格，支持0-2
            $('#table').bootstrapTable({
                url: '${basePath}/punchLog/applyForResult/list.json',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                smartDisplay: false,                 //是否关闭智能隐藏分页按钮
                sortable: true,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                showPaginationSwitch: 'true',       //取消或者显示分页
                height: tableHeight(),    //高度调整
                buttonsAlign: "right",//按钮对齐方式
                toolbarAlign: "left",//工具栏对齐方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                //clickToSelect: true,                //是否启用点击选中行
                singleSelect: true,           // 单选checkbox
                //height: 500,                        行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "callbackId",                     //每一行的唯一标识，一般为主键列
                //showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                showExport: true,                     //是否显示导出
                exportDataType: "basic",              //basic', 'all', 'selected'.
                detailView: false,                   //是否显示父子表
                rowStyle: function (row, index) {
                    //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                    var strclass = "";
                    if (row.memberStatus == false) {
                        strclass = 'danger';
                    }
                    else if (row.memberName == "已删除") {
                        strclass = 'danger';
                    }
                    else {
                        return {};
                    }
                    return {classes: strclass}
                },
                columns: [
//                    {field: 'callbackId', title: '日志编号', sortable: true, align: 'center'},
                    {
                        field: 'callbackTime',
                        title: '申请时间',
                        sortable: true,
                        align: 'center',
                        formatter: 'callbackTimeFormat'
                    },
                    {
                        field: 'punchMemberId',
                        title: '考勤人',
                        sortable: true,
                        align: 'center',
                        formatter: 'punchMemberFormat'
                    },
                    {
                        field: 'punchMemberGrade',
                        title: '考勤人年级',
                        sortable: true,
                        align: 'center',
                        formatter: 'punchMemberGradeFormat'
                    },
                    {
                        field: 'punchMemberDepartment',
                        title: '考勤人部门',
                        sortable: true,
                        align: 'center',
                        formatter: 'punchMemberDepartmentFormat'
                    },
                    {
                        field: 'applicationMessageId',
                        title: '考勤类型',
                        sortable: true,
                        align: 'center',
                        formatter: 'punchTypeFormat'
                    },
                    {
                        field: 'applicationMessageId',
                        title: '申请修改考勤类型',
                        sortable: true,
                        align: 'center',
                        formatter: 'changePunchTypeFormat'
                    },
                    {field: 'callbackResult', title: '申请结果', formatter: 'resultStatusFormat'},
                    {field: 'callbackManagerId', title: '审批人', align: 'center', formatter: 'punchManagerFormat'},
                    {
                        field: 'callbackManagerGrade',
                        title: '审批人年级',
                        align: 'center',
                        formatter: 'punchManagerGradeFormat'
                    },
                    {
                        field: 'callbackManagerRole',
                        title: '审批人角色',
                        align: 'center',
                        formatter: 'punchManagerRoleFormat'
                    },
                    {field: 'callbackReason', title: '审批理由', align: 'center'},
                    {field: 'callbackTime', title: '审批时间', align: 'center', formatter: 'applyTimeFormat'}
                ],
                onClickRow: function (row, $element) {
                    //$element是当前tr的jquery对象
                    // $element.css("background-color", "#29a176");
                },//单击row事件
                locale: "zh-CN", //中文支持,
                detailFormatter: function (index, row, element) {
                    var html = '';
                    $.each(row, function (key, val) {
                        html += "<p>" + key + ":" + val + "</p>"
                    });
                    return html;
                }
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset  //页码
//                    departmentname: $("#txt_search_departmentname").val(),
//                    status: $("#txt_search_status").val()
            };
            return temp;
        };
        return oTableInit;
    };


    function applyTimeFormat(value, row, index) {
        var date = new Date(row.callbackTime);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y + M + D + h + m + s;
    }
    function callbackTimeFormat(value, row, index) {
        var date = new Date(row.applicationMessageId.applyForTime);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y + M + D + h + m + s;
    }

    function resultStatusFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        if (row.callbackResult) {
            return '<span class="label label-success">同意</span>';
        } else {
            return '<span class="label label-default">拒绝</span>';
        }
    }

    function punchTypeFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.applicationMessageId.punchRecordId.punchTypeId.punchTypeName;
    }

    function changePunchTypeFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.applicationMessageId.changePunchType.punchTypeName;
    }

    function punchMemberFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.applicationMessageId.punchRecordId.punchMemberId.memberName;
    }
    function punchMemberGradeFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.applicationMessageId.punchRecordId.punchMemberId.memberGradeNumber;
    }

    function punchManagerFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.callbackManagerId.memberName;
    }
    function punchManagerGradeFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.callbackManagerId.memberGradeNumber;
    }
    function punchManagerRoleFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.callbackManagerId.memberRoles.memberRoleName;
    }

    function punchMemberDepartmentFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.applicationMessageId.punchRecordId.punchMemberId.memberDepartment.departmentName;
    }

    var ButtonInit = function () {
        var oInit = {};
        oInit.Init = function () {//初始化页面上面的按钮事件};
        };
        return oInit;
    };


</script>
</html>