<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/4/23
  Time: 10:41
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
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/css/personalCenter.css" rel="stylesheet"/>
    <title>用户中心</title>
</head>
<body>
<div class="mYmoneyBox clear">

    <!-- / 左侧 / -->
    <div class="left mYmoneyLeft">
        <div class="mYmoneyuser">
            <img class="mYmoneyuserimg" src="${basePath}/images/userHead.png" alt=""/>
        </div>
        <div class="mYmoneyapprove tc lh26 f14">
            <span class="moneyapprove1">已认证</span>
            <span class="moneyapprove2">|</span>
            <span class="moneyapprove3">软件技术协会成员</span>
        </div>
        <div class="mYmoneyNavList">
            <dl class="mYmoneyNav1 f14">
                <dt><a href="#" class="on00">个人中心</a></dt>
                <dt><a href="#" class="mynav01">业务</a></dt>
                <dd><a href="#">我的预约</a></dd>
                <dd><a href="#">我的需求</a></dd>
                <dd><a href="#">我的订单</a></dd>
                <dd><a href="#">优惠券</a></dd>
                <dt><a href="#" class="mynav02">宣传</a></dt>
                <dd><a href="#">网站管理</a></dd>
                <dd><a href="#">通知公告</a></dd>
                <dd><a href="#">微信消息</a></dd>
                <dd><a href="#">公文收发</a></dd>
                <dt><a href="#" class="mynav03">活动</a></dt>
                <dd><a href="#">活动管理</a></dd>
                <dd><a href="#">短信群发</a></dd>
                <dd><a href="#">问卷调查</a></dd>
                <dd><a href="#">在线投票</a></dd>
                <dd><a href="#">短信管理</a></dd>
                <dt><a href="#" class="mynav04">档案</a></dt>
                <dd><a href="#">我的云盘</a></dd>
                <dd><a href="#">文件共享</a></dd>
                <dd><a href="#">电子期刊</a></dd>
                <dd><a href="#">课题库</a></dd>
                <dd><a href="#">论文库</a></dd>
            </dl>
        </div>
    </div>
    <!-- / 正文 / -->
</div>

<div class="container">
    <div class="userInfo">

    </div>
    <span class="h2">登录记录</span>
    <span class="text-warning">由于宽带运营商不定期调整网络，我们获取IP所在地可能不准确，请通过登录时间与产品判断是否为您本人操作</span>
    <div class="panel-body" style="padding-bottom:0;">
        <table id="table"></table>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/export/bootstrap-table-export.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/extensions/tableExport.js"></script>
<script src="${basePath}/plugins/BootstrapMenu.min.js"></script>
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
        var memberIdVal = "${member.memberId}";
        var oTableInit = {};
        //初始化Table
        oTableInit.Init = function () {
            layer.load(0, {shade: false, time: 1000}); //0代表加载的风格，支持0-2
            $('#table').bootstrapTable({
                url: '${basePath}/session/queryByMemberId.json',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                smartDisplay: false,                 //是否关闭智能隐藏分页按钮
                height: tableHeight(),    //高度调整
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                minimumCountColumns: 2,             //最少允许的列数
                singleSelect: true,           // 单选checkbox
                //height: 500,                        行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "loginHistoryId",                     //每一行的唯一标识，一般为主键列
                exportDataType: "basic",              //basic', 'all', 'selected'.
                detailView: false,                   //是否显示父子表
                columns: [
                    {
                        field: 'historyAccountId',
                        title: '登录账号名',
                        sortable: true,
                        align: 'center',
                        formatter: 'accountFormat'
                    },
                    {field: 'loginBrowser', title: '浏览器', sortable: true, align: 'center'},
                    {field: 'lastLoginTime', title: '最后访问时间', formatter: 'dateFormat'},
                    {field: 'loginOsVersion', title: '操作系统', align: 'center'},
                    {field: 'lastLoginIp', title: '登录IP', align: 'center'},
                    {field: 'loginAddress', title: '登录地址', align: 'center'},
                    {field: 'loginUserAgent', title: 'UA标识', align: 'center'},
                    {field: 'loginStatus', title: '状态', align: 'center', formatter: 'statusFormatter'}
                ],//单击row事件
                locale: "zh-CN", //中文支持
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                memberId: memberIdVal
            };
            return temp;
        };
        return oTableInit;
    };

    function accountFormat(value, row, index) {
        return row.historyAccountId.accountName;
    }

    function dateFormat(value, row, index) {
        var date = new Date(row.lastLoginTime);
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y + M + D + h + m + s;
    }


    // 格式化状态
    function statusFormatter(value, row, index) {
        if (value == '1') {
            return '<span class="label label-success">成功</span>';
        }
        if (value == '0') {
            return '<span class="label label-default">失败</span>';
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