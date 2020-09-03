<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctxPath}/resources/css/login.css">
</head>
<body>
<form id="loginForm">
    <div class="container-login">
        <h2 class="title">管理系统管理员登陆</h2>
        <div class="layui-form">
            <div class="layui-form-item">
                <label class="layui-icon layui-icon-username"></label>
                <input type="text" name="username" lay-verify="required" placeholder="用户名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layui-icon layui-icon-password"></label>
                <input type="password" name="password" id="userPass"
                       lay-verify="required" placeholder="密码" class="layui-input" autocomplete="new-password">
            </div>
            <div class="layui-form-item">
                <input type="checkbox" id="remember" name="remember" lay-skin="primary"
                       title="记住密码">
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" type="button" lay-submit lay-filter="loginSubmit">登 入
                </button>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" type="button" name="registerSubmit" onclick="window.location.href='register'">注 册
                </button>
            </div>
        </div>
    </div>
</form>

</body>
<script>
    layui.use(['form', 'layer'], function () {
        var form = layui.form;
        var layer = layui.layer;

        //回显是否记住密码
        var adminIsRememberPwd = getCookie('adminIsRememberPwd');
        var adminPwd = getCookie('adminPwd');
        $('#userPass').val(adminPwd);
        if (adminIsRememberPwd == '1') {
            // $('#remember').prop('checked', true);
            $('#remember').attr('checked', true);
        } else {
            $('#remember').prop('checked', false);
        }
        //刷新元素组件
        form.render('checkbox');
        form.on('submit(loginSubmit)', function () {
            $.ajax({
                type: 'post',
                url: 'requestLogin',
                data: $('#loginForm').serialize(),
                success: function (res) {
                    if (res.code == 200) {
                        //判断是否选中记住密码
                        var isRemenber = $('#remember').is(':checked');
                        if (isRemenber) {
                            //将密码写进cookie里面
                            setCookie('adminPwd', $('#userPass').val());
                            setCookie('adminIsRememberPwd', '1')
                        } else {
                            setCookie('adminPwd', '');
                            setCookie('adminIsRememberPwd', '0')
                        }
                        layer.msg(res.msg, {icon: 1, anim: 2, time: 2000}, function () {
                            //跳转到首页
                            window.location.href = 'index';
                        });
                    } else {
                        layer.msg(res.msg, {icon: 5, anim: 6, time: 3000});
                    }
                }
            })
        })

    });
    function setCookie(name, value) {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();// 格林威治时间格式
    }

    function getCookie(name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }
</script>
</html>