package com.redrain.service;

import com.redrain.entity.Advice;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Adviceservice接口
 * @date 2020-03
 */

public interface AdviceService {

	ReturnDataForLayui getList(Advice advice);

	ReturnData add(Advice advice);

	ReturnData delete(Advice advice);

	ReturnData update(Advice advice);

	ReturnData updateState(Advice advice);

}

