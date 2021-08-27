package com.yang.Util;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtil {
    //javaSE知识，...表示多个参数，然后把返回的结果集作为数组列表打印输出。
    public static void start(Method method,Object... objects){
        System.out.println(method.getName()+"方法开始执行，参数是:" + Arrays.asList(objects));
    }

    public static void stop(Method method,Object... objects){
        System.out.println(method.getName()+"方法执行结束，结果是:" + Arrays.asList(objects));
    }
}
