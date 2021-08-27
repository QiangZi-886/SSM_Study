package com.Yang.dao.impl;

import com.Yang.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("从Oracle中获取数据。。。");
    }
}
