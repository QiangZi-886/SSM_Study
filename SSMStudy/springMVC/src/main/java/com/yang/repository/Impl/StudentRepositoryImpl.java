package com.yang.repository.Impl;

import com.yang.entity.Student;
import com.yang.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    //定义一个静态集合用来模拟数据库
    public static Map<Long,Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1l,new Student(1l,"杨1",21));
        studentMap.put(2l,new Student(2l,"王二麻子",18));
        studentMap.put(3l,new Student(3l,"张三",18));
        studentMap.put(4l,new Student(4l,"李四",18));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
