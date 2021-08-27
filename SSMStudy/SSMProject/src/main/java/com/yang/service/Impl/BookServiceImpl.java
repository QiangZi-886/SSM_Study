package com.yang.service.Impl;

import com.yang.entity.Book;
import com.yang.repository.BookRepository;
import com.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public int save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public int update(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public int deleteById(Integer id) {
        return bookRepository.deleteById(id);
    }
}
