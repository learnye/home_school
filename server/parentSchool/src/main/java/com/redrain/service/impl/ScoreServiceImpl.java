package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.Score;
import com.redrain.mapper.ScoreMapper;
import com.redrain.service.ScoreService;
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
 * @Description Scoreservice实现类
 * @date 2020-03
 */

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(Score score) {
        PageHelper.startPage(score.getPage(), score.getLimit());
        List<Score> list = scoreMapper.getList(score);
        PageInfo<Score> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(Score score) {
        int i = scoreMapper.add(score);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Score score) {
        int i = scoreMapper.delete(score);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(Score score) {
        int i = scoreMapper.update(score);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Score score) {
        int i = scoreMapper.updateState(score);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

