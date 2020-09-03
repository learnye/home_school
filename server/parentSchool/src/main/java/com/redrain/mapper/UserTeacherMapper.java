package com.redrain.mapper;

import com.redrain.entity.UserTeacher;

import java.util.List;

/**
 * @author student
 * @Description UserTeacherMapper
 * @date 2020-03
 */

public interface UserTeacherMapper {

	List<UserTeacher> getList(UserTeacher userTeacher);

	int add(UserTeacher userTeacher);

	int delete(UserTeacher userTeacher);

	int update(UserTeacher userTeacher);

	int updateState(UserTeacher userTeacher);

}

