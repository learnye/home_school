package com.redrain.mapper;

import com.redrain.entity.Answer;

import java.util.List;

/**
 * @author student
 * @Description AnswerMapper
 * @date 2020-03
 */

public interface AnswerMapper {

    List<Answer> getList(Answer answer);

    int add(Answer answer);

    int delete(Answer answer);

    int update(Answer answer);

    int updateState(Answer answer);

}
