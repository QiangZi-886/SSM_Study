package com.yang.utils.Impl;

import com.yang.utils.Calculator;
import org.springframework.stereotype.Component;

/**
 * 下列是一个典型的可以使用AOP面向切面编程思想的案例
 *      代码中的日志信息和业务逻辑的耦合性很高，不利于系统的维护，使用AOP可以进行优化，如何实现AOP？
 *      使用动态代理的方式来进行实现
 *
 *      动态代理：给业务代码找一个代理，打印日志信息的工作交给代理来做，这样的话，业务代码就只需要关心自身的业务逻辑即可，
 *
 */
//同理，具体的业务处理CalImpl也要交给IoC容器进行管理
@Component
public class CalImpl implements Calculator {
    @Override
    public int add(int num1, int num2) {
//        System.out.println("add方法的参数是:"+num1+","+num2);
        int result = num1+num2;
//        System.out.println("add方法的返回结果是:"+result);
        return result;
    }

    @Override
    public int sub(int num1, int num2) {
//        System.out.println("sub方法的参数是:"+num1+","+num2);
        int result = num1-num2;
//        System.out.println("sub方法的返回结果是:"+result);
        return result;
    }

    @Override
    public int mul(int num1, int num2) {
//        System.out.println("mul方法的参数是:"+num1+","+num2);
        int result = num1*num2;
//        System.out.println("mul方法的返回结果是:"+result);
        return result;
    }

    @Override
    public int div(int num1, int num2) {
//        System.out.println("div方法的参数是:"+num1+","+num2);
        int result = num1/num2;
//        System.out.println("div方法的返回结果是:"+result);
        return result;
    }
}
