package com.redrain.controller;

import com.redrain.entity.UserStudent;
import com.redrain.service.UserStudentService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description UserStudentcontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/userStudent")
public class UserStudentController {

    @Autowired
    private UserStudentService userStudentService;

	@RequestMapping("listPage")
    public String listPage() {
        return "userStudent/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "userStudent/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "userStudent/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(UserStudent userStudent) {
        return userStudentService.getList(userStudent);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(UserStudent userStudent, Long userId) {
        return userStudentService.add(userStudent);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(UserStudent userStudent) {
        return userStudentService.delete(userStudent);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(UserStudent userStudent) {
        return userStudentService.update(userStudent);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(UserStudent userStudent) {
        return userStudentService.updateState(userStudent);
    }

}

