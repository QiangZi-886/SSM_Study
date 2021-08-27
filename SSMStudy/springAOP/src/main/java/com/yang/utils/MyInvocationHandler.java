package com.yang.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 所以AOP思想真正实现了代码的解耦合，真正的义务处理层（CalImpl）只需要实现纯粹的业务逻辑处理，日志的打印就交给代理对象来做
 *      事实上，在使用动态代理对象调用原有委托对象的方法时，底层使用的是invoke反射机制进行实现，
 *
 * 当前的MyInvocationHandler这个类并不是真正的代理类，而是一个用来动态创建代理类的类
 */
public class MyInvocationHandler implements InvocationHandler {
    //首先是：接受委托对象
    private Object object = null;

    //返回动态代理对象，因为不知道委托对象的类型，代理对象的类型也不确定，所以返回值写成Object类型。（bind:捆绑）
    public Object bind(Object object){
        this.object = object;
        /**
         *bind方法是传入一个委托对象返回一个代理对象：
         *  返回的这个对象是使用Proxy代理类的一个newProxyInstance(参数1，参数2，参数3)  得到一个代理实例方法
         *  这个方法的底层原理暂不深入，只需了解传入三个相应的参数，能够帮助我们创建一个所需要的代理类
         *      参数1：根据传入的委托对象，获取到委托对象的类加载器
         *      参数2：因为代理类中也必须能够实现委托类中原有的功能，在java中功能的体现就是接口。
         *          这里根据传入的类.getClass()获得到当前委托类的具体实现类，然后再通过.getInterface()得到类中所有的接口（就是功能）
         *      参数3：this指的是通过MyInvocationHandler创建的这个对象
         */
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"function args is:"+ Arrays.asList(args));
        /**
         * 第二行日志信息需要打印的是结果。那么结果就使用方法的反射机制，method.invoke(参数1，参数2)
         * 参数1：就是当前方法的委托对象
         * 参数2：就是方法所需要的参数
         *  method.invoke()可以理解成是方法调用对象，
         *  在代理对象吊用委托对象的一些add、sub、等方法的时候，其实就是调用的委托对象来完成的这些操作
         */
        Object result = method.invoke(this.object, args);
        System.out.println(method.getName()+"方法的结果是"+result);
        return result;
    }
}
