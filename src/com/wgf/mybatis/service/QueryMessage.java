package com.wgf.mybatis.service;

import com.wgf.mybatis.bean.Message;
import com.wgf.mybatis.dao.IQueryMessage;
import com.wgf.mybatis.impl.QueryMessageImpl;

import java.util.List;

public class QueryMessage {

    public List<Message> queryMessageList(String command, String description) {
        IQueryMessage iQueryMessage = new QueryMessageImpl();
        return iQueryMessage.queryMessageList(command,description);
    }
}
