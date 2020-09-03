package com.redrain.controller;

import com.redrain.entity.Classroom;
import com.redrain.service.ClassroomService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Classroomcontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

	@RequestMapping("listPage")
    public String listPage() {
        return "classroom/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "classroom/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "classroom/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Classroom classroom) {
        return classroomService.getList(classroom);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Classroom classroom, Long userId) {
        return classroomService.add(classroom);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Classroom classroom) {
        return classroomService.delete(classroom);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Classroom classroom) {
        return classroomService.update(classroom);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Classroom classroom) {
        return classroomService.updateState(classroom);
    }

}

