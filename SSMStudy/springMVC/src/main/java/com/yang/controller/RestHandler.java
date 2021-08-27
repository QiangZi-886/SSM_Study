package com.yang.controller;

import com.yang.entity.Student;
import com.yang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {

    @Autowired
    private StudentRepository studentRepository;

//    @RequestMapping(value = "/findAll",method = RequestMethod.GET)  //具体的get请求的书写
    @GetMapping("/findAll")//get请求的简写
    public Collection<Student> findAll(HttpServletResponse response){
        /*
        * 直接将数据从对象中读取出来会出现中文乱码，xml的配置文件只能处理外部访问进来的格式。对于这种情况xml配置不生效
        *   所以需要手动使用response的seContentType来处理乱码
        * */
        response.setContentType("text/html;charset = utf-8");
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")   //REST风格的写法，通过id来查询用户。eg:springMVC/rest/findById/1
    public Student findById(@PathVariable("id") long id,HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        return studentRepository.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }

    @PutMapping("/test")
    @ResponseBody
    public String test(){
        return "测试表单提交PUT请求";
    }
}
