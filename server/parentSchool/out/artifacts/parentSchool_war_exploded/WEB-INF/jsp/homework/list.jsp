<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/resources/commons/basejs.jsp" %>
</head>
<body>
<table id="id_table" lay-filter="lineToolFilter"></table>
</body>
<script>
    var modleName = '${ctxPath}/homework';

    //layui加载完成后进行的操作
    function onLayuiInit() {
        //渲染表格
        renderTable({
            elem: '#id_table'
            , id: 'id_table'
            , url: modleName + '/getList' //数据接口
            , cols: [[ //表头
                {type: 'checkbox', LAY_CHECKED: false}
                , {field: 'id', title: '', align: 'center'}
                , {field: 'name', title: '标题', align: 'center'}
                , {field: 'content', title: '内容', align: 'center'}
                , {
                    field: 'coverImg', title: '图片', align: 'center', templet: function (d) {
                        return '<img src="${ctxPath}/' + d.coverImg + '"/>'
                    }
                }

                , {field: 'classroomName', title: '所属班级', align: 'center'}
                , {field: 'teacherName', title: '所属教师', align: 'center'}
                , {
                    field: 'createTime', title: '创建时间', align: 'center', templet: function (d) {
                        return layui.util.toDateString(d.createTime);
                    }
                }
            ]]
        });
        //使用父类的行工具栏
        useParentToolEvent(modleName);
    }
</script>
</html>

