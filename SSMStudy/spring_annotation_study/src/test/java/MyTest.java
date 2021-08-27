import com.yang.controller.PersonController;
import com.yang.service.PersonService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  导入jnuit的jar包，单元测试，可以不需要main函数运行。
 *
 * 注意！给测试类起名字的时候千万不要定义成Test
 *  测试方法不可以有参数不可以有返回值
 */
public class MyTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonController personController = context.getBean("personController", PersonController.class);
        personController.save();

        //组件默认情况下都是单例模式，如果需要配置多例模式就需要在指定类中天健scope注解，并指定为多例模式（prototype）
//        PersonController personController1 = context.getBean("personController",PersonController.class);
//        System.out.println(personController1 == personController);

        //也可以获得其他组件的
//        PersonService personService = context.getBean("personService", PersonService.class);
//        System.out.println(personService);
    }
}
