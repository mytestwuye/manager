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
        <a id="goBack" href="javascript:;" onclick="logoutAction()">退出</a>
    </div>

    <input type="text" id="userName" name="LoginForm[username]" class="txt_input txt_input2" placeholder="请输入用户名"
           autocomplete="off">

    <input type="password" id="passWord" name="LoginForm[password]" class="txt_input" placeholder="请输入密码"
           autocomplete="new-password">


    <div class="codebox">
        <input type="text" id="code" placeholder="请输入验证码">

        <div style="width: 400px;">
            <div style="float:left;width:100px; margin-left: 13px; height:42px;">
                <img style="width:100px; height:42px; cursor: pointer;" title="点击刷新" id="codePanel"
                     src="${pageContext.request.contextPath}/code/generateCode.do"/>
            </div>
        </div>
    </div>

    <p id="error1"></p> <!-- 用户名密码错误提示 -->
    <p id="error2"></p> <!-- 验证码错误提示 -->
    <p id="error3"></p> <!-- 用户名提示 -->
    <a href="javascript:;" id="loginBtn">登录</a>
    <a id="forget" href="#">忘记密码 ?</a>
    <a id="set_username" href="#">学号登录入口 ?</a>
</div>

<!-- 底部版权 -->
<p id="copyright">个人——赣ICP备13015608号-5
    <a target="_blank" href="#"
       style="color: #2f2f2f; padding-left:15px">
        <img src="${pageContext.request.contextPath}/picture/authicon.png"/>
        <span style="margin-left:10px;">赣 公网安备 31010702001486号</span>
    </a>
</p>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/plugins/layer/layer.js"></script>
<script>
    var userName;
    userName = $("#userName");
    var userNameValue;

    var passWord;
    passWord = $('#passWord');
    var passWordValue;

    var code;
    code = $('#code');
    var codeValue;

    var error1;
    error1 = $('#error1');
    var error1Value;
    error1Value = error1.val();
    var error2;
    error2 = $('#error2');
    var error2Value;
    error2Value = error2.val();
    var error3;
    error3 = $('#error3');
    var error3Value;
    error3Value = error3.val();

    //切换验证码
    $("#codePanel").click(function () {
        $(this).attr("src", '${pageContext.request.contextPath}/code/generateCode.do?rand=' + Math.random());
    });

    //输入用户名
    document.getElementById("userName").onkeydown = function () {
        disappearedStyleWarn(userName);
        disappearedStyleWarn(passWord);
        emptyInputValue(error1);
        emptyInputValue(error3);

    };
    //输入密码
    document.getElementById("passWord").onkeydown = function () {
        disappearedStyleWarn(userName);
        disappearedStyleWarn(passWord);
        emptyInputValue(error1);
        emptyInputValue(error3);
    };
    //输入验证码
    document.getElementById("code").onkeydown = function () {
        disappearedStyleWarn(code);
        emptyInputValue(error2);
    };

    //回车登录
    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {
            checkCode();
        }
    };

    function logoutAction(){
        $.ajax({
            type: "Get",
            url: "${pageContext.request.contextPath}/base/logoutAction.do",
            success: function (result) {
                if (result.status !== 199) {
                    alertFunMessage('这都能出错了。。');
                }
                alertMessage('已经强行退出，请尝试重新登录');

            },
            error: function () {
                alertFunMessage('这都能出错了。。');
            }
        })
    }


    //点击登陆按钮时触发的时间
    $('#loginBtn').click(function () {

        userNameValue = userName.val();
        passWordValue = passWord.val();
        codeValue = code.val();

        if (userNameValue == '') {
            error3.text('请填写用户名');
            userName.focus();
            userName.css('border', '2px solid red');
            return false;
        }

        if (passWordValue == '') {
            error1.text('请填写密码');
            passWord.focus();
            passWord.css('border', '2px solid red');
            return false;
        }
        if (codeValue == '') {
            error2.text('请填写验证码');
            code.focus();
            code.css('border', '2px solid red');
            return false;
        }

        //当所有的框都填满了的时候首先检查验证码
        checkCode();

    });

    //验证码验证
    function checkCode() {
        $.ajax({
            url: '${pageContext.request.contextPath}/code/checkCode.do',
            type: 'post',
            data: {formCode: codeValue},
            success: function (result) {
                if (result.status == 113) {
                    layer.msg('验证码错了。。', {icon: 5});
                    error2.text('验证码错误');
                    emptyInputValue(code);
                    code.focus();
                    code.css('border', '2px solid red');
                    refresh();
                    return false;
                }
                else {
                    // 现在开始发送登陆请求
                    sendLoginInfo();
                }

            },
            error: function () {
                layer.msg('服务器开小差了,出了点小问题。。', {icon: 5});
            }
        });
    }

    function sendLoginInfo() {
        var param = {
            username: userNameValue,
            password: passWordValue,
            formCode: codeValue
        };

        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/base/loginAction.json",
            data: param,
            dataType: "json",
            success: function (result) {
                if (!(result.success == false)) {
                    //登录成功
                    layer.msg('登陆成功了', function () {
                        layer.msg('正在进入主页面', {
                            icon: 16
                            , shade: 0.01
                        });
                        setTimeout("goAdminPage()", 300);
                    });

                } else {
                    layer.msg('用户名或者密码错误。。', {icon: 5});
                    error1.text('用户名或密码错误');
                    emptyInputValue(code);
                    redStyleWarn(userName);
                    redStyleWarn(passWord);
                    refresh();
                    return false;
                }
            },
            error: function () {
                layer.msg('调用失败');
            }
        });
    }

    /**
     * 跳转到管理页面
     */
    function goAdminPage() {
        window.parent.location.href = "${pageContext.request.contextPath}/base/goAdminPage.html";
    }

    /**
     * 刷新验证码
     */
    function refresh() {
        $("#codePanel").attr("src", '${pageContext.request.contextPath}/code/generateCode.do?rand=' + Math.random());
    }

    /**
     * 消除输入框的红色边框警示效果消除
     * @param object
     */
    function disappearedStyleWarn(object) {
        object.css('border', '1px solid #d3d3d3');
    }

    /**
     *显示红框警告
     */
    function redStyleWarn(object) {
        object.css('border', '2px solid red');
    }

    /**
     * 把输入框边的警示文字消除
     * @param object
     */
    function emptyInputValue(object) {
        object.text('');
    }

    function alertMessage(message){
        layer.alert(message, {icon: 6});
    }

    function alertFunMessage(message){
        layer.msg(message, {icon: 5});
    }


</script>


</body>
</html>