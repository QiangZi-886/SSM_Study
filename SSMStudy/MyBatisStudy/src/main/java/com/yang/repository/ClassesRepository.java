package com.yang.repository;

import com.yang.entity.Classes;

public interface ClassesRepository {
    public Classes findById(int id);
    public Classes findByIdLazy(int id);
}
