package com.yang.test;

import com.yang.entity.Account;
import com.yang.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/*
* Mybatis动态SQL测试类
*
*       可以简化代码开发，减少开发者工作量，程序可以自动根据业务参数来决定SQL的组成
*           比如：针对于findByAccount()方法，我如果想使用该方法，那么就必须
* */
public class Test6 {
    public static void main(String[] args) {
        InputStream inputStream = Test6.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Account account = new Account();
        List<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
//        ids.add(3l);
//        ids.add(16l);
        account.setIds(ids);
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        System.out.println(accountRepository.findByIds(account));

        sqlSession.close();
    }
}
