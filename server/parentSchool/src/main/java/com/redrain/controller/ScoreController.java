package com.redrain.controller;

import com.redrain.entity.Score;
import com.redrain.service.ScoreService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author student
 * @Description Scorecontroller实现类
 * @date 2020-03
 */

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

	@RequestMapping("listPage")
    public String listPage() {
        return "score/list";
    }

	@RequestMapping("addPage")
    public String addPage() {
        return "score/add";
    }

	@RequestMapping("editPage")
    public String editPage() {
        return "score/edit";
    }

	@RequestMapping("/getList")
    @ResponseBody
    public ReturnDataForLayui getList(Score score) {
        return scoreService.getList(score);
    }

	@RequestMapping("/add")
    @ResponseBody
    public ReturnData add(Score score, Long userId) {
        return scoreService.add(score);
    }

	@RequestMapping("/delete")
    @ResponseBody
    public ReturnData delete(Score score) {
        return scoreService.delete(score);
    }

	@RequestMapping("/update")
    @ResponseBody
    public ReturnData update(Score score) {
        return scoreService.update(score);
    }

	@RequestMapping("/updateState")
    @ResponseBody
    public ReturnData updateState(Score score) {
        return scoreService.updateState(score);
    }

}

