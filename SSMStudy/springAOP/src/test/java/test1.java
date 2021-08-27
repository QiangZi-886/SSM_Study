import com.yang.utils.Calculator;
import com.yang.utils.Impl.CalImpl;
import com.yang.utils.MyInvocationHandler;

public class test1 {
    public static void main(String[] args) {
        //手写打印日志信息
//        CalImpl cal = new CalImpl();
//        cal.add(1,1);
//        cal.sub(1,1);
//        cal.mul(1,1);
//        cal.div(1,1);

        //使用动态代理打印日志信息
        Calculator cal = new CalImpl();    //委托对象
        /**
         * 使用当前类得到一个代理对象，我们写的MyInvocationHandler这个类是用来创建一个代理对象的
         * 具体方式就是使用MyInvocationHandler的实现类调用bind()捆绑方法创建出一个代理类，
         * 代理类的类型就是委托类的类加载器类型
         */
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        //调用代理对象中的bind方法，获得一个代理对象proxy,并且使用代理对象完成委托对象的所有功能，当然这些功能都是从委托类中反射过来的
        Calculator proxy = (Calculator) myInvocationHandler.bind(cal);
        proxy.add(1,1);
        proxy.sub(2,1);
        proxy.mul(1,1);
        proxy.div(1,1);

    }
}
