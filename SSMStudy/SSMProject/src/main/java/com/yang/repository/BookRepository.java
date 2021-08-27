package com.yang.repository;

import com.yang.entity.Book;
import java.util.List;

public interface  BookRepository {
    public List<Book> findAll();
    public Book findById(Integer id);
    public int save(Book book);
    public int update(Book book);
    public int deleteById(Integer id);
}
