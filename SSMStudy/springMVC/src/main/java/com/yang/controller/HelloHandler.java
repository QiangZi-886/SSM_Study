package com.yang.controller;


import com.yang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//把当前的这个类交给IoC容器管理，使其具备控制器的功能
//在实际开发中，可能会遇到很多个HelloHandler，里面有很多index，所以为了避免资源找不到，一般都会在类前也添加上@RequestMapping
@Controller
@RequestMapping("/hello")
public class HelloHandler {

    /**
     * RequestMapping中的属性值：
     *      value:默认属性，但是如果要加上其他属性的话，就需要将"value"写上
     *      method：指定访问的方法，一般有GET,POST,PUT,DELETE
     *      param:指定必须带有的参数，可以指定参数的个数，也可以指定参数的值为多少。
     *      然后在客户端只有将这些属性全部输入正确之后，才能访问到相应的页面。
     *
     * 在springMVC中，如果想要拿到parameter中的值的话，不需要再向之前一样使用request.getParameter属性
     * spring的HandlerAdapter会自动帮我们处理表单中的数据，具体使用的话，就直接在index()的括号中定义参数值，与param中定义的相同的属性名
     * 然后在打印输出即可。
     *
     *  关于参数值的绑定，当index方法参数列表中的参数名非要与param中的不同时
     *  在形参列表中通过添加@RequestParam注解完成HTTP请求参数与业务方法形参的映射。
     *      public String index(@RequestParam("name")String str,@RequestParam("id")int age)
     *
     *  上述代码表示将请求的参数name、id分别赋给了str和age，同时完成了数据转换。将"10"转成int类型的10，再赋值给age。
     *      这些工作都是由HandlerAdapter来完成的
     *
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET,params = {"name","id=10"})
    public String index(String name,int id){
        System.out.println(name);
        System.out.println(id);
        System.out.println("执行了index.....");
        return "index";
    }

    /**
     * SpringMVC也同样支持rest风格的URL
     *      传统类型：http://localhost:8080/hello/index?name=zhangsan&id=10
     *      restful 风格：http://localhost:8080/hello/rest/zhangsan/10
     *
     *      通过@PathVariable注解完成请求参数与形参的映射
     * @return
     */
    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name")String name,@PathVariable("id")int id){
        System.out.println(name);
        System.out.println(id);
        return "index";
    }

    /**
     * springMVC可以通过映射直接在业务方法中获取Cookie的值
     */
    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    /**
     * 针对于访问jsp页面，填写表单，并且将表单中的信息封装到javaBean中，SpringMVC也可以实现简化操作
     *   例如：需求是用户在jsp页面注册信息，服务器需将用户输入的信息封装进User类中，并在控制台打印输出
     *      首先是register注册jsp页面，将表单信息提交到hello/save中，在HandlerAdapter中配置save映射
     *      提交方法使用Post
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);
        return "index";
    }

    /**
     * 转发：客户端只发来一次请求，地址栏不变
     * 重定向：客户端发来两次请求，且地址栏改变
     *
     * 在springMVC中，默认是使用转发的形式来进行jsp的响应的。
     *
     *
     */
    @RequestMapping("/forward")
    //请求转发，效果与下面的写法是一样的
    public String forward(){
        return "forward:/index.jsp";
//        return "index";
    }

    @RequestMapping("/redirect")
    //请求资源重定向，地址栏会发生改变
    public String redirect(){
        return "redirect:/index.jsp";
    }

}
