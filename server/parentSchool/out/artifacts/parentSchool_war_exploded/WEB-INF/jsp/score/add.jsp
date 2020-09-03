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
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" name="name"
                       lay-verify="required" placeholder="请输入姓名" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">表现</label>
            <div class="layui-input-inline">
                <input type="text" name="content"
                       lay-verify="required" placeholder="请输入表现" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">科目</label>
            <div class="layui-input-inline">
                <input type="text" name="subject"
                       lay-verify="required" placeholder="请输入科目" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">学生</label>
            <div class="layui-input-inline">
                <input type="text" name="studentid"
                       lay-verify="required" placeholder="请输入学生" value=""
                       class="layui-input"/>
            </div>
        </div>

		<div class="layui-form-item">
            <label class="layui-form-label">分数</label>
            <div class="layui-input-inline">
                <input type="text" name="score"
                       lay-verify="required" placeholder="请输入分数" value=""
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
    var modleName = '${ctxPath}/score';

    function onLayuiInit() {
         //绑定监听表单提交事件
          bindSubmit(modleName, 'add', 'btn_form_submit', 'form_submit');
    }
</script>
</html>

