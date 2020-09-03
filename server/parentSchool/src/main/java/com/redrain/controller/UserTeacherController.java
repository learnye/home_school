package com.redrain.controller;

import com.redrain.entity.UserTeacher;
import com.redrain.service.UserTeacherService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description UserTeachercontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/userTeacher")
public class UserTeacherController {

    @Autowired
    private UserTeacherService userTeacherService;

	@RequestMapping("listPage")
    public String listPage() {
        return "userTeacher/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "userTeacher/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "userTeacher/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(UserTeacher userTeacher) {
        return userTeacherService.getList(userTeacher);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(UserTeacher userTeacher, Long userId) {
        return userTeacherService.add(userTeacher);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(UserTeacher userTeacher) {
        return userTeacherService.delete(userTeacher);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(UserTeacher userTeacher) {
        return userTeacherService.update(userTeacher);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(UserTeacher userTeacher) {
        return userTeacherService.updateState(userTeacher);
    }

}

