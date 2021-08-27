package com.yang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        //IOC容器中，默认的创建顺序是：哪个bean在前面先创建哪个。但是依赖关系是：首先创建被依赖的bean
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-depends.xml");
    }
}
