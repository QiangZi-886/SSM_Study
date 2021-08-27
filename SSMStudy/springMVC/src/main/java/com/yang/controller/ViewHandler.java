package com.yang.controller;

import com.yang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
//@SessionAttributes(value = "user")
//添加这个注解之后，无论类中的哪个业务方法被访问，将业务数据绑定到request域的同时，也会将业务数据绑定到session域对象当中。
//前提是request域数据当中的key值必须与注解名中的value值相同
//@SessionAttributes(type = User.class)  通过类型添加
public class ViewHandler {


//map模型数据的使用
    @RequestMapping("/map")
    public String map(Map<String,User> map){
        User user = new User();
        user.setId(1l);
        user.setName("法外狂徒");
        map.put("user",user);   //此时map就是模型数据
        return "view";  //这里的view实际上就是视图，SpringMVC会解析模型和视图，虽然格式是map集合，但是实际上是传到了request域中的
    }
//model模型数据的使用
    @RequestMapping("/model")
    public String model(Model model){
        User user = new User();
        user.setId(2l);
        user.setName("张三");
        model.addAttribute("user",user);
        return "view";
    }
//ModelAndView模型的使用(注意：这里使用ModelAndView的时候，返回值类型就必须是ModelAndView了，不能再只返回String的视图)
    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user = new User();
        user.setId(3l);
        user.setName("李四");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("view");
        return modelAndView;
    }

    //ModelAndView的第二种书写方式
    @RequestMapping("/modelAndView2")
    public ModelAndView modelAndView2(){
        User user = new User();
        user.setId(4l);
        user.setName("王五");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);        //同样先加数据模型
        View view = new InternalResourceView("/view.jsp");//也同样可以使用view的实例化对象。view是接口所以使用它的实现子类
        modelAndView.setView(view);     //加完模型之后加视图，但是具体实现方法是使用View接口中的InternalResourceView，注意，其中需要
        return modelAndView;            //填写物理视图路径，不能直接填写逻辑视图“view”。
    }

    //ModelAndView的第三种书写方式。往下都是使用了ModelAndView的不同的构造函数来进行数据模型的添加
    @RequestMapping("/modelAndView3")
    public ModelAndView modelAndView3(){
        User user = new User();
        user.setId(5l);
        user.setName("马六");
        ModelAndView modelAndView = new ModelAndView("view");//在这里可以直接给视图名称
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    //第四种
    @RequestMapping("/modelAndView4")
    public ModelAndView modelAndView4(){
        User user = new User();
        user.setId(6l);
        user.setName("刘七");
        View view = new InternalResourceView("/view.jsp");//这里注意一定需要使用视图的物理路径
        ModelAndView modelAndView = new ModelAndView(view);//也可以直接使用视图参数，需要先新建view对象
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    //第五种
    @RequestMapping("/modelAndView5")
    public ModelAndView modelAndView5(){
        User user = new User();
        user.setId(7l);
        user.setName("狗八");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        ModelAndView modelAndView = new ModelAndView("view",map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView6")
    public ModelAndView modelAndView6(){
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        Map<String,User> map = new HashMap<>();
        map.put("user",user);
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view,map);
        return modelAndView;
    }

    @RequestMapping("/modelAndView7")
    public ModelAndView modelAndView7(){
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("view","user",user);//也可以不用map集合直接对其进行添加
        return modelAndView;
    }

    @RequestMapping("/modelAndView8")
    public ModelAndView modelAndView8(){
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        View view = new InternalResourceView("/view.jsp");
        ModelAndView modelAndView = new ModelAndView(view,"user",user);
        return modelAndView;
    }

//直接使用原生的方式，直接将模型添加到request域当中去
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        request.setAttribute("user",user);
        return "view";
    }

    /*
    *   如果同时存在多个使用@ModelAttribute注解的方法，那么使用Model模型数据进行填充的方法的优先级会更高。
    *       它的返回值会覆盖其他直接使用对象填充的方法
    * */


//使用注解的方式，其中ModelAttribute是先于"/modelAttribute"执行的，所以在下面直接return "view"即可
//    @ModelAttribute//域对象中的存值都是以key-value的形式存的值，此时的key默认值是业务数据对应的类的首字母小写
//    public User getUser(){      //定义了一个方法，该方法专门用来返回要填充到模型数据中的对象..注意：！！使用这个注解会覆盖掉之前填充过的数据
//        User user = new User();
//        user.setId(1l);
//        user.setName("张三");
//        return user;    //模型user创建完成
//    }

/*
    使用一下这两种没有返回值的方式也可以完成对模型数据中对象的填充。上面的是框架帮做的内容，下面的是自己手动做的内容
    @ModelAttribute
    public void getUser(Map<String,User> map){
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        map.put("user",user);
    }
    @ModelAttribute
    public void getUser(Model model) {
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        model.addAttribute("user",user);
    }*/

    @RequestMapping("/modelAttribute")
    public String modelAttribute(){
        return "view";     //user模型的创建以及添加以及在getUser()中完成，所以在modelAttribute()中直接返回处理视图即可
    }

//    @RequestMapping("/test")
//    public String test(){
//        return "view";      //测试完成，在ModelAttribute注解之后的方法可以直接返回视图"view"，也能完成相关业务操作
//    }

    @RequestMapping("/session")
    public String session(HttpServletRequest request){      //使用最多。资源不会浪费
        HttpSession session = request.getSession();
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }
    @RequestMapping("/session2")
    public String session2(HttpSession session){    //也可以直接在参数列表中直接声明HttpSession,HandlerAdapter会自动帮忙创建
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        session.setAttribute("user",user);
        return "view";
    }

    @RequestMapping("/application")
    public String application(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        User user = new User();
        user.setId(1l);
        user.setName("张三");
        application.setAttribute("user",user);
        return "view";
    }
}
