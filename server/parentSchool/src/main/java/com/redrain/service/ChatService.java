package com.redrain.service;

import com.redrain.entity.Chat;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Chatservice接口
 * @date 2020-03
 */

public interface ChatService {

	ReturnDataForLayui getList(Chat chat);

	ReturnData add(Chat chat);

	ReturnData delete(Chat chat);

	ReturnData update(Chat chat);

	ReturnData updateState(Chat chat);

}

