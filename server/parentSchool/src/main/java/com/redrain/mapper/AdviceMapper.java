package com.redrain.mapper;

import com.redrain.entity.Advice;

import java.util.List;

/**
 * @author student
 * @Description AdviceMapper
 * @date 2020-03
 */

public interface AdviceMapper {

	List<Advice> getList(Advice advice);

	int add(Advice advice);

	int delete(Advice advice);

	int update(Advice advice);

	int updateState(Advice advice);

}

