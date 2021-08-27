package com.yang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/converter")
public class DateConverterHandler {

    @RequestMapping("/date")
    @ResponseBody
    public String date(Date date){
        return date.toString();
    }
}
