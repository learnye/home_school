package com.redrain.service;

import com.redrain.entity.Score;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Scoreservice接口
 * @date 2020-03
 */

public interface ScoreService {

	ReturnDataForLayui getList(Score score);

	ReturnData add(Score score);

	ReturnData delete(Score score);

	ReturnData update(Score score);

	ReturnData updateState(Score score);

}

