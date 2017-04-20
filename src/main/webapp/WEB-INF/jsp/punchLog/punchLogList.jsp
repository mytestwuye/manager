<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/11
  Time: 13:21
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
    <title>考勤记录</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <link href="${basePath}/css/admin.css" rel="stylesheet"/>
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

<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${basePath}/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>

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
                url: '${basePath}/punchLog/list.json',         //请求后台的URL（*）
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
                uniqueId: "punchRecordId",                     //每一行的唯一标识，一般为主键列
                //showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                showExport: true,                     //是否显示导出
                exportDataType: "basic",              //basic', 'all', 'selected'.
                detailView: false,                   //是否显示父子表
                rowStyle: function (row, index) {
                    //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                    var strclass = "";
                    if (row.memberStatus == false) {
                        strclass = 'danger';//还有一个active
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
                    {field: 'punchRecordId', title: '日志编号', sortable: true, align: 'center'},
                    {field: 'punchDatetime', title: '签到时间', sortable: true, align: 'center',formatter:'timeFormat'},
                    {field: 'punchTodayDate', title: '考勤日期', sortable: true, align: 'center',formatter:'dateFormat'},
                    {field: 'punchIsCome', title: '是否考勤',formatter:'punchTypeStatusFormat'},
                    {field: 'punchTypeId', title: '考勤类型', align: 'center',formatter:'punchTypeFormat'},
                    {field: 'punchMemberId', title: '考勤成员', align: 'center',formatter:'punchMemberFormat'},
                    {
                        field: 'punchMemberDepartment',
                        title: '考勤成员部门',
                        align: 'center',
                        formatter: 'punchMemberDepartmentFormat'
                    },
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
                offset: params.offset,  //页码
                departmentname: $("#txt_search_departmentname").val(),
                status: $("#txt_search_status").val()
            };
            return temp;
        };
        return oTableInit;
    };

    function dateFormat(value,row,index){
        var date = new Date(row.punchTodayDate);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        return Y+M+D;
    }
    function timeFormat(value,row,index){
        var date = new Date(row.punchDatetime);
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return h+m+s;
    }

    function punchTypeStatusFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        if (1 == row.punchIsCome) {
            return '<span class="label label-success">考勤</span>';
        } else {
            return '<span class="label label-default">缺勤</span>';
        }
    }

    function punchTypeFormat(value,row,index){
        //noinspection JSUnresolvedVariable
        return row.punchTypeId.punchTypeName;
    }

    function punchMemberFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.punchMemberId.memberName;
    }

    function punchMemberDepartmentFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.punchMemberId.memberDepartment.departmentName;
    }

    /**
     * 初始化表格
     * @returns {{}}
     * @constructor
     */
    var ButtonInit = function () {
        var oInit = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };
</script>
</html>