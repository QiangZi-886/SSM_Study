package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class student {
    private int id;
    private String name;
    private int age;

    public student(){
        System.out.println("student被创建了");
    }
}
