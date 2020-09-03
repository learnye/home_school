package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.UserParent;
import com.redrain.mapper.UserParentMapper;
import com.redrain.service.UserParentService;
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
 * @Description UserParentservice实现类
 * @date 2020-03
 */

@Service
public class UserParentServiceImpl implements UserParentService {

    @Autowired
    private UserParentMapper userParentMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(UserParent userParent) {
        PageHelper.startPage(userParent.getPage(), userParent.getLimit());
        List<UserParent> list = userParentMapper.getList(userParent);
        PageInfo<UserParent> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(UserParent userParent) {
        int i = userParentMapper.add(userParent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(UserParent userParent) {
        int i = userParentMapper.delete(userParent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(UserParent userParent) {
        int i = userParentMapper.update(userParent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(UserParent userParent) {
        int i = userParentMapper.updateState(userParent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

