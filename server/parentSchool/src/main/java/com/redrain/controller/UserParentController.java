package com.redrain.controller;

import com.redrain.entity.UserParent;
import com.redrain.service.UserParentService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description UserParentcontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/userParent")
public class UserParentController {

    @Autowired
    private UserParentService userParentService;

	@RequestMapping("listPage")
    public String listPage() {
        return "userParent/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "userParent/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "userParent/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(UserParent userParent) {
        return userParentService.getList(userParent);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(UserParent userParent, Long userId) {
        return userParentService.add(userParent);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(UserParent userParent) {
        return userParentService.delete(userParent);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(UserParent userParent) {
        return userParentService.update(userParent);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(UserParent userParent) {
        return userParentService.updateState(userParent);
    }

}

