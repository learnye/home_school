package com.redrain.service;

import com.redrain.entity.Classroom;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Classroomservice接口
 * @date 2020-03
 */

public interface ClassroomService {

	ReturnDataForLayui getList(Classroom classroom);

	ReturnData add(Classroom classroom);

	ReturnData delete(Classroom classroom);

	ReturnData update(Classroom classroom);

	ReturnData updateState(Classroom classroom);

}

