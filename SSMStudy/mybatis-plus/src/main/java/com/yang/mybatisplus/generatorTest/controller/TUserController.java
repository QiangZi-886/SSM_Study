package com.yang.mybatisplus.generatorTest.controller;


import com.yang.mybatisplus.generatorTest.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yang
 * @since 2021-08-14
 */
@Controller
@RequestMapping("/generatorTest/tUser")
public class TUserController {

    @Autowired
    private ITUserService userService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("list",userService.list());
        return modelAndView;
    }
}

