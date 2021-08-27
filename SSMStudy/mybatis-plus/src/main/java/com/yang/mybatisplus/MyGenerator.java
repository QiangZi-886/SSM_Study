package com.yang.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 *  MybatisPlus的逆向工程所需的一个配置类
 *      MyBatisPlus 自动生成一个数据库中的 所有表格 对应的所有操作
 *      如果想要生成部分表，不想生成全部表格，只需要在 配置策略 中添加
 *                  strategyConfig.setInclude("你想要在库中选择的表名")  注意，配置策略的生成方法中的参数是可变的，也就是说，可以用选择生成
 *                  多张表格，不止生成一张表格
 *          根据数据表会自动生成 实体类、Mapper、Service、ServiceImpl、Controller
 */
public class MyGenerator {
    public static void main(String[] args) {
        //创建generator对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost/mybatis?useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("yang123456");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
            //设置逆向工程创建的文件存放位置，此方法是确定到工程目录下（mybatis-plus/src/main/java）
        String projectPath = System.getProperty("user.dir");
        //这里记录我的一次报错，控制台没有显示错误，但是文件没有生成，debug之后才发现路径的这个地方写成了"/",在debug窗口里应该写成"\\"
        globalConfig.setOutputDir(projectPath+"\\src\\main\\java");
        globalConfig.setOpen(true);//这个方法的意思是，逆向工程完成之后会自动打开文件夹，设置这个方法可以避免打开文件夹
        globalConfig.setAuthor("yang");
        globalConfig.setServiceName("%sService");//去掉自动生成Service层当中以‘I’开头的问题
        autoGenerator.setGlobalConfig(globalConfig);
        //包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.yang.mybatisplus");
        packageConfig.setModuleName("generatorTest");//模块名
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.Impl");
        autoGenerator.setPackageInfo(packageConfig);
        //配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//这个方法是指定数据库中的下划线自动转换为驼峰命名法
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();//执行
    }
}
