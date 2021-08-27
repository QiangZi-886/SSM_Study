package com.yang.factory;

import com.yang.bean.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * 此方式是spring创建bean方式的一种补充个，用户可以按照需求创建对象，
 * 创建的对象交由spring IOC容器来管理，无论是否单例，都是在用到的时候
 * 才会创建对象，不用该对象不会创建（一般用不到，了解即可）
 */
public class MyFactoryBean implements FactoryBean<Person> {
    /**
     * 返回获取的bean
     * @return
     * @throws Exception
     */
    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setId(9);
        person.setName("我叫Factorybean");
        return person;
    }

    /**
     * 获取返回bean的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * 判断当前的bean是否是单例（singleton）
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
