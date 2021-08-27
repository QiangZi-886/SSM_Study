package com.yang.mybatisplus.generatorTest.service.Impl;

import com.yang.mybatisplus.generatorTest.entity.TAccount;
import com.yang.mybatisplus.generatorTest.mapper.TAccountMapper;
import com.yang.mybatisplus.generatorTest.service.ITAccountService;
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
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

}
