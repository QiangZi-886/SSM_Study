package com.yang.mybatisplus.generatorTest.service.Impl;

import com.yang.mybatisplus.generatorTest.entity.Class;
import com.yang.mybatisplus.generatorTest.mapper.ClassMapper;
import com.yang.mybatisplus.generatorTest.service.IClassService;
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
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements IClassService {

}
