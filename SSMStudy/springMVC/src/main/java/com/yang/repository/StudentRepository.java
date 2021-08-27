package com.yang.repository;
//repository----存储室。用来存放一些接口
import com.yang.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    public Collection<Student> findAll();   //返回所有学生集合方法
    public Student findById(long id);       //通过学生long型的id来查找学生方法
    public void saveOrUpdate(Student student);      //保存或修改方法
    public void deleteById(long id);        //通过id来对学生进行删除方法

}
