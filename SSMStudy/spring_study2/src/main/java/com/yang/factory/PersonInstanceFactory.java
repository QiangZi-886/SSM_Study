package com.yang.factory;

import com.yang.bean.Person;

/**
 * 实例工厂类
 */
public class PersonInstanceFactory {
    public  Person getInstance(String name){
        Person person = new Person();
        person.setId(2);
        person.setName(name);
        person.setAge(22);
        return person;
    }
}
