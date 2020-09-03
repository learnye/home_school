package com.redrain.controller;

import com.redrain.entity.Advice;
import com.redrain.service.AdviceService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Advicecontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

	@RequestMapping("listPage")
    public String listPage() {
        return "advice/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "advice/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "advice/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Advice advice) {
        return adviceService.getList(advice);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Advice advice, Long userId) {
        return adviceService.add(advice);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Advice advice) {
        return adviceService.delete(advice);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Advice advice) {
        return adviceService.update(advice);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Advice advice) {
        return adviceService.updateState(advice);
    }

}

