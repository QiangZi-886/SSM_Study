package com.yang.controller;

import com.yang.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/converter")
public class ConverterHandler {

    @RequestMapping("/date")
    public String date(Date date){
        return date.toString();
    }

    @RequestMapping("/student")
    public Student student(Student student, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        return student;
    }
}
