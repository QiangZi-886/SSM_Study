package com.yang.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.mybatisplus.entity.ProductVO;
import com.yang.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface T_UserMapper extends BaseMapper<User> {
    //当mybatis-plus提供的方法无法满足我们的要求的时候(比如：多表关联查询)，那么我们就需要在mapper中自己定义相关的方法
    @Select("SELECT p.*,u.`username` user FROM t_user u , t_product p WHERE p.`userId` = u.`id` AND u.`id`= #{id}")
    public List<ProductVO> productList(Integer id);//传入的是用户(t_user)的id
}
