package com.wgf.mybatis.servlet;

import com.wgf.mybatis.bean.Message;
import com.wgf.mybatis.service.QueryMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QueryMessage queryMessage = new QueryMessage();
        req.setCharacterEncoding("utf-8");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        List<Message> messageList = queryMessage.queryMessageList(command,description);
        System.out.println("messageListSize:"+messageList.size());
        req.setAttribute("messageList",messageList);

        req.setAttribute("command",command);
        req.setAttribute("description",description);

        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req,resp);
    }
}
