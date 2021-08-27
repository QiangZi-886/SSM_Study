package com.yang.converter;

import com.yang.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {
    @Override
    public Student convert(String s) {
        String[] args = s.split("-");//对String类型的数据进行拆分，规则是以"-"为界限来拆分.eg:"1-yang-21"拆成{"1","yang","21"}
        Student student = new Student();
        student.setId(Long.parseLong(args[0]));
        student.setName(args[1]);
        student.setAge(Integer.parseInt(args[2]));
        return student;
    }
}
