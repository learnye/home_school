package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.UserStudent;
import com.redrain.mapper.UserStudentMapper;
import com.redrain.service.UserStudentService;
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
 * @Description UserStudentservice实现类
 * @date 2020-03
 */

@Service
public class UserStudentServiceImpl implements UserStudentService {

    @Autowired
    private UserStudentMapper userStudentMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(UserStudent userStudent) {
        PageHelper.startPage(userStudent.getPage(), userStudent.getLimit());
        List<UserStudent> list = userStudentMapper.getList(userStudent);
        PageInfo<UserStudent> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(UserStudent userStudent) {
        int i = userStudentMapper.add(userStudent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(UserStudent userStudent) {
        int i = userStudentMapper.delete(userStudent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(UserStudent userStudent) {
        int i = userStudentMapper.update(userStudent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(UserStudent userStudent) {
        int i = userStudentMapper.updateState(userStudent);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

