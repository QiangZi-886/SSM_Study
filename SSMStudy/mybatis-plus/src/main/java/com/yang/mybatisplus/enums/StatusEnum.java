package com.yang.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

//状态的枚举类
public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息");


    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue//添加这个注解将code映射，当code=1的时候映射到work，当code=0映射到rest
    private Integer code;
    private String msg;
}
