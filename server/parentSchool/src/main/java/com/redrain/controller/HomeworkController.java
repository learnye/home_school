package com.redrain.controller;

import com.redrain.entity.Homework;
import com.redrain.service.HomeworkService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Homeworkcontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

	@RequestMapping("listPage")
    public String listPage() {
        return "homework/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "homework/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "homework/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Homework homework) {
        return homeworkService.getList(homework);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Homework homework, Long userId) {
        return homeworkService.add(homework);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Homework homework) {
        return homeworkService.delete(homework);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Homework homework) {
        return homeworkService.update(homework);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Homework homework) {
        return homeworkService.updateState(homework);
    }

}

