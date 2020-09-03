package com.redrain.mapper;

import com.redrain.entity.UserParent;

import java.util.List;

/**
 * @author student
 * @Description UserParentMapper
 * @date 2020-03
 */

public interface UserParentMapper {

	List<UserParent> getList(UserParent userParent);

	int add(UserParent userParent);

	int delete(UserParent userParent);

	int update(UserParent userParent);

	int updateState(UserParent userParent);

}

