package com.redrain.service;

import com.redrain.entity.UserStudent;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description UserStudentservice接口
 * @date 2020-03
 */

public interface UserStudentService {

	ReturnDataForLayui getList(UserStudent userStudent);

	ReturnData add(UserStudent userStudent);

	ReturnData delete(UserStudent userStudent);

	ReturnData update(UserStudent userStudent);

	ReturnData updateState(UserStudent userStudent);

}

