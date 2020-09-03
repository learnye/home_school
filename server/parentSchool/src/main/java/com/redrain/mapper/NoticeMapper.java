package com.redrain.mapper;

import com.redrain.entity.Notice;

import java.util.List;

/**
 * @author student
 * @Description NoticeMapper
 * @date 2020-03
 */

public interface NoticeMapper {

	List<Notice> getList(Notice notice);

	int add(Notice notice);

	int delete(Notice notice);

	int update(Notice notice);

	int updateState(Notice notice);

}

