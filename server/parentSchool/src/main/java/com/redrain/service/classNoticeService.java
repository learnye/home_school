package com.redrain.service;

import com.redrain.entity.classNotice;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;

/**
 * @author student
 * @Description classNoticeservice接口
 * @date 2020-03
 */

public interface classNoticeService {

    ReturnDataForLayui getList(classNotice classnotice);

    ReturnData add(classNotice classnotice);

    ReturnData delete(classNotice classnotice);

    ReturnData update(classNotice classnotice);

    ReturnData updateState(classNotice classnotice);

}
