package com.yang.test;

import com.yang.entity.Account;
import com.yang.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
/*
* Mybatis动态SQL测试类
*
*       可以简化代码开发，减少开发者工作量，程序可以自动根据业务参数来决定SQL的组成
*           比如：针对于findByAccount()方法，我如果想使用该方法，那么就必须传入一个完整的account对象，现在
*                如果说自己想只根据一部分信息（只有id、或username等等）那么就需要手动去更改很多条sql语句，但mybatis可以
*                动态生成SQL语句。简化。
* */
public class Test5 {
    public static void main(String[] args) {
        InputStream inputStream = Test5.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

/*        Account account = new Account();
//        account.setId(1l);
        account.setUsername("杨杨杨");
        account.setPassword("123iloveyou");
//        account.setAge(21);
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        System.out.println(accountRepository.findByAccount(account));*/
        AccountRepository accountRepository1 = sqlSession.getMapper(AccountRepository.class);
        Account account1 = new Account();
        account1.setId(2l);
        account1.setUsername("我很好");
        System.out.println(accountRepository1.update(account1));
        sqlSession.commit();
        sqlSession.close();
    }
}
