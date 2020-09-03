package com.redrain.service;

import com.redrain.entity.Answer;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description AnswerService接口
 * @date 2020-03
 */

public interface AnswerService {

    ReturnDataForLayui getList(Answer answer);

    ReturnData add(Answer answer);

    ReturnData delete(Answer answer);

    ReturnData update(Answer answer);

    ReturnData updateState(Answer answer);

}
