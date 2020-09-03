package com.redrain.service;

import com.redrain.entity.UserParent;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description UserParentservice接口
 * @date 2020-03
 */

public interface UserParentService {

	ReturnDataForLayui getList(UserParent userParent);

	ReturnData add(UserParent userParent);

	ReturnData delete(UserParent userParent);

	ReturnData update(UserParent userParent);

	ReturnData updateState(UserParent userParent);

}

