<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
    <script type="text/javascript" src="${ctxPath}/resources/js/index.js?v=21"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%--    顶部部分 --%>
    <div class="layui-header">
        <div class="layui-logo">管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="#" target="myFrame">主页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${ctxPath}/upload/headpic.jpg" class="layui-nav-img">
                    ${sessionScope.userInfo.name}
                </a>
            </li>
            <li class="layui-nav-item"><a href="logout">退了</a></li>
        </ul>
    </div>

    <%--  左侧导航部分 --%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav_layui">

            </ul>
        </div>
    </div>

    <%--  主体部分  --%>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe src="information/listPage" name="myframe" frameborder="0" style="width: 100%;height: 100%;"></iframe>
    </div>

    <%--   脚布局  --%>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 咱自己的管理系统
    </div>
</div>
<script>

</script>
</body>
</html>