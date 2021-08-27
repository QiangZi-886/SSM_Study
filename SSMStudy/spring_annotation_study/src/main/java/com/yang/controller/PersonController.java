package com.yang.controller;

import com.yang.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
//@Scope(value = "prototype")
public class PersonController {

    /**
     * 通过@AutoController注解能够完成自动注入的功能
     *      是按照什么方式进行自动注入的？
     *      默认情况下时按照类型（ByType）来进行装配的，如果找到直接赋值，找不到就报错
     *      如果有多个类型一样的bean对象，此时会按照id来进行查找，默认的id字段是类名首字母小写
     *      如果找到了直接注入，如果找不到那么就报错
     *
     *      如果你想通过名字进行查找，可以自己规定名称，使用注解@Qualifier
     *
     *      当@Autowired添加到方法上的时候，此方法在创建对象的时候回默认调用，同时方法中的参数会进行自动装配
     *      @Qualifier也可以定义在方法中，可以指定当前属性的id名称（别名）
     *
     *      使用@Resource可以完成跟@Autowired相同的功能，但是要注意他们之间的区别
     *      1、@Resource是jdk提供的功能。@Autowired是spring提供的功能
     *      2、@Resouce可以在其他框架中使用，@Autowired只能在spring中使用
     *              换句话说：@Resouce扩展性好，而@Autowired支持的框架比较单一
     *      3、@Resouce是按照名称进行装配的，如果名字找不到，就使用类型
     *      而@Autowired是按照类型进行装配的，如果类型找不到，就使用名字
     */
    @Autowired
    private PersonService personService;
    public void save(){
        personService.save();
    }
}
