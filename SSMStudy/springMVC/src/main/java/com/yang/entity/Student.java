package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private int age;


    //jsp页面学习使用到的成员变量
    private boolean flag;
//    private String[] hobby; //使用数组的方式
    private List<String> hobby;//使用List集合实现
    private List<String> selectHobby;
    private int RadioId;//单选框
    private Map<Integer,String> gradeMap;//使用集合实现的单选框
    private int selectGrade;
    private Map<Integer,String> cityMap;//集合实现下拉框
    private int selectCity;
    //textarea文本显示域
    private String introduce;


    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
