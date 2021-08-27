package com.yang.mybatisplus.entity;

import lombok.Data;

@Data
public class ProductVO {
    private Integer id;
    private Integer category;//商品种类
    private Integer count;//商品数量
    private String description;//商品描述
    private Integer userId;//用户id
    private String user;//用户姓名
}
