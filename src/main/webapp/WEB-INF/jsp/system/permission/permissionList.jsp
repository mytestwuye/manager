<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/5/2
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
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>权限管理页面</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
</head>
<body>
<div class="panel-body" style="padding-bottom:0;">

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default btn-info">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default btn-warning">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default btn-danger">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>
    <table id="mable" class="table table-hover"></table>
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
        $("#mable").bootstrapTable("refresh");
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
            $('#mable').bootstrapTable('resetView', {
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
            $('#mable').bootstrapTable({
                url: '${basePath}/system/permission/queryAll.json',         //请求后台的URL（*）
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
                pageList: [5, 10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                singleSelect: true,           // 单选checkbox
                //height: 500,                        行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "permissionId",                     //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                showExport: true,                     //是否显示导出
                exportDataType: "basic",              //basic', 'all', 'selected'.
                detailView: false,                   //是否显示父子表
                rowStyle: function (row, index) {
                    //这里有5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
                    var subclass = "";
                    if (row.accountStatus == false) {
                        subclass = 'danger';//还有一个active
                    }
                    else if (row.accountName == "已删除") {
                        subclass = 'danger';
                    }
                    else {
                        return {};
                    }
                    return {classes: subclass}
                },
                columns: [
                    {title: "全选", field: "select", checkbox: true, width: 20, align: "center", valign: "middle"},
                    {title: "ID", field: "permissionId", sortable: true, order: "desc", align: "center"},
                    {
                        field: "permissionName",
                        title: "权限名",
                        sortable: true,
                        titleTooltip: "this is name",
                        align: "center"
                    },
//                    {field: "accountPassword", title: "密码", order: "desc"},
                    {field: "description", title: "权限解释", sortable: true, order: "desc", align: "center"},
                    {
                        field: "createTime",
                        title: "创建时间",
                        sortable: true,
                        order: "desc",
                        align: "center",
                        formatter: "dateFormat"
                    },
                    {
                        field: "permissionStatus",
                        title: "权限状态",
                        sortable: true,
                        order: "desc",
                        formatter: "permissionStatusFormatter",
                        align: "center"
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
            return {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                status: $("#txt_search_status").val()
            };
        };
        return oTableInit;
    };

    function permissionStatusFormatter(value, row, index) {
        if (value == true) {
            return '<span class="label label-success account-status">正常</span>';
        }
        if (value == false) {
            return '<span class="label label-default account-status">冻结</span>';
        }
    }

    function dateFormat(value, row, index) {
        var date = new Date(row.createTime);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y + M + D + h + m + s;
    }


    var ButtonInit = function () {
        var oInit = {};
        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };
        return oInit;
    };

    //新增按钮的方法
    $("#btn_add").click(function () {
        insertion();
    });
    function insertion() {
        //弹出即全屏
        layer.open({
            type: 2,
            content: '${basePath}/system/permission/insert.html',
            area: ['320px', '580px'],
            maxmin: true
        });
    }

    //编辑按钮的方法
    $("#btn_edit").click(function () {
        var selectedRadio = $('#mable').bootstrapTable('getSelections');
        if (selectedRadio.length === 0) {
            layer.msg('请先勾选你要编辑的一行数据。。', {icon: 5});
        } else {
            var permissionId = selectedRadio[0].permissionId;
            editMember(permissionId);
        }
    });

    /**
     * 准备编辑表格操作
     */
    function editMember(permissionId) {
        //iframe层-父子操作
        layer.open({
            type: 2,
            area: ['300px', '620px'],
            fixed: true, //不固定
            maxmin: true,
            content: '${basePath}/system/permission/update.html/' + permissionId
        });

    }

    //删除按钮的方法
    $("#btn_delete").click(function () {
        var selectedRadio = $('#mable').bootstrapTable('getSelections');
        if (selectedRadio.length === 0) {
            layer.msg('请先勾选一条你要删除的权限数据。。', {icon: 5});
        } else {
            //询问框
            layer.confirm('您确定要删除【' + selectedRadio[0].permissionName + "】这条权限的信息吗?", {
                btn: ['确定', '点错了'] //按钮
            }, function () {
                layer.msg('准备删除了', {icon: 1});
                var permissionId = selectedRadio[0].permissionId;
                delectation(permissionId);
            }, function () {
                layer.msg('已经取消了', {
                    time: 20000 //20s后自动关闭
                });
            });
        }
    });


    /**
     * 提交删除表格操作
     * */
    function delectation(permissionId) {
        $.ajax({
                    type: "get",
                    url: "${basePath}/system/permission/deleteById.json/" + permissionId,
                    success: function (result) {
                        var statusCode = result.status;
                        if (statusCode == 103) {
                            layer.msg("删除成功，请刷新后查看效果", {icon: 1});
                            layer.load(0, {shade: false, time: 1000});
                            $("#mable").bootstrapTable("refresh");
                        }
                        else if (statusCode == 204) {
                            layer.msg("权限存在引用，无法删除", {icon: 4});
                        }
                        else if (statusCode == 7) {
                            layer.msg("权限为系统初始权限限制，不能够删除", {icon: 4});
                        }
                        else if (statusCode == 5) {
                            layer.msg("没有查询到你要删除的权限", {icon: 4});
                        }
                    },
                    error: function () {
                        layer.msg('出了点小问题！', {icon: 1});
                    }
                }
        )
    }
</script>
</html>



























