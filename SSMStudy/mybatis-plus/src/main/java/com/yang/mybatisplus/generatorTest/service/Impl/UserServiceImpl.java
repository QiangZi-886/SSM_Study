package com.yang.mybatisplus.generatorTest.service.Impl;

import com.yang.mybatisplus.generatorTest.entity.User;
import com.yang.mybatisplus.generatorTest.mapper.UserMapper;
import com.yang.mybatisplus.generatorTest.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
