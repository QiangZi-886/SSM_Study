package com.yang.test;

import com.yang.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
