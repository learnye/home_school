package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.Advice;
import com.redrain.mapper.AdviceMapper;
import com.redrain.service.AdviceService;
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
 * @Description Adviceservice实现类
 * @date 2020-03
 */

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceMapper adviceMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(Advice advice) {
        PageHelper.startPage(advice.getPage(), advice.getLimit());
        List<Advice> list = adviceMapper.getList(advice);
        PageInfo<Advice> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(Advice advice) {
        int i = adviceMapper.add(advice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Advice advice) {
        int i = adviceMapper.delete(advice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(Advice advice) {
        int i = adviceMapper.update(advice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Advice advice) {
        int i = adviceMapper.updateState(advice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

