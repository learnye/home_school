package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.Answer;
import com.redrain.mapper.AnswerMapper;
import com.redrain.service.AnswerService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import com.redrain.util.UpdateOrInsertResultDeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author student
 * @Description AnswerService实现类
 * @date 2020-03
 */

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(Answer answer) {
        PageHelper.startPage(answer.getPage(), answer.getLimit());
        List<Answer> list = answerMapper.getList(answer);
        PageInfo<Answer> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(Answer answer) {
        int i = answerMapper.add(answer);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Answer answer) {
        int i = answerMapper.delete(answer);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(Answer answer) {
        int i = answerMapper.update(answer);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Answer answer) {
        int i = answerMapper.updateState(answer);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}
