package com.redrain.mapper;

import com.redrain.entity.classNotice;

import java.util.List;

/**
 * @author student
 * @Description classNoticeMapper
 * @date 2020-03
 */

public interface classNoticeMapper {

    List<classNotice> getList(classNotice classnotice);

    int add(classNotice classnotice);

    int delete(classNotice classnotice);

    int update(classNotice classnotice);

    int updateState(classNotice classnotice);

}
