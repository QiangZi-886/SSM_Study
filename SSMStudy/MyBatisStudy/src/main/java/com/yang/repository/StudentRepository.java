package com.yang.repository;

import com.yang.entity.Student;

public interface StudentRepository {
    public Student findById(int id);
    public Student findByIdLazy(int id);
}
