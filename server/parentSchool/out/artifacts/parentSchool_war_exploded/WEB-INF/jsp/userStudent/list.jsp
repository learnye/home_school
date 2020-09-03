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
    var modleName = '${ctxPath}/userStudent';

    //layui加载完成后进行的操作
    function onLayuiInit() {
        //渲染表格
        renderTable({
            elem: '#id_table'
            , id: 'id_table'
            , toolbar: '#toolBar'
            , url: modleName + '/getList' //数据接口
            , cols: [[ //表头
                {type: 'checkbox', LAY_CHECKED: false}
                , {field: 'id', title: '', align: 'center'}
                , {field: 'username', title: '登录名', align: 'center'}
                , {field: 'password', title: '密码', align: 'center'}
                , {field: 'name', title: '用户昵称', align: 'center'}
                , {
                    field: 'gender', title: '性别', align: 'center', templet: function (d) {
                        return d.gender == 1 ? '男' : '女';
                    }
                }
                , {field: 'age', title: '年龄', align: 'center'}
                , {
                    field: 'avatarUrl', title: '头像', align: 'center', templet: function (d) {
                        return '<img src="${ctxPath}/' + d.avatarUrl + '"/>'
                    }
                }

                , {field: 'phone', title: '电话', align: 'center'}
                , {field: 'classroomName', title: '班级', align: 'center'}

                , {
                    field: 'createTime', title: '创建时间', align: 'center', templet: function (d) {
                        return layui.util.toDateString(d.createTime);
                    }
                }

                , {
                    field: 'createTime', title: '更新时间', align: 'center', templet: function (d) {
                        return layui.util.toDateString(d.updateTime);
                    }
                }

		, {title: '操作', align: 'center', toolbar: '#bar2'}
            ]]
        });
        //使用父类的行工具栏
        useParentToolEvent(modleName);
    }
</script>
</html>

