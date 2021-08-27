package com.yang.service;

import com.yang.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    public List<Book> findAll();
    public Book findById(Integer id);
    public int save(Book book);
    public int update(Book book);
    public int deleteById(Integer id);
}
