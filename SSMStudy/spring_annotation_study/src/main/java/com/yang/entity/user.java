package com.yang.entity;

import lombok.Data;

@Data
public class user {
    private int id;
    private String name;
    private int age;

    public user() {
        System.out.println("user被创建了");
    }
}
