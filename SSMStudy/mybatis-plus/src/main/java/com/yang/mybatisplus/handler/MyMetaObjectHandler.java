package com.yang.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MybatisPlus提供的处理器，处理器中有两个方法，分别是insertFill方法和updateFill方法
 *
 * 千万注意一定要添加@Component注解，将这个类添加到IOC容器中
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        /**
         * 下面的方法的意思就是:
         *      在mybatisPlus向数据库中插入数据之前，回来到这个handler，然后这个handler其中的insertFill方法
         *      通过外部调用它，传入的metaObject对象，根据Name(字段名)向字段中插入FieldValue数据，数据就是当前的
         *      系统时间new Date()
         *
         *      metaObject对象就是你需要插入的User对象或者是更改的User对象
         */
        this.setFieldValByName("creatTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
