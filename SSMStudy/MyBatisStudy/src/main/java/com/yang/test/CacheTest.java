package com.yang.test;

import com.yang.entity.Account;
import com.yang.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 *  Mybatis缓存：减少java应用与数据库交互次数，从而提升程序运行效率（eg：在数据库中查询除了一个id=1的对象，那么就将其存到缓存当中，下次再查询id=1的对象时，直接取出）
 *      1、一级缓存 SqlSession级别，默认开启，并且不能关闭。
 *          操作数据库的时候需要创建SqlSession对象，在对象中有一个HashMap用于存储缓存数据，不同的SqlSession之间的缓存数据区域互不影响。
 *
 *          一级缓存的作用域是SqlSession范围的，当在同一个SqlSession中执行两次相同的SQL语句时，那么第一次的执行结果会保存到HashMap当中，
 *          第二次执行时就会直接从HashMap缓存中取出。
 *
 *          注意！！！如果SqlSession执行了DML操作（insert、update、delete），对数据进行了更改，那么Mybatis必须将缓存清空，以保证数据的准确性。
 *
 *      2、二级缓存 Mapper级别，默认关闭，可以开启（两种方式：1、mybatis自带的二级缓存。2、使用第三方的二级缓存）
 *          使用二级缓存时，多个SqlSession使用同一个Mapper的SQL语句操作数据库，得到的数据会存在二级缓存区，同样是使用HashMap进行数据存储，
 *          相较于一级缓存范围更广，多个SqlSession公用二级缓存，二级缓存时跨SqlSession的。
 *
 *          其作用域是 Mapper 的同一个 namespace，不同的 SqlSession两次执行相同的 namespace 下的 SQL 语句，参数也相等，
 *          则第一次执行成功之后会将数据保存到二级，缓存中，第二次可直接从二级缓存中取出数据。
 *
 *  其中，一级缓存是获取到之后即为生效，二级缓存则是在sqlSession关闭后才会生效。且sqlSession关闭之后一级缓存就会被清空
 *          查询缓存时的优先级问题：
 *              二级缓存>以及缓存>SQL语句
 */
public class CacheTest {
    public static void main(String[] args) {
        InputStream inputStream = CacheTest.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //一级缓存测试
        AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
        Account account = accountRepository.findById(2l);
        System.out.println(account);
        //再次使用同一个SqlSession进行查询相同的结果。此时两次findById()，我们使用setting配置可以看到其实只执行了一次sql语句对数据库的查询
//        Account account1 = accountRepository.findById(2l);
//        System.out.println(account1);
        sqlSession.close();
        //关闭上一个sqlSession，然后再重新新建一个SqlSession，重新创建对象，执行相同的操作，但是这时会执行两次sql语句，操作两次数据库
        sqlSession = sqlSessionFactory.openSession();
        AccountRepository accountRepository1 = sqlSession.getMapper(AccountRepository.class);
        Account account1 = accountRepository1.findById(2l);
        System.out.println(account1);

        /**
         * 在配置好二级缓存之后，这两个重新建立的SqlSession共用了AccountRepository.xml（Mapper.xml）那么它的查询就是只有一次对数据库的操作了
         *
         *  使用Mybatis自带的二级缓存：
         *      在config.xml中开启二级缓存，Mapper.xml中添加<cache></cache>标签，然后实体类需要实现序列化接口Serializable接口
         *
         *  使用第三方ehcache二级缓存的方法：
         *      需要先在pom.xml中导入依赖，然后配置ehcache.xml,在config.xml中开启二级缓存,在Mapper.xml中的cache标签
         *      添加相关配置。
         *
         */
    }
}
