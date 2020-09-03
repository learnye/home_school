package com.redrain.service;

import com.redrain.entity.Notice;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description Noticeservice接口
 * @date 2020-03
 */

public interface NoticeService {

	ReturnDataForLayui getList(Notice notice);

	ReturnData add(Notice notice);

	ReturnData delete(Notice notice);

	ReturnData update(Notice notice);

	ReturnData updateState(Notice notice);

}

