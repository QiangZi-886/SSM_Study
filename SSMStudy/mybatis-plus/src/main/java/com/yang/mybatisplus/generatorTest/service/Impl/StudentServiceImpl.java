package com.yang.mybatisplus.generatorTest.service.Impl;

import com.yang.mybatisplus.generatorTest.entity.Student;
import com.yang.mybatisplus.generatorTest.mapper.StudentMapper;
import com.yang.mybatisplus.generatorTest.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yang
 * @since 2021-08-14
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
