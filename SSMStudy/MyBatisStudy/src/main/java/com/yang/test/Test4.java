package com.yang.test;

import com.yang.entity.Student;
import com.yang.repository.ClassesRepository;
import com.yang.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test4 {
    public static void main(String[] args) {
        InputStream inputStream = Test4.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //直接调用
//        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);
//        System.out.println(classesRepository.findById(2));

        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
        Student student = studentRepository.findByIdLazy(2);
        /*
        * 如果获取的是整个student对象，那么需要进行两次sql语句的查询，查询两次表格。
        * 但是如果只是想获取第一张表中的某个数据，那么就没必要进行第二张表格的查询。
        * 如何对第二步进行省略？在config.xml中添加配置，开启延迟加载即可
        * */
        System.out.println(student.getName());

        sqlSession.close();
    }
}
