package com.yang.test;

import com.yang.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//使用原生接口
import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        //加载mybatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //得到sqlSession对象之后，需要来通过位置与AccountMapper.xml中配置好的save方法连接
        String statement = "com.yang.mapper.AccountMapper.save";
        Account account = new Account(1l,"杨杨杨","123iloveyou",21);
        sqlSession.insert(statement,account);
        //这里需要commit提交一下,在对数据库的操作中，如果对数据库中的数据有添加，更改，删除的操作的话，都必须进行commit提交，不然数据库不会改变
        sqlSession.commit();
        sqlSession.close();
    }
}
