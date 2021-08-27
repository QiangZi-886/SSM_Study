package com.Yang.test;

import com.Yang.dao.impl.UserDaoMysqlImpl;
import com.Yang.dao.impl.UserDaoOracleImpl;
import com.Yang.service.UserService;
import com.Yang.service.impl.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
/*        UserService userService = new UserServiceImpl();
        userService.getUser();*/
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoMysqlImpl userDaoMysql = new UserDaoMysqlImpl();
        userService.setUserDao(userDaoMysql);
        userService.getUser();
        System.out.println("-------------");
        UserDaoOracleImpl userDaoOracle = new UserDaoOracleImpl();
        userService.setUserDao(userDaoOracle);
        userService.getUser();
    }
}
