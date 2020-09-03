package com.redrain.mapper;

import com.redrain.entity.Classroom;

import java.util.List;

/**
 * @author student
 * @Description ClassroomMapper
 * @date 2020-03
 */

public interface ClassroomMapper {

	List<Classroom> getList(Classroom classroom);

	int add(Classroom classroom);

	int delete(Classroom classroom);

	int update(Classroom classroom);

	int updateState(Classroom classroom);

}

