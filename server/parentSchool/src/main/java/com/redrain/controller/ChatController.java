package com.redrain.controller;

import com.redrain.entity.Chat;
import com.redrain.service.ChatService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Chatcontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

	@RequestMapping("listPage")
    public String listPage() {
        return "chat/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "chat/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "chat/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Chat chat) {
        return chatService.getList(chat);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Chat chat, Long userId) {
        return chatService.add(chat);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Chat chat) {
        return chatService.delete(chat);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Chat chat) {
        return chatService.update(chat);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Chat chat) {
        return chatService.updateState(chat);
    }

}

