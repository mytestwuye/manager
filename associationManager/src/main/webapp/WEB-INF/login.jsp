<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/5/005
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>协会管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<!-- logo -->
<img id="logo" src="${pageContext.request.contextPath}/picture/logo.png" alt="">
<!-- 登录框 -->
<div id="loginBox">
    <div class="topPart">
        <h2>登陆入口</h2>
        <a id="goback" href="#">返回</a>
    </div>

    <input type="text" id="userName" name="LoginForm[username]" class="txt_input txt_input2" placeholder="请输入用户名"
           autocomplete="off">

    <div id="softkey"></div>

    <input type="password" id="passWord" name="LoginForm[password]" class="txt_input" placeholder="请输入密码"
           autocomplete="new-password">

    <div id="softkey2"></div>

    <div class="codebox">
        <input type="text" id="code" placeholder="请输入验证码">

        <div style="width: 400px;">
            <div style="float:left;width:100px; margin-left: 13px; height:42px;">
                <img style="width:100px; height:42px; cursor: pointer;" title="点击刷新" id="getcode_num"
                     src="${pageContext.request.contextPath}/code/verifyCode"/>
            </div>
        </div>
        <div id="softkey3"></div>
    </div>

    <p id="error1"></p> <!-- 用户名密码错误提示 -->
    <p id="error2"></p> <!-- 验证码错误提示 -->
    <p id="error3"></p> <!-- 用户名提示 -->
    <a href="javascript:;" id="loginBtn">登录</a>
    <a id="forget" href="#">忘记密码 ?</a>
    <a id="set_username" href="#">学号登录入口 ?</a>
</div>

<!-- 底部版权 -->
<%--<p id="copyright">公司——沪ICP备13015608号-5
    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010702001486"
       style="color: #2f2f2f; padding-left:15px">
        <img src="Picture/authicon.png"/>
        <span style="margin-left:10px;">沪公网安备 31010702001486号</span>
    </a>
</p>--%>

<style>

    .p_key3 {
        position: absolute;
        right: 270px;
        top: 165px;
        width: 32px;
        height: 32px;
        background: url('${pageContext.request.contextPath}/images/keyboard.png') no-repeat;
    }

    #softkey, #softkey2 {
        position: absolute;
    }

    #softkey3 {
        left: -160px;
        top: -100px;
        margin: 0 auto;
        position: absolute;
        text-align: center;
    }

</style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
<script>


    //切换验证码
    $("#getcode_num").click(function () {
        $(this).attr("src", '${pageContext.request.contextPath}/code/verifyCode?rand=' + Math.random());
    });

    //输入用户名
    document.getElementById("userName").onkeydown = function () {
        $('#userName').css('border', '1px solid #d3d3d3');
        $('#passWord').css('border', '1px solid #d3d3d3');
        $('#error1').text('');
        $('#error3').text('');
    };
    //输入密码
    document.getElementById("passWord").onkeydown = function () {
        $('#userName').css('border', '1px solid #d3d3d3');
        $('#passWord').css('border', '1px solid #d3d3d3');
        $('#error1').text('');
        $('#error3').text('');
    };
    //输入验证码
    document.getElementById("code").onkeydown = function () {
        $('#code').css('border', '1px solid #d3d3d3');
        $('#error2').text('');
    };

    //回车登录
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            checkLogin();
        }
    };


    $('#loginBtn').click(function () {
        var username = $('#userName').val();
        var password = $('#passWord').val();
        var code = $('#code').val();

        if (username == '') {
            $('#error3').text('请填写用户名');
            $('#userName').focus();
            $('#userName').css('border', '2px solid red');
            return false;
        }

        if (password == '') {
            $('#error1').text('请填写密码');
            $('#passWord').focus();
            $('#passWord').css('border', '2px solid red');
            return false;
        }
        if (code == '') {
            $('#error2').text('请填写验证码');
            $('#code').focus();
            $('#code').css('border', '2px solid red');
            return false;
        }
        checkCode();

    });

    //验证码登录
    function checkCode() {
        alert("准备发送检查验证码");
        var code = $('#code').val();
        $.ajax({
            url: '${pageContext.request.contextPath}/code/validCode',
            type: 'post',
            data: {code: code},
            success: function (result) {
                if (result.desc == 113) {
                    layer.msg('验证码错了。。', {icon: 5});
                    $('#error2').text('验证码错误');
                    $('#code').val('');
                    $('#code').focus();
                    $('#code').css('border', '2px solid red');
                    $("#getcode_num").attr("src", '${pageContext.request.contextPath}/code/verifyCode?rand=' + Math.random());
                    return false;
                }
                else {
                    sendLoginInfo();
                }

            },
            error: function () {
                layer.msg('服务器开小差了,出了点小问题。。', {icon: 5});
            }
        });
    }

    function sendLoginInfo() {
        alert("准备登陆");
        var param = {
            username: $("#userName").val(),
            password: $("#passWord").val(),
            code: $('#code').val()
        };

        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/checkLogin.json",
            data: param,
            dataType: "json",
            success: function (result) {
                if (result.status == 0) {
                    alert(result.data);
                    $('#error1').text('用户名或密码错误');
                    $('#code').val('');
                    $('#userName').css('border', '2px solid red');
                    $('#passWord').css('border', '2px solid red');
                    $("#getcode_num").attr("src", '${pageContext.request.contextPath}/code/verifyCode?rand=' + Math.random());
                    return false;
                } else {
                    //登录成功
                    layer.msg('登陆成功了', function () {
                        layer.msg('正在进入主页面', {
                            icon: 16
                            , shade: 0.01
                        });
                        var t = setTimeout("goAdminPage()", 300);
                    });

                }
            },
            error: function (result) {
                alert("调用失败....");

            }
        });
    }

    function goAdminPage() {
        window.parent.location.href = "${pageContext.request.contextPath}/admin-manager.html";
    }


</script>


</body>
</html>