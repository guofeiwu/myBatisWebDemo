package com.wgf.mybatis.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBAccess {

    public SqlSession getSqlSession() throws IOException {

        //通过读取配置获取数据库相关的信息
        Reader reader = Resources.getResourceAsReader("com/wgf/mybatis/config/Configuration.xml");
        //通过配置信息构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过sqlSessionFactory获取Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


    public static void main(String [] args){
        DBAccess dbAccess = new DBAccess();
        try {
            dbAccess.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}