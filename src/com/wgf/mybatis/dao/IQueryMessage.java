package com.wgf.mybatis.dao;

import com.wgf.mybatis.bean.Message;

import java.util.List;

public interface IQueryMessage {
     List<Message> queryMessageList(String command ,String description);
}