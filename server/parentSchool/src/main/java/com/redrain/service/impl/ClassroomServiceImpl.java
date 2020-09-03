package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.Classroom;
import com.redrain.mapper.ClassroomMapper;
import com.redrain.service.ClassroomService;
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
 * @Description Classroomservice实现类
 * @date 2020-03
 */

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(Classroom classroom) {
        PageHelper.startPage(classroom.getPage(), classroom.getLimit());
        List<Classroom> list = classroomMapper.getList(classroom);
        PageInfo<Classroom> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(Classroom classroom) {
        int i = classroomMapper.add(classroom);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Classroom classroom) {
        int i = classroomMapper.delete(classroom);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(Classroom classroom) {
        int i = classroomMapper.update(classroom);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Classroom classroom) {
        int i = classroomMapper.updateState(classroom);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

