package com.redrain.controller;

import com.redrain.entity.classNotice;
import com.redrain.service.classNoticeService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description classNoticecontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/classnotice")
public class classNoticeController {

    @Autowired
    private classNoticeService classnoticeService;

    @RequestMapping("listPage")
    public String listPage() {
        return "classnotice/list";
    }

    @RequestMapping("addPage")
    public String addPage() {
        return "classnotice/add";
    }

    @RequestMapping("editPage")
    public String editPage() {
        return "classnotice/edit";
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(classNotice classnotice) {
        return classnoticeService.getList(classnotice);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnData add(classNotice classnotice, Long userId) {
        return classnoticeService.add(classnotice);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(classNotice classnotice) {
        return classnoticeService.delete(classnotice);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ReturnData update(classNotice classnotice) {
        return classnoticeService.update(classnotice);
    }

    @RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(classNotice classnotice) {
        return classnoticeService.updateState(classnotice);
    }

}
