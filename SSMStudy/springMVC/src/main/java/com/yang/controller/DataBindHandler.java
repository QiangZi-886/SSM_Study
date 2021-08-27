package com.yang.controller;

import com.yang.entity.User;
import com.yang.entity.UserList;
import com.yang.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
/*
    针对于代码中多次重复的@ResponseBody，在@Controller这个注解上可以改为@RestController，然后子级的@ResponseBody就可以省略不写
    且也能实现相同的效果。
        慎用！
        原因：@RestController：表示改控制器会直接将业务方法的返回值响应给客户端，不进行视图解析
                             （返回的只是一个Model，直接将原有方法中的返回值返回到客户端。）
            而@Controller：表示该控制器的每一个业务方法的返回值都会交给视图解析器进行解析，如果只需要将数据返回给客户端，而不需要进行视图解析
                          则需要在对应的业务方法定义处添加@ResponseBody注解
                          （返回的是一个ModelAndView，会自动将返回的数据渲染成客户看的jsp等页面）
 */
@RequestMapping("data")
public class DataBindHandler {

    @RequestMapping("/baseType")
    @ResponseBody   //表示当前内容不需要通过SpringMVC的解析器解析成"/*.jsp"，直接将其返回值响应给客户端
    /*
    *   其中int类型的id 作为基本数据类型，不能接收赋值为null的类型，所以当在客户端没有给id赋值时，进行访问就会报错，
    *   针对于这种情况，解决办法就是使用包装类，将基本数据类型int改成包装类的Integer
    * */
    public String baseType(int id){
        return id+"";
    }

    /*
    *   @RequestParam：将num映射到参数id中，即：赋值时可以不用使用id进行赋值，可以直接使用num进行赋值。
    *   （注意！使用这个语法之后，如果想向id中传入参数，就只能传递参数名为num的值）
    *   required：设置参数是否为必填项，默认是false。当改为true时则参数为必须传递，否则报错
    *   default：为参数设置默认值，即：当不给参数赋值的时候，参数展示为多少
    * */
    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "0") Integer id){
        return id+"";
    }

    /**
     * 在值传递的时候关于数组的绑定
     */
    @RequestMapping("/array")
    @ResponseBody
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }


    /**
     注意！！在SpringMVC中List集合不能直接被绑定
     在springMVC的数据类型绑定中，对于类、级联对象。都是只针对于类的属性值进行数据绑定的
     所以，如果想实现List集合的数据绑定，将List集合直接作为某个类的属性，然后再为属性赋值即可
     */

    @RequestMapping(value = "/list",produces = "text/html;charset=utf-8;")  //produces用来解决客户端中文乱码
    @ResponseBody
    public String list(UserList userList){
        StringBuffer str = new StringBuffer();
        for (User user: userList.getUsers()){
            str.append(user);
            System.out.println(str);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    @ResponseBody
    public String map(UserMap userMap){
        StringBuffer str = new StringBuffer();
        //Map集合的遍历和List集合不同，实际上是在对Map集合的Key进行遍历，然后使用Map集合的对象的.get(key)方法获取value值
        for (String key:userMap.getUsers().keySet()){    //keySet方法就是返回Map集合中的key值
            User user = userMap.getUsers().get(key);
            str.append(user.toString());
        }
        return str.toString();
    }

    @RequestMapping(value = "/json",produces = "application/json")
    @ResponseBody//将返回的javabean对象,使用springMVC提供的HTTPMessageConverter接口转为一个json对象，响应给客户端
    public User json(@RequestBody User user){//这里的RequestBody注解将读取的参数转为json格式的数据，并绑定到形参上
        System.out.println(user);
        user.setId(6);
        user.setName("杨1");
        return user;
    }
}
