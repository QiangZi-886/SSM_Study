package com.Yang.service.impl;

import com.Yang.dao.UserDao;
import com.Yang.dao.impl.UserDaoImpl;
import com.Yang.dao.impl.UserDaoMysqlImpl;
import com.Yang.service.UserService;


public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public void getUser() {
        userDao.getUser();
    }
}
