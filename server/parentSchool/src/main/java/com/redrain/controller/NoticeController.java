package com.redrain.controller;

import com.redrain.entity.Notice;
import com.redrain.service.NoticeService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Noticecontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

	@RequestMapping("listPage")
    public String listPage() {
        return "notice/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "notice/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "notice/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Notice notice) {
        return noticeService.getList(notice);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Notice notice, Long userId) {
        return noticeService.add(notice);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Notice notice) {
        return noticeService.delete(notice);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Notice notice) {
        return noticeService.update(notice);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Notice notice) {
        return noticeService.updateState(notice);
    }

}

