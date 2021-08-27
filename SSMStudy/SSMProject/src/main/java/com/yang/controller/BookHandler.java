package com.yang.controller;

import com.yang.entity.Book;
import com.yang.service.BookService;
import com.yang.service.Impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book")
public class BookHandler {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books",bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("book",bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Book book){
        bookService.save(book);
        return "redirect:/book/index";
    }

    @DeleteMapping("/deleteById/{id}")
    public String delete(@PathVariable("id") Integer id){
        bookService.deleteById(id);
        return "redirect:/book/index";
    }

    @PutMapping("/update")
    public String update(Book book){
        bookService.update(book);
        return "redirect:/book/index";
    }
}
