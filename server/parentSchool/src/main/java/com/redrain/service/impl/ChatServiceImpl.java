package com.redrain.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redrain.entity.Chat;
import com.redrain.mapper.ChatMapper;
import com.redrain.service.ChatService;
import com.redrain.util.ReturnData;
import com.redrain.util.ReturnDataForLayui;
import com.redrain.util.UpdateOrInsertResultDeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author student
 * @Description Chatservice实现类
 * @date 2020-03
 */

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public ReturnDataForLayui getList(Chat chat) {
        PageHelper.startPage(chat.getPage(), chat.getLimit());
        List<Chat> list = chatMapper.getList(chat);
        PageInfo<Chat> info = new PageInfo<>(list);
        return ReturnDataForLayui.success(list, info.getTotal());
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData add(Chat chat) {
        int i = chatMapper.add(chat);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData delete(Chat chat) {
        int i = chatMapper.delete(chat);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData update(Chat chat) {
        int i = chatMapper.update(chat);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public ReturnData updateState(Chat chat) {
        int i = chatMapper.updateState(chat);
        return UpdateOrInsertResultDeal.dealWith(i);
    }

}

