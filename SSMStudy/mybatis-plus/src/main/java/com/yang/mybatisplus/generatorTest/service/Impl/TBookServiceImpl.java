package com.yang.mybatisplus.generatorTest.service.Impl;

import com.yang.mybatisplus.generatorTest.entity.TBook;
import com.yang.mybatisplus.generatorTest.mapper.TBookMapper;
import com.yang.mybatisplus.generatorTest.service.ITBookService;
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
public class TBookServiceImpl extends ServiceImpl<TBookMapper, TBook> implements ITBookService {

}
