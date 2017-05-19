<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/16
  Time: 20:55
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
    <title>异议考勤记录审批</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
</head>
<body>
<div class="panel-body" style="padding-bottom:0;">
    <table id="tabs" class="table table-hover"></table>
</div>


<%--正文区结束--%>


</body>
<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${basePath}/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<%--suppress JSUnresolvedVariable --%>
<script>
    function refresh() {
        $("#tabs").bootstrapTable("refresh");
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
            $('#tabs').bootstrapTable('resetView', {
                height: tableHeight()
            })
        });


    });


    function tableHeight() {
        return $(window).height() - 145;
    }


    var TableInit = function () {
        var oTableInit = {};
        //初始化Table
        oTableInit.Init = function () {
            layer.load(0, {shade: false, time: 1000}); //0代表加载的风格，支持0-2
            $('#tabs').bootstrapTable({
                url: '${basePath}/punchLog/applicationMessage/queryAll.json',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                smartDisplay: true,                 //是否关闭智能隐藏分页按钮
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
                pageList: [5, 10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                singleSelect: true,           // 单选checkbox
                //height: 500,                        行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "memberId",                     //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
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
                    {title: "选择", field: "select", checkbox: true, width: 20, align: "center", valign: "middle"},
                    {field: "punchRecordId", title: "考勤人", align: "center", formatter: 'punchRecordFormatter'},
                    {field: "department", title: "所属部门", align: "center", formatter: 'departmentFormatter'},
                    {
                        field: "punchTypeId",
                        title: "当前考勤",
                        sortable: true,
                        order: "desc",
                        align: "center",
                        formatter: 'punchTypeFormatter'
                    }, {
                        field: "changePunchType",
                        title: "希望类型",
                        sortable: true,
                        align: "center",
                        formatter: 'changePunchTypeFormatter'
                    },
                    {field: "applicationReason", title: "异议理由", align: "center"},
                    {field: "punchTodayDate", title: "考勤日期", align: "center", formatter: 'punchTodayDateFormatter'},
                    {
                        field: "applyForTime",
                        title: "提出申请时间",
                        sortable: true,
                        align: "center",
                        formatter: "applyForTimeFormat"
                    },
                    {field: "operation", title: "操作", align: "center", formatter: "operaFormat"}
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
//                departmentname: $("#txt_search_departmentname").val(),
//                status: parseInt($("#txt_search_status").find("input:radio:checked").val())
            };
            return temp;
        };
        return oTableInit;
    };

    function departmentFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.punchRecordId.punchMemberId.memberDepartment.departmentName;
    }

    function punchRecordFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.punchRecordId.punchMemberId.memberName;
    }

    function applyForTimeFormat(value, row, index) {
        //noinspection JSUnresolvedVariable
        var date =row.applyForTime;
        var Y = date.year + '-';
        var M = date.monthValue + '-';
        var D = date.dayOfMonth + ' ';
        var h = date.hour + ':';
        var m = date.minute + ':';
        var s = date.second;
        return Y + M + D + h + m + s;
    }

    function punchTypeFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        switch (row.punchTypeId.punchTypeId) {
            case 0:
                return '<span class="label label-danger ">缺勤</span>';
                break;
            case 1:
                return '<span class="label label-success ">正常</span>';
                break;
            case 2:
                return '<span class="label label-warning ">迟到</span>';
                break;
            case 3:
                return '<span class="label label-info ">请假</span>';
                break;
            default:
                return '<span class="label label-default ">未知</span>';
                break;
        }
    }

    function changePunchTypeFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        switch (row.changePunchType.punchTypeId) {
            case 0:
                return '<span class="label label-danger ">缺勤</span>';
                break;
            case 1:
                return '<span class="label label-success ">正常</span>';
                break;
            case 2:
                return '<span class="label label-warning ">迟到</span>';
                break;
            case 3:
                return '<span class="label label-info ">请假</span>';
                break;
            default:
                return '<span class="label label-default ">未知</span>';
                break;
        }
    }


    function punchTodayDateFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        var date = row.punchRecordId.punchDatetime;
        var Y = date.year + '-';
        var M = date.monthValue + '-';
        var D = date.dayOfMonth + ' ';
        return Y + M + D;
    }

    function operaFormat() {
        return '<button type=\'button\' onclick=\'agree(true)\' class=\'btn btn-xs btn-success\' >同意</button><button onclick="agree(false)" id=\'ignoreButton\' type=\'button\' class=\'btn btn-xs btn-danger\' >拒绝</button>';
    }

    function agree(status) {
        var selectedRadio = $("#tabs").bootstrapTable("getSelections");
        var memberIdVal = parseInt(${member.memberId});
        var resultStatus = status;
        if (selectedRadio.length === 0) {
            layer.msg('请先勾选你一行数据。。', {icon: 5});
        } else {
            //noinspection JSUnresolvedVariable
            var applicationId = parseInt(selectedRadio[0].applicationId);
            $.ajax({
                        type: 'post',
                        cache: false,
                        dataType: 'json',  //数据传输格式
                        url: "${basePath}/punchLog/applicationMessage/setResult.json",
                        data: {
                            applicationId: applicationId,
                            memberId: memberIdVal,
                            result: resultStatus
                        },
                        success: function (result) {
                            var statusCode = result.status;
                            if (statusCode == 104) {
                                layer.msg("审批成功，请刷新后查看效果", {icon: 1});
                                layer.load(0, {shade: false, time: 1000});
                                $("#tabs").bootstrapTable("refresh");
                            }
                            else if (statusCode == 202) {
                                layer.msg("缺少参数！", {icon: 4});
                            }
                            else if (statusCode == 206) {
                                layer.msg("您在部门的角色不能执行此操作", {icon: 4});
                            }
                            else if (statusCode == 5) {
                                layer.msg("没有你要操作的记录", {icon: 4});
                            }
                            else if (statusCode == 6) {
                                layer.msg("重复处理记录，该记录已被处理完成!", {icon: 4});
                            }
                        },
                        error: function () {
                            layer.msg('出了点小问题！', {icon: 1});
                        }
                    }
            )
        }
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