package com.yang.controller;

import com.yang.entity.Student;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tag")
public class TagHandler {

    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("show");
        Student student = new Student(1l,"杨杨杨",21);
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    @GetMapping("/tagTest")
    public ModelAndView tagTest(){
        ModelAndView modelAndView = new ModelAndView("tag");
//        Student student = new Student(1l,"这样啊...那算了吧",21);
        Student student = new Student();
        student.setId(1l);
        student.setName("这样啊...那算了吧");
        student.setAge(21);
        student.setFlag(true);
//        String[] hobby = {"睡觉","发呆","看手机"};
//        student.setHobby(hobby);
        student.setHobby(Arrays.asList("学习","睡觉","看电影","发呆","玩游戏","看手机"));
        student.setSelectHobby(Arrays.asList("学习","睡觉","看电影"));
        //单选框--radiobutton
        student.setRadioId(1);
        //集合实现单选框--radiobuttons
        Map<Integer,String> gradeMap = new HashMap<>();
        gradeMap.put(1,"一年级");
        gradeMap.put(2,"二年级");
        gradeMap.put(3,"三年级");
        gradeMap.put(4,"四年级");
        gradeMap.put(5,"五年级");
        gradeMap.put(6,"六年级");
        student.setGradeMap(gradeMap);
        student.setSelectGrade(5);
        //集合实现下拉框
        Map<Integer,String> citymap = new HashMap<>();
        citymap.put(1,"北京");
        citymap.put(2,"澳门");
        citymap.put(3,"浙江");
        citymap.put(4,"河南");
        citymap.put(5,"江西");
        student.setCityMap(citymap);
        student.setSelectCity(4);
        //自定义文本输入域默认值
        student.setIntroduce("你好，我是老八..");
        modelAndView.addObject("student",student);
        return modelAndView;
    }
}
