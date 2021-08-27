package com.Yang.dao.impl;

import com.Yang.dao.UserDao;

public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("从MySQL获取数据。。。");
    }
}
