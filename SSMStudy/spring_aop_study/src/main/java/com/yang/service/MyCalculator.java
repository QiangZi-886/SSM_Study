package com.yang.service;

import com.yang.Util.LogUtil;

/**
 * 在实现这些方法的同时，如果想打印出日志记录，（例如：执行这个方法传入的参数有什么、结果有什么、等等）可以就写在当前方法中，但是代码重复量极大且臃肿
 * 在没有学习动态代理之前，能恰当做到的方式就是封装一个工具类，封装一些方法用来输出日志记录。
 *
 */
public class MyCalculator implements Calculator {

    public int add(int i, int j) {
//        LogUtil.start(i,j);
        int result = i+j;
//        LogUtil.stop(result);
        return result;
    }

    public int sub(int i, int j) {
//        LogUtil.start(i,j);
        int result = i-j;
//        LogUtil.stop(result);
        return result;
    }

    public int mul(int i, int j) {
//        LogUtil.start(i,j);
        int result = i*j;
//        LogUtil.stop(result);
        return result;
    }

    public int div(int i, int j) {
//        LogUtil.start(i,j);
        int result = i/j;
//        LogUtil.stop(result);
        return result;
    }
}
