package com.yang.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.yang.mybatisplus.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

/**
 *  注意：
 *  @TableId
 *      这里的主键id如果不加@TableId注解，那么就必须与数据库的主键能够对应起来，否则会报错。
 *          且这里的@TableId注解除了可以指定它的value值，还可以指定它的type（主键的生成策略）
 *           策略：(这里只需要掌握五种策略即掌握全部)                     使用方式： @TableId(type =IdType.AUTO... )
 *              AUTO(0),        数据库自增   即使采用手动赋值，结果依然以数据库自增为主
 *              NONE(1),        MP(Mybatis Plus) set主键,使用雪花算法实现 雪花算法：生成一串唯一的id主键(一般会比较长，需要数据库和实体类都指定足够长度的存储位数)
 *              INPUT(2),       需要开发者手动赋值。如果开发者没有手动赋值，那么数据库通过自增的方式给主键赋值
 *              ASSIGN_ID(3),   MP 分配ID，有Long,String,Integer三种类型。   自动赋值，雪花算法
 *              ASSIGN_UUID(4), 分配UUID，只有String类型
 *
 *   @TableFiled 映射非主键字段，使用value指定字段名
 *      exit 表示是否为数据库字段 false。
 *          如果实体类中的成员变量在数据库中没有对应的字段，则可以使用exit忽略掉实体类中的某个属性。（一般在VO、DTO应用的比较多）
 *      select 表示是否查询该字段。用在已有字段，但是想要跳过查询，就使用select属性，指定值为false 即跳过不查询
 *      fill 表示是否自动填充。
 *          将对象存入数据库的时候，由MybatisPlus自动给某些字段赋值。比如订单信息：creat_time(创建日期)、update_time(更新时间)
 *
 *  @Version 标记乐观锁
 *      通过version字段来保证数据安全性。（类似于同步锁），当修改数据的时候，会以version作为条件，当条件成立的时候才会修改成功。
 *    eg：           version是根据当前数据库中的默认值来进行自增的
 *      线程1: update ... set version = 2 where version = 1
 *      线程2: update ... set version = 2 where version = 1
 *    当线程2抢到资源开始执行的时候，首先判断version是否为1，如果为1则进行数据的更新修改，且将version设置为2，以此保证数据的安全性。
 *    在这个时候线程1如果想要更新修改资源，那么它也会首先判断version是否为1，可此时version为2，所以它不能对数据进行修改.
 *          使用：1、首先数据库中必须要先有一个拥有默认值的字段（version）。
 *               2、然后创建配置类，使乐观锁生效
 *
 * @EnumValue 通用枚举类注解，将数据库字段映射成实体类的枚举类型成员变量(两种实现方式:1、在需要映射的变量上使用@EnumValue注解  2、使类实现Ienum接口)
 *      但是需要注意类中枚举类型 成员变量的名字必须与数据库中的字段名相对应。同理如果非要不一致，那就使用@TableField注解指定一下
 *   然后还需要在配置文件中将枚举类扫描进IOC
 *
 * @TableLogic
 *  逻辑映射删除（俗称的假删 在删除一些订单或者是用户信息的时候，不能真的删除，否则会丢失数据。所以使用假删）
 *      1、数据库添加deleted字段（当值为0时，表示有数据。1表示数据存在）
 *      2、实体类添加注解
 *      3、application.yml添加配置
 *
 *
 */
@Data
@TableName(value = "t_user")//使用@TableName注解，指定需要连接的表名
public class User {
    @TableId(value = "id")//设置主键映射，value映射主键字段名，type设置主键类型，主键的生成策略
    private Integer id;
    @TableField(value = "username")//关联表中其他属性的注解是@TableField，value属性对应表中的字段名。一般用于实体类中的属性名与数据库字段不相同的时候
    private String name;
    private String password;

    /**
     * 使用方式需要创建handler
     *  注意：！！
     *      这里的creatTime和updateTime，两个时间，它们两个时间的关系应该是：在第一创建的时候，两个时间都要被赋值，然后INSERT的这个
     *      初次创建的时间就不会变了，然后在对数据更改的时候，UPDATE的时间再变动。
     *          所以updateTime的fill属性采用的应该是FieldFill.INSERT_UPDATE两个都要有
     */
    @TableField (fill = FieldFill.INSERT)//表示的是插入新创建的date数据时，MybatisPlus自动帮助填充数据
    private Date creatTime;//这里的creatTime采用的驼峰命名法与数据库中的creat_time这个带下划线的字段会自动对应起来
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private Integer version;

    //这里需要注意： 枚举类型的成员变量的变量名需要跟数据库的字段名对应起来。
//    private StatusEnum status;
    @TableField(value = "status")//如果非要不一致，那就使用@TableField注解指定
    private StatusEnum statusEnum;

    @TableLogic
    private Integer deleted;
}
