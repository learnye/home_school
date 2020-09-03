<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctxPath}/resources/css/login.css">
</head>
<body>
<form id="registerForm">
    <div class="container-login">
        <h2 class="title">管理系统管理员注册</h2>
        <div class="layui-form">
            <div class="layui-form-item">
                <input type="text" name="username" lay-verify="required" placeholder="用户名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <input type="password" name="password" id="userPass"
                       lay-verify="required" placeholder="密码" class="layui-input" autocomplete="new-password">
            </div>
            <div class="layui-form-item">
                <input type="text" name="name"
                       lay-verify="required" placeholder="姓名" class="layui-input" >
            </div>
            <div class="layui-form-item">
                <input type="text" name="sex"
                       lay-verify="required" placeholder="性别：1 男 2 女" class="layui-input" >
            </div>
            <div class="layui-form-item">
                    <input type="text" name="age"
                           lay-verify="required" placeholder="年龄"
                           class="layui-input"/>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" type="button" lay-submit lay-filter="registerSubmit">注 册
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

        //刷新元素组件
        form.on('submit(registerSubmit)', function () {
            $.ajax({
                type: 'post',
                url: 'Sregister',
                data: $('#registerForm').serialize(),
                success: function (res) {
                    if (res.code == 200) {
                        layer.msg(res.msg, {icon: 1, anim: 2, time: 2000}, function () {
                            //跳转到首页
                            window.location.href = 'login';
                        });
                    } else {
                        layer.msg(res.msg, {icon: 5, anim: 6, time: 3000});
                    }
                }
            })
        })

    });
</script>
</html>