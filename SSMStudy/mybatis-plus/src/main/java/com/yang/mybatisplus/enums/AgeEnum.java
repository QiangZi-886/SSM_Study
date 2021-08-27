package com.yang.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * 这里只书写逻辑上的实现代码，因为数据库中没有age这个字段，重新建太麻烦，所以这里只记录逻辑代码。
 *
 *      第二种方法需要让枚举类实现IEnum接口，并且使用泛型指定状态字段（age）的类型，之后需要实现其中的getValue()方法，
 *      返回对应字段(age)的code即可。
 *          只要是想要使用@EnumValue这个注解，那么就需要返回一个对应字段的code。
 */
public enum AgeEnum implements IEnum<Integer> {
    One(1,"一岁"),
    TWO(2,"两岁"),
    THREE(3,"三岁");

    private Integer code;
    private String msg;

    AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
