package com.redrain.controller;

import com.redrain.entity.Answer;
import com.redrain.service.AnswerService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Answercontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("listPage")
    public String listPage() {
        return "answer/list";
    }

    @RequestMapping("addPage")
    public String addPage() {
        return "answer/add";
    }

    @RequestMapping("editPage")
    public String editPage() {
        return "answer/edit";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Answer answer) {
        return answerService.getList(answer);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Answer answer, Long userId) {
        return answerService.add(answer);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Answer answer) {
        return answerService.delete(answer);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Answer answer) {
        return answerService.update(answer);
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Answer answer) {
        return answerService.updateState(answer);
    }

}
