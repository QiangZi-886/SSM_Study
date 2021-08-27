package com.yang.controller;

import com.yang.entity.Account;
import com.yang.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/validator")
public class ValidatorHandler {

    //因为前台表单需要先绑定模型数据才能进行数据验证，所以这里先向jsp页面传递一个空的模型数据，绑定为一个Account类型的模型数据
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account",new Account());
        return "login";
    }

    @PostMapping("/login")
    //注意：这里的account就是上一个方法传递给jsp的数据模型，然后再post请求的login方法中接受到这个模型数据，然后进行验证
    public String login(@Validated Account account, BindingResult bindingResult){//该注释表示可以直接激活验证器
        if (bindingResult.hasErrors()){//BindResult（存储的就是错误信息）--绑定结果集进行验证判断，如果有错就返回到login.jsp
            return "login";
        }
        return "index";
    }

    @GetMapping("/register2")
    public String register(Model model){
        model.addAttribute("person",new Person());
        return "register2";
    }

    @PostMapping("/register2")
    //注意：写法虽然很相似，但是这里使用的是@Valid
    //**********这里如果想要生效，必须！！在springmvc.xml中重新配置annotation-driven注释驱动器,否则不会生效
    public String register(@Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register2";
        }
        return "index";
    }
}
