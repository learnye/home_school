package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.classNotice;
import com.redrain.mapper.classNoticeMapper;
import com.redrain.service.classNoticeService;
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
 * @Description classNoticeservice实现类
 * @date 2020-03
 */

@Service
public class classNoticeServiceImpl implements classNoticeService {

    @Autowired
    private classNoticeMapper classnoticeMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(classNotice classnotice) {
        PageHelper.startPage(classnotice.getPage(), classnotice.getLimit());
        List<classNotice> list = classnoticeMapper.getList(classnotice);
        PageInfo<classNotice> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(classNotice classnotice) {
        int i = classnoticeMapper.add(classnotice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(classNotice classnotice) {
        int i = classnoticeMapper.delete(classnotice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(classNotice classnotice) {
        int i = classnoticeMapper.update(classnotice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(classNotice classnotice) {
        int i = classnoticeMapper.updateState(classnotice);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}
