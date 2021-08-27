package com.yang.controller;

import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/findAllUser")
    public ModelAndView findAllUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showUser");
        modelAndView.addObject("list",userService.findAll());
        return modelAndView;
    }
}
