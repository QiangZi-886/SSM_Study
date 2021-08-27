package com.yang.repository;

import com.yang.entity.Account;

import java.util.List;

public interface AccountRepository {
    //添加操作
    public int save(Account account);
    //更改
    public int update(Account account);
    //删除
    public int deleteById(long id);
    //查找值返回整个
    public List<Account> findAll();
    //单个查找
    public Account findById(long id);
    //通过多个条件查询
    public Account findByNameAndAge(String name,int age);
    //统计记录总数(基本数据类型、还有包装类，用法和写法是一致的，只不过将返回值类型改为Integer)
    public int count();
    //通过id查询name
    public String findNameById(long id);
    //Mybatis动态SQL语句(必须按照account对象全部属性都满足，才能够进行查询)
    public Account findByAccount(Account account);
    //根据多个id，一次查询多个对象
    public List<Account> findByIds(Account account);

}
