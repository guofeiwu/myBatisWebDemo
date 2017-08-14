package com.wgf.mybatis.impl;

import com.wgf.mybatis.bean.Message;
import com.wgf.mybatis.dao.IQueryMessage;
import com.wgf.mybatis.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class QueryMessageImpl implements IQueryMessage{

    @Override
    public List<Message> queryMessageList(String command, String description) {
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = null;
        SqlSession sqlSession = null;
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);


        System.out.println("command:"+command);
        try {
            sqlSession = dbAccess.getSqlSession();
            messageList = sqlSession.selectList("Message.queryMessageList",message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
        return messageList;
    }
}
