package com.yang.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request){   //使用spring中封装好的multipartFile讲传入的文件自动封装起来
//        System.out.println(img);
        //首先确保上传的文件有内容
        if (img.getSize()>0){
            //保存上传文件的file路径
            String path =request.getServletContext().getRealPath("file");//实际上就在Tomcat的webapps/springMVC/file
//            String path = "D:\\";
            //获取上传的文件名
            String name = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                //将文件使用transferTo(spring封装好的方法)写出去
                img.transferTo(file);
                //图片上传成功之后预览功能
                request.setAttribute("path","/springMVC/file/"+name);//只需要在jsp页面直接读取存储之后的图片路径即可
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs,HttpServletRequest request){//多文件上传，选中的多个文件controller使用数组进行存储
        //多文件上传，为了保存相应的String路径，使用集合进行简化操作
        List<String> files = new ArrayList<>();
        for (MultipartFile img:imgs){
            if (img.getSize()>0){
                String path = request.getServletContext().getRealPath("file");
                String name = img.getOriginalFilename();
                File file = new File(path,name);
                try {
                    img.transferTo(file);
                    files.add("/springMVC/file/"+name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files",files);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    //这里使用RESTful风格，使用@PathVariable将参数映射到URL中
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        if (name!=null){
            name += ".jpg";
            String path = request.getServletContext().getRealPath("file");//获取指定的路径
            File file = new File(path,name);//按照传进来的name参数，在获取到的指定的路径下寻找文件
            OutputStream outputStream = null;//书写流OutputStream
            if (file.exists()){//如果文件存在，那么就进行下载
                response.setContentType("application/forc-download");//在响应response中设置为下载
                //设置下载文件名
                response.setHeader("Content-Disposition","attachment;filename="+name);
                try {
                    outputStream = response.getOutputStream();
                    //使用FileUtils工具类直接将file文件以字符数组的形式读出去简化操作
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (outputStream !=null){
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
