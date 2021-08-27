package com.yang.test;

import com.yang.entity.Account;
import com.yang.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        InputStream inputStream = Test2.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        //直接调用对象.方法对数据库操作。实现对数据库的操作类似面向对象的操作。
        //增加数据
//        accountRepository.save(new Account(2l,"下大雨","123123",18));
//        accountRepository.save(new Account(3l,"打雷了","886",20));
        //更改数据
//        Account account1 = new Account(2l,"下大雨","5201314",18);
//        accountRepository.update(account1);
        //删除数据
//        accountRepository.deleteById(14);
//        accountRepository.deleteById(15);
//        accountRepository.save(new Account(4l,"test","000",900));
//        sqlSession.commit();
        //查询全部数据
/*        List<Account> list = accountRepository.findAll();
        for (Account account:list){
            System.out.println(account);
        }*/
        //查询单个数据
//        Account account = accountRepository.findById(3);
//        System.out.println(account);
//        System.out.println(accountRepository.findByNameAndAge("下大雨",18));
//        System.out.println(accountRepository.count());
        System.out.println(accountRepository.findNameById(1));
        sqlSession.close();
    }
}
