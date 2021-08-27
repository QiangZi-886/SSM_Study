package com.yang.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private T_UserMapper mapper;//这里并不是错误，不影响运行

    @Test
    void test(){
        //select语句中的扩号没有给定条件，使用的是null，即查询所有的信息，将所有的信息全部打印出来
        mapper.selectList(null).forEach(System.out::println);//输出使用的是java新特性的foreach
    }

    @Test
    void save(){
        User user = new User();
        user.setId(5);
        user.setName("七夕节");
        user.setPassword("999");
        mapper.insert(user);
        System.out.println(user);
    }

    @Test
    void update(){
        //此时 update ... set version = 2 where version = 1
        User user = mapper.selectById(5);
        user.setName("七夕前一天");
        //此时 update ... set version = 2 where version = 1
        User user1 = mapper.selectById(5);
        user1.setName("七夕当天");
        //如果执行成功，那么它的值应该是name：七夕前一天，version：3
        mapper.updateById(user1);
        mapper.updateById(user);
        /**
         * 但是结果却是name：七夕当天，version：2
         *
         *    所以当两个进程同时想要修改数据的时候，使用乐观锁可以保证数据的安全性
         */
    }

    /**
     *  逻辑删除的测试类
     *      这里的删除并不是真正的删除，只是逻辑上的删除，实际操作的sql语句是update，将数据库中的deleted字段值改为了1
     *      但是：再次执行查询语句的时候，是查不到逻辑上已经被删除了的信息的
     *    查询的时候底层具体是怎样实现的，其实很简单，只需要在select语句最后追加一个条件，where deleted = 0 即可
     *    当查询到设置好的对应字段deleted = 0 的时候才将信息打印输出，当deleted不为0的时候就不将其数据输出
     *
     *
     *    一共有四个删除方法，分别是：
     *          1、deleteByID(id)： 直接按照id删除
     *          2、deleteByIdBatchIds(id的一个数组)：按照传入的id数组来删除，可以实现批量删除
     *          3、delete(wrapper):传入wrapper对象，利用wrapper对象封装条件，然后按照条件来进行删除
     *          4、deleteByMap(map):传入一个map集合，然后根据集合中添加的条件进行对应的删除
     *
     *
     *
     */
    @Test
    void delete(){
        mapper.deleteById(4);
    }

    /*----------------------------------CRUD操作----------------------------------*/

    @Test
    void selectListTest(){
        /**
         * 不加任何条件全部查询
         */
//        System.out.println(mapper.selectList(null));

        /**
         * selectList方法的另一种实现，使用wrapper接口，由于是接口没法直接使用，这里使用它的实现子类QueryWrapper，然后向其中添加检索条件
         *      eq 单条件查询
         */

        QueryWrapper wrapper = new QueryWrapper();

//        wrapper.eq("username","杨涵琪");//这里的条件使用的是eq，比较判断，判断并输出username为 亚索 的信息。注意：这里的key值必须为数据库中的字段名，否则会报错

        /**
         * allEq 多条件查询
         *      将多条 条件封装进map集合当中，然后再使用mapper进行查询即可
         */

//        Map<String,Object> map = new HashMap<>();
//        map.put("username","杨涵琪");
//        map.put("password","987");
//        wrapper.allEq(map);

        /**
         * 还有一些查询，不再一一实现，这里只记录它的用法
         *  wrapper.gt("id",2)  查询id值 >2 的信息
         *  wrapper.ne("username","亚索")  查询姓名不等于 亚索 的所有信息
         *  wrapper.ge("id",3)  查询id值 >=3 的所有信息
         */

        /**
         *    模糊查询
         */
//        wrapper.like("username","张");//查询出姓名中所有带张的信息

//        wrapper.likeLeft("username","天");//相当于 like '%天'   查询出所有以 "天" 结尾的信息

//        wrapper.likeRight("username","张");//相当于 '张%'  查询所有以 "张" 开头的信息

        //inSql
//        wrapper.inSql("id","select id from t_user where id < 6");//查询数据库中id值小于6的所有信息
//        wrapper.inSql("password","select password from t_user where password < 600");//在上一步结果中查询密码小于600



        System.out.println(mapper.selectList(wrapper));

        /**
         *  升降序查询。
         *      同时还可以追加额外的条件进行查询, 使用having()
         */
//        wrapper.orderByAsc("password");//按照密码的大小升序查询
//        wrapper.orderByAsc("password");//按照密码的大小降序查询
//        wrapper.having("id > 2");//在原有的基础上追加一个 id大于2 的额外条件进行查询
//        mapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void select(){
//        System.out.println(mapper.selectById(5));//根据 id 查询数据
//        System.out.println(mapper.selectBatchIds(Arrays.asList(1, 2, 3)));//根据多个 id 查询数据

//        Map<String,Object> map = new HashMap<>();
//        map.put("id",4);
//        //根据map集合进行查询。但是注意：这里的map集合只能进行等值查询，不能进行模糊查询，逻辑查询还是需要wrapper对象
//        mapper.selectByMap(map).forEach(System.out::println);

        /**
         *  Wrapper
         *      selectCount方法返回的是限定条件下的所有数据数量。
         */
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.gt("id",1);//输出id大于1的数据
//        System.out.println(mapper.selectCount(wrapper));

        //将查询到的结果全部封装到Map集合中，此时返回的数据不再是对象，而是一个key-value的集合
//        mapper.selectMaps(wrapper).forEach(System.out::println);
//        System.out.println("------------对比返回内容是对象的结果--------------");
//        mapper.selectList(wrapper).forEach(System.out::println);

        /**
         * 分页查询
         *    1、首先需要在配置文件中添加相关的配置
         *    2、直接使用Page类，泛型中指定返回的类型，然后还需指定好它的分页页码和每一页中所包含的数据数量
         *    3、直接调用mapper中的select.Page()方法，传入Page对象，并且指定好查询条件。这里的条件是使用Wrapper对象添加的
         */
        Page<User> page = new Page<>(1,2);//current：第一页  size：每一页中两条数据
        Page<User> result = mapper.selectPage(page, null);//查询条件为空，表示打印出全部查询到的数据
        System.out.println(result.getSize());//打印结果的长度
        System.out.println(result.getTotal());//打印结果的总数
        result.getRecords().forEach(System.out::println);//打印出指定分页中的数据
    }

    /**
     * 自己定义的多表关联查询的测试方法
     */
    @Test
    void select_Self(){
        mapper.productList(4).forEach(System.out::println);
    }



}