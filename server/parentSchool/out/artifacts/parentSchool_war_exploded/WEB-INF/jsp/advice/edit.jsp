<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
<div style="width: 700px; padding-top: 10px;">
    <form id="form_submit" class="layui-form">
        <input type="hidden" name="name">
        <input type="hidden" name="content">
        <input type="hidden" name="id">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-inline">
                <input type="text" name="name"
                       lay-verify="required" placeholder="请输入标题" value="" disabled="disabled"
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">内容</label>
            <div class="layui-input-inline">
                <input type="text" name="content"
                       lay-verify="required" placeholder="请输入内容" value="" disabled="disabled"
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">回复</label>
            <div class="layui-input-inline">
                <input type="text" name="reply"
                       lay-verify="required" placeholder="请输入回复" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item" style="display: none">
            <button type="button" lay-submit lay-filter="btn_form_submit"
                    id="btn_form_submit"
                    class="layui-btn layui-btn-lg">

            </button>
        </div>
    </form>
</div>
</body>
<script>
    var modleName = '${ctxPath}/advice';

    function initData() {
        //绑定监听表单提交事件
        bindSubmit(modleName, 'update', 'btn_form_submit', 'form_submit');
    }

</script>
</html>


