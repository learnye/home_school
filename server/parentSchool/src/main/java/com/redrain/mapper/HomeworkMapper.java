package com.redrain.mapper;

import com.redrain.entity.Homework;

import java.util.List;

/**
 * @author student
 * @Description HomeworkMapper
 * @date 2020-03
 */

public interface HomeworkMapper {

	List<Homework> getList(Homework homework);

	int add(Homework homework);

	int delete(Homework homework);

	int update(Homework homework);

	int updateState(Homework homework);

}

