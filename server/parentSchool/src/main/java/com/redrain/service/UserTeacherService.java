package com.redrain.service;

import com.redrain.entity.UserTeacher;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description UserTeacherservice接口
 * @date 2020-03
 */

public interface UserTeacherService {

	ReturnDataForLayui getList(UserTeacher userTeacher);

	ReturnData add(UserTeacher userTeacher);

	ReturnData delete(UserTeacher userTeacher);

	ReturnData update(UserTeacher userTeacher);

	ReturnData updateState(UserTeacher userTeacher);

}

