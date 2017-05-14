<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/15/015
  Time: 20:18
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
    <title>协会档案管理</title>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-editable.css"
          rel="stylesheet"/>
    <style>
        .panel {
            margin-bottom: 0;
        }
    </style>
</head>
<body>
<div class="panel-body container" style="padding-bottom:0;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_departmentname">
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_status"></label>
                    <div class="btn-group" id="txt_search_status">
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="2" checked="checked">
                            全部状态
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="1"> 正常状态
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="0"> 冻结状态
                        </label>
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary"
                                onclick="refresh()">查询
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

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
        <button id="btn_update" type="button" class="btn btn-default">
            <span class=" glyphicon glyphicon-arrow-up" aria-hidden="true"></span>上传新成员数据
        </button>
    </div>
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
                url: '${basePath}/member/queryAll.json',         //请求后台的URL（*）
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
                    {title: "全选", field: "select", checkbox: true, width: 20, align: "center", valign: "middle"},
                    {title: "ID", field: "memberId", sortable: true, order: "desc"},
                    {field: "memberName", title: "姓名", sortable: true, titleTooltip: "this is name"},
                    {field: "memberClassName", title: "班级名字", sortable: true, order: "desc"},
                    {field: "memberSex", title: "性别", sortable: true, order: "desc", formatter: 'sexFormatter'},
                    {field: "memberGradeNumber", title: "年级", sortable: true, order: "desc"},
                    {field: "member_manager_id", title: "管理员", sortable: true, order: "desc"},
                    {field: "department", title: "部门", sortable: true, order: "desc", formatter: "departmentFormatter"},
                    {
                        field: "memberStatus",
                        title: "状态",
                        sortable: true,
                        order: "desc",
                        formatter: "memberStatusFormatter"
                    },
                    {field: "memberRoles", title: "角色", sortable: true, order: "desc", formatter: "memberRoleFormatter"}
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
                status: parseInt($("#txt_search_status").find("input:radio:checked").val())
            };
            return temp;
        };
        return oTableInit;
    };

    function memberStatusFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        var memberStatus = row.memberStatus;
        if (memberStatus == true) {
            return '<span class="label label-success account-status">正常</span>';
        }
        if (memberStatus == false) {
            return '<span class="label label-default account-status">冻结</span>';
        }
    }

    function sexFormatter(value, row, index) {
        return row.memberSex == true ? "男" : "女";
    }

    function departmentFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.memberDepartment.departmentName;
    }


    function memberRoleFormatter(value, row, index) {
        //noinspection JSUnresolvedVariable
        return row.memberRoles.memberRoleName;
    }


    //新增按钮的方法
    $("#btn_add").click(function () {
        insertMember();
    });
    function insertMember() {
        //弹出即全屏
        var index = layer.open({
            type: 2,
            content: '${basePath}/member/insert.html',
            area: ['260px', '500px'],
            maxmin: true
        });
    }


    //编辑按钮的方法
    $("#btn_edit").click(function () {
        var selectedRadio = $('#tabs').bootstrapTable('getSelections');
        if (selectedRadio.length === 0) {
            layer.msg('请先勾选你要编辑的一行数据。。', {icon: 5});
        } else {
            var memberId = selectedRadio[0].memberId;
            editMember(memberId);
        }
    });

    /**
     * 准备编辑表格操作
     */
    function editMember(memberId) {
        //iframe层-父子操作
        var index = layer.open({
            type: 2,
            area: ['300px', '530px'],
            fixed: true, //不固定
            maxmin: true,
            content: '${basePath}/member/update.html/' + memberId
        });


    }

    //删除按钮的方法
    $("#btn_delete").click(function () {
        var selectedRaido = $('#tabs').bootstrapTable('getSelections');
        if (selectedRaido.length === 0) {
            layer.msg('请先勾选一条你要删除的数据。。', {icon: 5});
        } else {
            //询问框
            layer.confirm('您确定要删除【' + selectedRaido[0].memberName + "】这条成员的信息吗?", {
                btn: ['确定', '点错了'] //按钮
            }, function () {
                layer.msg('准备删除了', {icon: 1});
                var memberId = selectedRaido[0].memberId;
                deleteMember(memberId);
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
    function deleteMember(memberId) {
        $.ajax({
            type: "get",
            url: "${basePath}/member/deleteById.json/" + memberId,
            success: function (result) {
                if (result.status == 5) {
                    layer.msg("没有你要删除的信息", {icon: 4});

                } else if (result.status == 103) {
                    layer.msg("删除成功了，请刷新", {icon: 1});
                    layer.load(0, {shade: false, time: 1000});
                    $("#tabs").bootstrapTable("refresh");

                } else if (result.status == 204) {
                    layer.msg("存在引用账号，无法删除", {icon: 4});
                }
                else {
                    layer.msg("出了点小问题", {icon: 4});
                }
            },
            error: function () {
                layer.msg('出错了！', {icon: 1});
            }
        })
    }

    $("#btn_update").click(function () {
        //弹出即全屏
        var index = layer.open({
            type: 2,
            content: '${basePath}/member/uploadMemberInfo.html',
            area: ['260px', '500px'],
            maxmin: true
        });
        layer.full(index);
    });


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