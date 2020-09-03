package com.redrain.mapper;

import com.redrain.entity.Score;

import java.util.List;

/**
 * @author student
 * @Description ScoreMapper
 * @date 2020-03
 */

public interface ScoreMapper {

	List<Score> getList(Score score);

	int add(Score score);

	int delete(Score score);

	int update(Score score);

	int updateState(Score score);

}

