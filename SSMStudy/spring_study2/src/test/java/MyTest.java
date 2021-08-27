import com.yang.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 一般spring项目都会使用maven仓库
 *      注意！！使用Maven仓库时，spring所需要的配置文件，一定要写在resources中！！！
 */
public class MyTest {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        /*使用bean标签的id来获取对象*/
//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);
        /*根据bean的类型来获取对象
        *
        * 注意！！！当通过类型进行获取的时候，如果存在两个相同类型的对象，将无法完成获取工作
        * */
//        Person bean = context.getBean(Person.class);
//        System.out.println(bean);


        /**
         * 当需要从容器中获取对象的时候，最好要保留无参构造方法，因为底层的实现是反射
         *
         *
         *      Class clazz = Person.class;
         *      Object obj = clazz.newInstance();默认调用无参构造方法，此方法已经被弃用
         *      Object obj = clazz.getDeclaredConstructor().newInstance();
         */


/*        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);

        Person person3 = context.getBean("person3",Person.class);
        System.out.println(person3);

        Person person4 = context.getBean("person4", Person.class);
        System.out.println(person4);

        Person person5 = context.getBean("person5", Person.class);
        System.out.println(person5);*/


        //复杂属性得赋值测试
/*        Person person6 = context.getBean("person6", Person.class);
        System.out.println(person6);*/

        //具体分别是实现了哪种赋值方法，详看IOC.xml文件
/*        Person son = context.getBean("son", Person.class);
        System.out.println(son);

        Person person7 = context.getBean("person7", Person.class);
        System.out.println(person7);

        Person person8 = context.getBean("person8", Person.class);
        System.out.println(person8);

        Person myFactoryBean = context.getBean("myFactoryBean", Person.class);
        System.out.println(myFactoryBean);*/


        Person person9 = context.getBean("person9", Person.class);
        System.out.println(person9);
        //destroy 销毁方法的调用，context中没有，需要使用上级的ClassPathXMLApplicationContext转型之后再调用destroy方法
        ((ClassPathXmlApplicationContext)context).close();
    }
}
