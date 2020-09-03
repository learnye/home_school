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
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline">
                <input type="text" name="name"
                       lay-verify="required" placeholder="请输入标题" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-inline">
                <input type="text" name="content"
                       lay-verify="required" placeholder="请输入内容" value=""
                       class="layui-input"/>
            </div>
        </div>

			<div class="layui-form-item">
            <label class="layui-form-label">图片</label>
            <div class="layui-input-inline" style="position: relative">
                <button type="button" class="layui-btn layui-btn-normal" id="image-upload-show">
                    <i class="layui-icon layui-icon-upload"></i>上传图片
                </button>
                <div class="image-upload-show">

                </div>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">所属班级</label>
            <div class="layui-input-inline">
                <input type="text" name="classroomid"
                       lay-verify="required" placeholder="请输入所属班级" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">所属教师</label>
            <div class="layui-input-inline">
                <input type="text" name="teacherid"
                       lay-verify="required" placeholder="请输入所属教师" value=""
                       class="layui-input"/>
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
    var modleName = '${ctxPath}/homework';

    function onLayuiInit() {
        //绑定图片上传的内容(规则就是按你的id名字一定要和图片容器的class名字一样)
        bindUpload('image-upload-show', 'coverImg');
         //绑定监听表单提交事件
          bindSubmit(modleName, 'add', 'btn_form_submit', 'form_submit');
    }
</script>
</html>

