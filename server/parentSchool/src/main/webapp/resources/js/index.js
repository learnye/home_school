var menus = [
    {
        name: '意见反馈',
        menus: [
            {
                name: '意见反馈',
                url: 'advice/listPage'
            }
        ]
    },
    {
        name: '班级管理',
        menus: [
            {
                name: '班级管理',
                url: 'classroom/listPage'
            }
        ]
    },
    {
        name: '作业管理',
        menus: [
            {
                name: '作业管理',
                url: 'homework/listPage'
            }
        ]
    },
    {
        name: '分数管理',
        menus: [
            {
                name: '分数管理',
                url: 'score/listPage'
            }
        ]
    },
    {
        name: '通知管理',
        menus: [
            {
                name: '通知管理',
                url: 'notice/listPage'
            }
        ]
    },
    {
        name: '家长管理',
        menus: [
            {
                name: '家长管理',
                url: 'userParent/listPage'
            }
        ]
    },
    {
        name: '学生管理',
        menus: [
            {
                name: '学生管理',
                url: 'userStudent/listPage'
            }
        ]
    },
    {
        name: '教师管理',
        menus: [
            {
                name: '教师管理',
                url: 'userTeacher/listPage'
            }
        ]
    },
]
//JavaScript代码区域
layui.use('element', function () {
    var element = layui.element;
    initMenu();
    element.render('nav_layui');
});

function initMenu() {
    $('#nav_layui').empty();
    var leftMenu = '';
    $.each(menus, function (index, parent) {
        leftMenu += '<li class="layui-nav-item">';
        leftMenu += '<a class="" href="javascript:;">' + parent.name + '</a>';
        leftMenu += '<dl class="layui-nav-child">';
        $.each(parent.menus, function (childIndex, child) {
            var childEl = '<dd>' +
                '<a href="' + child.url + '" target="myframe">' + child.name + '</a>' +
                '</dd>';
            leftMenu += childEl;
        });
        leftMenu += '</dl>';
        leftMenu += '</li>';
    });
    $('#nav_layui').html(leftMenu);
}

