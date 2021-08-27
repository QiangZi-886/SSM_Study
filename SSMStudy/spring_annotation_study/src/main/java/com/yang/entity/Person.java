package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 将Car注入到person类的属性中
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private Car car;
}
