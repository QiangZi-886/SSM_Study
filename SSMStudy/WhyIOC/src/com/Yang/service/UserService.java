package com.Yang.service;

/**
 * service层 逻辑处理层，用来处理逻辑语句
 *
 *      在dao层需要添加其他操作，获取其他数据库连接或者是内容时，直接使用这种方式会非常麻烦，每次都需要人为手动的更改语句，才能实现功能。
 *      所以需要优化。ioc(inversion of control)控制反转营运而生。
 */
public interface UserService {
    public void getUser();
}
