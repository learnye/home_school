<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
<div style="width: 700px; padding-top: 10px;">
    <form id="form_submit" class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">登录名</label>
            <div class="layui-input-inline">
                <input type="text" name="username"
                       lay-verify="required" placeholder="请输入登录名" value=""
                       class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="text" name="password"
                       lay-verify="required" placeholder="请输入密码" value=""
                       class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="name"
                       lay-verify="required" placeholder="请输入用户昵称" value=""
                       class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="radio" name="gender" value="1" title="男" checked>
                <input type="radio" name="gender" value="2" title="女">

            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-inline">
                <input type="text" name="age"
                       lay-verify="required" placeholder="请输入年龄" value=""
                       class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-inline" style="position: relative">
                <button type="button" class="layui-btn layui-btn-normal" id="image-upload-show">
                    <i class="layui-icon layui-icon-upload"></i>上传图片
                </button>
                <div class="image-upload-show">

                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话</label>
            <div class="layui-input-inline">
                <input type="text" name="phone"
                       lay-verify="required" placeholder="请输入电话" value=""
                       class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">班级</label>
            <div class="layui-input-inline">
                <select name="classroomid" id="classroomid"
                        lay-verify="required">
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">绑定学生</label>
            <div class="layui-input-inline">
                <div class="layui-input-inline">
                    <select name="studentid" id="studentid"
                            lay-verify="required">
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item" style="display: none">
            <button type="button" lay-submit lay-filter="btn_form_submit" id="btn_form_submit"
                    class="layui-btn layui-btn-lg">

            </button>
        </div>
    </form>
</div>
</body>
<script>
    var modleName = '${ctxPath}/userParent';

    function onLayuiInit() {
        //加载下拉选框
        loadOptionList({
            url: '${ctxPath}/classroom/getList?state=1',
            elementId: 'classroomid',
        });
        //加载下拉选框
        loadOptionList({
            url: '${ctxPath}/userStudent/getList?state=1',
            elementId: 'studentid',
        });
        //绑定图片上传的内容(规则就是按你的id名字一定要和图片容器的class名字一样)
        bindUpload('image-upload-show', 'avatarUrl');
        //绑定监听表单提交事件
        bindSubmit(modleName, 'add', 'btn_form_submit', 'form_submit');
    }
</script>
</html>

