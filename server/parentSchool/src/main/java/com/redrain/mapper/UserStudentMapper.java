package com.redrain.mapper;

import com.redrain.entity.UserStudent;

import java.util.List;

/**
 * @author student
 * @Description UserStudentMapper
 * @date 2020-03
 */

public interface UserStudentMapper {

	List<UserStudent> getList(UserStudent userStudent);

	int add(UserStudent userStudent);

	int delete(UserStudent userStudent);

	int update(UserStudent userStudent);

	int updateState(UserStudent userStudent);

}

