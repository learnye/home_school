<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
<div style="width: 700px; padding-top: 10px;">
    <form id="form_submit" class="layui-form">
        <input type="hidden" name="id">		<div class="layui-form-item">
            <label class="layui-form-label">班级名称</label>
            <div class="layui-input-inline">
                <input type="text" name="name"
                       lay-verify="required" placeholder="请输入班级名称" value=""
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
    var modleName = '${ctxPath}/classroom';

    function initData() {
        //绑定监听表单提交事件
        bindSubmit(modleName, 'update', 'btn_form_submit', 'form_submit');
    }

</script>
</html>


