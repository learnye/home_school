package com.redrain.mapper;

import com.redrain.entity.Chat;

import java.util.List;

/**
 * @author student
 * @Description ChatMapper
 * @date 2020-03
 */

public interface ChatMapper {

	List<Chat> getList(Chat chat);

	int add(Chat chat);

	int delete(Chat chat);

	int update(Chat chat);

	int updateState(Chat chat);

}

