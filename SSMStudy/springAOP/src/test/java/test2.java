import com.yang.utils.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test2 {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        //获取代理对象
        Calculator proxy = context.getBean("calImpl", Calculator.class);
        proxy.add(1,1);
        proxy.sub(1,1);
        proxy.mul(1,1);
        proxy.div(1,1);
    }
}
