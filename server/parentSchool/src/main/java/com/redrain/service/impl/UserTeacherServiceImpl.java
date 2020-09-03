package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.UserTeacher;
import com.redrain.mapper.UserTeacherMapper;
import com.redrain.service.UserTeacherService;
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
 * @Description UserTeacherservice实现类
 * @date 2020-03
 */

@Service
public class UserTeacherServiceImpl implements UserTeacherService {

    @Autowired
    private UserTeacherMapper userTeacherMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(UserTeacher userTeacher) {
        PageHelper.startPage(userTeacher.getPage(), userTeacher.getLimit());
        List<UserTeacher> list = userTeacherMapper.getList(userTeacher);
        PageInfo<UserTeacher> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(UserTeacher userTeacher) {
        int i = userTeacherMapper.add(userTeacher);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(UserTeacher userTeacher) {
        int i = userTeacherMapper.delete(userTeacher);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(UserTeacher userTeacher) {
        int i = userTeacherMapper.update(userTeacher);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(UserTeacher userTeacher) {
        int i = userTeacherMapper.updateState(userTeacher);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

