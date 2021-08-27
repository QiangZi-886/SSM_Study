package com.yang.proxy;

import com.yang.Util.LogUtil;
import com.yang.service.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorProxy {

    public static Calculator getCalculator(final Calculator calculator){

        //获取被代理对象的类加载器
        ClassLoader lodar = calculator.getClass().getClassLoader();

        //被代理对象的 所有 接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        //用来执行被代理类需要执行的方法
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method.getName()+"方法开始执行，参数列表是："+ Arrays.asList(args));
                LogUtil.start(method,args);
                //开始调用被代理类的方法
                Object resulet = method.invoke(calculator,args);
//                System.out.println(method.getName()+"方法执行完毕，结果是："+resulet);
                LogUtil.stop(method,resulet);
                return resulet;
            }
        };
        Object o = Proxy.newProxyInstance(lodar, interfaces, handler);
        return (Calculator) o;
    }
}
