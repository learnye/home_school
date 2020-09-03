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
    var modleName = '${ctxPath}/score';

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
                , {field: 'name', title: '姓名', align: 'center'}
                , {field: 'content', title: '表现', align: 'center'}
                , {field: 'subject', title: '科目', align: 'center'}
                , {field: 'studentName', title: '学生', align: 'center'}
                , {field: 'teacherName', title: '评分教师', align: 'center'}
                , {field: 'score', title: '分数', align: 'center'}
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

