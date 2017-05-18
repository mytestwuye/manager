<%--@elvariable id="account" type="com.suny.association.pojo.po.Account"--%>
<%--@elvariable id="member" type="com.suny.association.pojo.po.Member"--%>
<%--
  Created by IntelliJ IDEA.
  User: 孙建荣
  Date: 2017/3/8/008
  Time: 17:54
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta name="MobileOptimized" content="320">
    <title>江西现代技术学院软件技术协会管理系统</title>

    <link href="${basePath}/plugins/fullPage/jquery.fullPage.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="${basePath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="${basePath}/css/admin.css" rel="stylesheet"/>
    <style>
        /** skins **/
        #zheng-upms-server #header {
            background: #29A176;
        }

        #zheng-upms-server .content_tab {
            background: #29A176;
        }

        #zheng-upms-server .s-profile > a {
            background: url(${basePath}/images/upms.png) left top no-repeat;
        }

        #zheng-cms-admin #header {
            background: #455EC5;
        }

        #zheng-cms-admin .content_tab {
            background: #455EC5;
        }

        #zheng-cms-admin .s-profile > a {
            background: url(${basePath}/images/cms.png) left top no-repeat;
        }

        #zheng-pay-admin #header {
            background: #F06292;
        }

        #zheng-pay-admin .content_tab {
            background: #F06292;
        }

        #zheng-pay-admin .s-profile > a {
            background: url(${basePath}/images/pay.png) left top no-repeat;
        }

        #zheng-ucenter-home #header {
            background: #6539B4;
        }

        #zheng-ucenter-home .content_tab {
            background: #6539B4;
        }

        #zheng-ucenter-home .s-profile > a {
            background: url(${basePath}/images/ucenter.png) left top no-repeat;
        }

        #zheng-oss-web #header {
            background: #0B8DE5;
        }

        #zheng-oss-web .content_tab {
            background: #0B8DE5;
        }

        #zheng-oss-web .s-profile > a {
            background: url(${basePath}/images/oss.png) left top no-repeat;
        }

        /*#test #header {
           //  background: test;
         }

         #test .content_tab {
             background: test;
         }*!
*/
        /*#test .s-profile > a {
            background: url() left top no-repeat;
        }
    </style>
</head>
<body>
<div>
    <header id="header">
        <ul id="menu">
            <li id="guide" class="line-trigger">
                <div class="line-wrap">
                    <div class="line top"></div>
                    <div class="line center"></div>
                    <div class="line bottom"></div>
                </div>
            </li>
            <li id="logo" class="hidden-xs">
                <a href="${basePath}/base/goAdminPage.html">
                    <img src="${basePath}/images/logo.png"/>
                </a>
                <span id="system_title">协会管理系统</span>
            </li>
            <li class="pull-right">
                <ul class="hi-menu">
                    <!-- 搜索 -->
                    <li class="dropdown">
                        <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="him-icon zmdi zmdi-search"></i>
                        </a>
                        <ul class="dropdown-menu dm-icon pull-right">
                            <form id="search-form" class="form-inline">
                                <div class="input-group">
                                    <input id="keywords" type="text" name="keywords" class="form-control"
                                           placeholder="搜索"/>
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><span
                                                class="glyphicon glyphicon-search"></span></button>
                                    </div>
                                </div>
                            </form>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="him-icon zmdi zmdi-dropbox"></i>
                        </a>
                        <ul class="dropdown-menu dm-icon pull-right">
                            <li class="skin-switch">
                                请选择系统切换
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="waves-effect switch-systems" href="javascript:;" systemid="1"
                                   systemname="zheng-upms-server" systemtitle="协会管理系统"><i
                                        class="zmdi zmdi-shield-security"></i>江西现代技术学院软件技术协会管理系统</a>
                            </li>

                            <%--<li>
                                <a class="waves-effect switch-systems" href="javascript:;" systemid="2"
                                   systemname="zheng-cms-admin" systemtitle="内容管理系统"><i class="zmdi zmdi-wikipedia"></i>
                                    内容管理系统</a>
                            </li>

                            <li>
                                <a class="waves-effect switch-systems" href="javascript:;" systemid="3"
                                   systemname="zheng-pay-admin" systemtitle="支付管理系统"><i
                                        class="zmdi zmdi-paypal-alt"></i>
                                    支付管理系统</a>
                            </li>

                            <li>
                                <a class="waves-effect switch-systems" href="javascript:;" systemid="4"
                                   systemname="zheng-ucenter-home" systemtitle="用户管理系统"><i
                                        class="zmdi zmdi-account"></i>
                                    用户管理系统</a>
                            </li>

                            <li>
                                <a class="waves-effect switch-systems" href="javascript:;" systemid="5"
                                   systemname="zheng-oss-web" systemtitle="存储管理系统"><i class="zmdi zmdi-cloud"></i>
                                    存储管理系统</a>
                            </li>--%>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                            <i class="him-icon zmdi zmdi-more-vert"></i>
                        </a>
                        <ul class="dropdown-menu dm-icon pull-right">
                            <li class="hidden-xs">
                                <a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i
                                        class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
                            </li>
                            <li>
                                <a class="waves-effect" data-ma-action="clear-localstorage" href="javascript:;"><i
                                        class="zmdi zmdi-delete"></i> 清除缓存</a>
                            </li>
                            <li>
                                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                            </li>
                            <li>
                                <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
                            </li>
                            <li>
                                <a class="waves-effect" href="javascript:;" onclick="clickLogout()"><i
                                        class="zmdi zmdi-run"></i> 退出登录</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
    <section id="main">
        <!-- 左侧导航区 -->
        <aside id="sidebar">
            <!-- 个人资料区 -->
            <div class="s-profile">
                <a class="waves-effect waves-light" href="javascript:;">
                    <div class="sp-pic">
                        <img src="${basePath}/images/avatar.jpg"/>
                    </div>
                    <div class="sp-info">
                        <%--<shiro:principal/>--%>
                        <%--<shiro:user></shiro:user>--%>
                        【${member.memberRoles.memberRoleName}】 ${member.memberName}，您好！
                        <i class="zmdi zmdi-caret-down"></i>
                    </div>
                </a>
                <ul class="main-menu">
                    <li>
                        <a class="waves-effect"
                           href="javascript:Tab.addTab('个人信息', '${basePath}/account/getUserInfo.html');"><i
                                class="zmdi zmdi-account"></i> 个人资料</a>
                    </li>
                    <li>
                        <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                    </li>
                    <li>
                        <a class="waves-effect" data-toggle="modal" data-target="#myModal"><i
                                class="zmdi zmdi-settings"></i> 修改密码</a>
                    </li>
                    <li>
                        <a class="waves-effect" href="javascript:;" onclick="clickLogout()"><i
                                class="zmdi zmdi-run"></i>
                            退出登录</a>
                    </li>
                </ul>
            </div>

            <%--<h2>创建模态框（Modal）</h2>--%>
            <!-- 按钮触发模态框 -->
            <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
            <!-- 模态框（Modal） -->

            <!-- /个人资料区 -->
            <!-- 菜单区 -->
            <ul class="main-menu">
                <li>
                    <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i>
                        首页</a>
                </li>
                <li class="sub-menu system_menus system_1 0">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 协会信息管理</a>
                    <ul>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('协会成员信息', '${basePath}/member/memberManager.html');">协会成员信息</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('协会角色管理', '${basePath}/member/role/index.html');">协会角色管理</a>
                        </li>

                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('考勤记录查看', '${basePath}/punchLog/index.html');">考勤记录查看</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('异议考勤审批', '${basePath}/punchLog/applicationMessage/index.html');">异议考勤审批</a>
                        </li>

                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('考勤审批记录', '${basePath}/punchLog/applyForResult/index.html');">考勤审批记录</a>
                        </li>
                    </ul>
                </li>
                <li class="sub-menu system_menus system_1 0">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts-list"></i> 系统组织管理</a>
                    <%-- <ul>
                         <li><a class="waves-effect"
                                href="javascript:Tab.addTab('系统管理', '${basePath}/systemConfig.html');">系统管理</a>
                         </li>
                         <li><a class="waves-effect"
                                href="javascript:Tab.addTab('组织管理', '${basePath}/manage/organization/index');">组织管理</a>
                         </li>
                     </ul>--%>
                </li>
                <li class="sub-menu system_menus system_1 3">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-accounts"></i> 账号信息管理</a>
                    <ul>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('账号角色管理', '${basePath}/account/role/index.html');">账号角色管理</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('账号信息管理', '${basePath}/account/accountManager.html');">账号信息管理</a>
                        </li>
                    </ul>
                </li>
                <li class="sub-menu system_menus system_1 6">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-lock-outline"></i> 权限资源管理</a>
                    <ul>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('权限管理', '${basePath}/system/permission/index.html');">角色权限管理</a>
                        </li>

                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('权限分配', '${basePath}/system/permission/allot/index.html');">角色权限分配</a>
                        </li>

                    </ul>
                </li>
                <li class="sub-menu system_menus system_1 7">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-more"></i> 其他数据管理</a>
                    <ul>
                        <%-- <li><a class="waves-effect"
                                href="javascript:Tab.addTab('公共码表', '${basePath}/manage/coder/index');">公共码表</a>
                         </li>--%>

                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('登录日志', '${basePath}/session/index.html');">登录日志</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('操作日志', '${basePath}/operations/log/index.html');">操作日志</a>
                        </li>
                        <%--  <li><a class="waves-effect"
                                 href="javascript:Tab.addTab('键值设置', '${basePath}/manage/map/index');">键值设置</a>
                          </li>--%>
                    </ul>
                </li>
                <%--<li class="sub-menu system_menus system_2 12" style="display:none;">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-menu"></i> 标签类目管理</a>
                    <ul>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('标签管理', '${basePath}/manage/tag/index');">标签管理</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('类目管理', '${basePath}/manage/category/index');">类目管理</a>
                        </li>
                    </ul>
                </li>--%>
                <%--<li class="sub-menu system_menus system_2 15" style="display:none;">
                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-collection-text"></i> 文章内容管理</a>
                    <ul>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('文章管理', '${basePath}/manage/article/index');">文章管理</a>
                        </li>
                        <li><a class="waves-effect"
                               href="javascript:Tab.addTab('回收管理', '${basePath}/manage/article/recycle');">回收管理</a>
                        </li>
                    </ul>
                </li>--%>
                <li>
                    <div class="upms-version">
                        &copy; sunybyjava@gmail.com V1.0.0
                    </div>
                </li>
            </ul>
            <!-- /菜单区 -->
        </aside>
        <!-- /左侧导航区 -->
        <section id="content">
            <div class="content_tab">
                <div class="tab_left">
                    <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
                </div>
                <div class="tab_right">
                    <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
                </div>
                <ul id="tabs" class="tabs">
                    <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                        <a class="waves-effect waves-light">首页</a>
                    </li>
                </ul>
            </div>
            <div class="content_main">
                <div id="iframe_home" class="iframe cur">
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="myModalLabel">修改用户密码</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <div class="col-sm-10">
                                                <input class="form-control" type="text" id="password"
                                                       placeholder="输入原密码">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10">
                                                <input class="form-control" type="password" id="newPassword"
                                                       placeholder="输入新密码">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-10">
                                                <input class="form-control" type="password" id="repeatPassword"
                                                       placeholder="重复新密码">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary" onclick="changePassword()">提交更改
                                    </button>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>
                    <p><h4>江西现代技术学院软件技术协会管理系统 <i style="color:#c00"></i></h4></p>
                    <p><b>演示地址</b>：<a href="http://182.254.149.200" target="_blank">点击访问我的网站首页</a></p>
                    <%--<p><b>系统简介</b>：本系统是基于RBAC授权和基于用户授权的细粒度权限控制通用平台，并提供单点登录、会话管理和日志管理。接入的系统可自由定义组织、角色、权限、资源等。</p><br/>--%>
                    <p><h4>系统功能概述：</h4></p>
                    <p><b>系统组织管理</b>：系统和组织增加、删除、修改、查询功能。</p>
                    <p><b>用户角色管理</b>：用户和角色增加、删除、修改、查询功能。</p>
                    <p><b>资源权限管理</b>：资源和权限增加、删除、修改、查询功能。</p>
                    <p><b>权限分配管理</b>：提供给角色和用户的权限增加、删除、修改、查询功能。</p>
                    <%--<p><b>单点登录(SSO)</b>：提供统一用户单点登录认证、用户鉴权功能。</p>--%>
                    <%--<p><b>用户会话管理</b>：提供分布式用户会话管理</p>--%>
                    <p><b>操作日志管理</b>：提供记录用户登录、操作等日志。</p><br/>
                    <%--<p><h4>对外接口概述：</h4></p>--%>
                    <%--<p><b>系统组织数据接口</b>、<b>用户角色数据接口</b>、<b>资源权限数据接口</b>、<b>单点登录(SSO)接口</b>、<b>用户鉴权接口</b></p><br/>--%>
                    <p><h4>关于作者</h4></p>
                    <p><b>姓　　名</b>：孙建荣</p>
                    <p><b>电子邮箱</b>：sunybyjava@gmail.com</p>
                </div>
            </div>
        </section>
    </section>
    <footer id="footer"></footer>
</div>

<script src="${basePath}/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="${basePath}/plugins/waves-0.7.5/waves.min.js"></script>
<script src="${basePath}/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${basePath}/plugins/BootstrapMenu.min.js"></script>
<script src="${basePath}/plugins/device.min.js"></script>
<script src="${basePath}/plugins/fullPage/jquery.fullPage.min.js"></script>
<script src="${basePath}/plugins/fullPage/jquery.jdirk.min.js"></script>
<script src="${basePath}/plugins/jquery.cookie.js"></script>
<script src="${basePath}/plugins/select2/js/select2.min.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script src="${basePath}/js/common.js"></script>
<script src="${basePath}/js/admin.js"></script>
<script>
    function changePassword() {
        var passwordVal;
        var newPasswordVal;
        var repeatPasswordVal;
        passwordVal = $("#password").val();
        newPasswordVal = $("#newPassword").val();
        repeatPasswordVal = $("#repeatPassword").val();
        console.log("原密码" + passwordVal);
        console.log("新密码" + newPasswordVal);
        console.log("重复密码" + repeatPasswordVal);
        if (passwordVal == null || passwordVal == "") {
            layer.alert("原密码不能为空");
            return false;
        }
        if (newPasswordVal == null || newPasswordVal == "" || newPasswordVal.length < 9) {
            if (newPasswordVal == "") {
                layer.alert("新密码不能为空");
                return false;
            }
            else {
                layer.alert("为了您的密码安全密码长度必须大于9位，不能是简单的密码,当前长度" + newPasswordVal.length);
                return false;
            }
        }
        if (repeatPasswordVal == null || repeatPasswordVal == "" || repeatPasswordVal.length < 9) {
            if (repeatPasswordVal == "") {
                layer.alert("重复新密码不能为空");
                return false;
            }
            else {
                layer.alert("为了您的密码安全密码长度必须大于9位，不能是简单的密码,当前重复密码长度" + repeatPasswordVal.length);
                return false;
            }
        }
        if (repeatPasswordVal != newPasswordVal) {
            layer.alert("新密码跟重复密码必须要填写一样，证明您记住了新密码");
            return false;
        }
        $.ajax({
            type: "post",
            url: "${basePath}/account/changePassword.json",
            data: {
                passWord: passwordVal,
                newPassword: newPasswordVal,
                accountId:${account.accountId}
            },
            success: function (result) {
                var status = result.status;
                if (status == 201) {
                    layer.alert("密码不能为空！");
                } else if (status == 207) {
                    layer.alert("请检查新密码长度不能小于9位！");
                } else if (status == 5) {
                    layer.alert("没有你要修改密码的账号！");
                } else if (status == 208) {
                    layer.alert("老密码填写错误，请重新检查您的老密码！");
                } else if (status == 104) {
                    layer.alert("更新密码成功，请重新用新密码登录！");
                    layer.confirm('密码更新成功了！', {
                        btn: ['我知道了'] //按钮
                    }, function () {
                        layer.load(0, {shade: false});   //0代表加载的风格，支持0-2
                        setTimeout(login(), 5000);
                    });

                } else if (status == 4) {
                    layer.alert("服务器更新密码出了点小问题，请重试！");
                } else if (status == 211) {
                    layer.alert("恶意修改他人密码！");
                } else {
                    layer.alert("出了点未知的小问题！");
                }
            }, error: function (result) {
                layer.alert("服务器出了点小问题");
            }
        })
    }
    function clickLogout() {
        //询问框
        layer.confirm('您确定要退出登陆吗？', {
            btn: ['是的', '点错了'] //按钮
        }, function () {
            sendLogout();
            layer.load();
            setTimeout(login, 2000);
        }, function () {
            layer.msg('取消退出登陆', {
                time: 20000 //20s后自动关闭
            });
        });
    }
    function sendLogout() {
        $.ajax({
            type: "Get",
            url: "${basePath}/base/logoutAction.do",
            success: function (result) {
                if (result.status !== 993) {
                    alertFunMessage('这都能出错了。。你是不是没登录就想注销');
                }
                alertMessage('您已经成功退出，请注意账号安全');
            },
            error: function () {
                alertFunMessage('这都能出错了。。');
            }
        })
    }
    function login() {
        window.parent.location.href = "${basePath}/base/loginPage.html";
    }


    function alertMessage(message) {
        layer.alert(message, {icon: 6});
    }

    function alertFunMessage(message) {
        layer.msg(message, {icon: 5});
    }

</script>
</body>

</html>