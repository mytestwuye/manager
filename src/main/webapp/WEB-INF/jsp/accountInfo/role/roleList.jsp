<%--@elvariable id="basePath" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/11
  Time: 18:17
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>操作记录查看</title>
    <link href="${basePath}/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/css/admin.css" rel="stylesheet"/>
    <link href="${basePath}/css/common.css" rel="stylesheet"/>
</head>
<body>
<div>
    <div class="panel-body">
            <div id="toolbar" class="btn-group">
                <button id="btn_add" type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                </button>
                <button id="btn_edit" type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                </button>
                <button id="btn_delete" type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                </button>
            </div>
        <table id="table"></table>
    </div>
</div>

<!-- 新增 -->
<div id="createDialog" class="crudDialog" hidden>
    <form>
        <div class="form-group">
            <label for="roleId">角色ID</label>
            <input id="roleId" type="text" class="form-control" value="">
        </div>
        <div class="form-group">
            <label for="roleName">角色名字</label>
            <input id="roleName" type="text" class="form-control" value="">
        </div>
    </form>
</div>


</body>

<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${basePath}/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${basePath}/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/plugins/device.min.js"></script>
<script src="${basePath}/plugins/waves-0.7.5/waves.min.css"></script>
<script src="${basePath}/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${basePath}/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${basePath}/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<script src="${basePath}/plugins/select2/js/select2.min.js"></script>
<script src="${basePath}/plugins/jquery.cookie.js"></script>
<script src="${basePath}/js/admin.js"></script>
<script src="${basePath}/js/common.js"></script>
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
                url: '${basePath}/account/role/list.json',         //请求后台的URL（*）
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
                uniqueId: "roleId",                     //每一行的唯一标识，一般为主键列
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
                    {title: "全选", field: "select", checkbox: true, width: 20,align: "center",valign: "middle"},
                    {field: 'roleId', title: '角色ID', sortable: true, align: 'center'},
                    {field: 'roleName', title: '角色名字', sortable: true, align: 'center'},
                    {field: 'createTime', title: '创建时间', sortable: true, align: 'center',formatter: 'dateFormat'},
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

    function dateFormat(value, row, index) {
        var date = new Date(row.createTime);
        Y = date.getFullYear() + '-';
        M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        D = date.getDate() + ' ';
        h = date.getHours() + ':';
        m = date.getMinutes() + ':';
        s = date.getSeconds();
        return Y + M + D + h + m + s;
    }
    //新增按钮的方法
    $("#btn_add").click(function () {
        createAction();
    });

    function createAction() {
        $.confirm({
            type: 'dark',
            animationSpeed: 300,
            title: '新增系统',
            content: $('#createDialog').html(),
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button',
                    action: function () {
                        $.alert('确认');
                    }
                },
                cancel: {
                    text: '取消',
                    btnClass: 'waves-effect waves-button'
                }
            }
        });
    }

    $("#btn_edit").click(function () {
        updateAction();
    })
    function updateAction() {
    }

    
    // 删除
    function deleteAction() {
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
            $.confirm({
                type: 'red',
                animationSpeed: 300,
                title: false,
                content: '确认删除该系统吗？',
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'waves-effect waves-button',
                        action: function () {
                            var ids = new Array();
                            for (var i in rows) {
                                ids.push(rows[i].systemId);
                            }
                            $.alert('删除：id=' + ids.join("-"));
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




    //删除按钮的方法
    $("#btn_delete").click(function () {
        var selectedRadio = $('#mytab').bootstrapTable('getSelections');
        if (selectedRadio.length === 0) {
            layer.msg('请先勾选一条你要删除的数据。。', {icon: 5});
        } else {
            //询问框
            layer.confirm('您确定要删除【' + selectedRadio[0].accountName + "】这条成员的信息吗?", {
                btn: ['确定', '点错了'] //按钮
            }, function () {
                layer.msg('准备删除了', {icon: 1});
                var accountId = selectedRadio[0].accountId;
                delectation(accountId);
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
    function delectation(accountId) {
        $.ajax({
                    type: "get",
                    url: "${basePath}/account/deleteById.json/" + accountId,
                    success: function (result) {
                        if (result.status == 201) {
                            layer.msg(result.message, {icon: 1});
                            layer.load(0, {shade: false, time: 1000});
                            $("#mytab").bootstrapTable("refresh");

                        }
                        else {
                            layer.msg(result.message, {icon: 4});
                        }
                    },
                    error: function () {
                        layer.msg('出错了！', {icon: 1});
                    }
                }
        )
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