package com.redrain.service;

import com.redrain.entity.Homework;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Homeworkservice接口
 * @date 2020-03
 */

public interface HomeworkService {

	ReturnDataForLayui getList(Homework homework);

	ReturnData add(Homework homework);

	ReturnData delete(Homework homework);

	ReturnData update(Homework homework);

	ReturnData updateState(Homework homework);

}

