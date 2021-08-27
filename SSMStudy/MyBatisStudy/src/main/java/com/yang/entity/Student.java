package com.yang.entity;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int sid;
    private Classes classes;
}
