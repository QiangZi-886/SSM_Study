package com.yang.test;

import com.yang.entity.Car;
import com.yang.factory.InstanceCarFactory;
import com.yang.factory.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {

        //一般情况下的静态工厂的使用方法
//        Car car = new StaticCarFactory().getCar(1l);
//        System.out.println(car);

        //使用IoC容器配置静态工厂的使用方法
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
//        Car car = context.getBean("car", Car.class);
//        System.out.println(car);

        //一般实例化工厂的使用方法
//        InstanceCarFactory instanceCarFactory = new InstanceCarFactory();
//        Car car = instanceCarFactory.getCar(1l);
//        System.out.println(car);
        //通过配置IoC容器使用实例化工厂方法
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car1 = context.getBean("car1", Car.class);
        System.out.println(car1);
    }
}
