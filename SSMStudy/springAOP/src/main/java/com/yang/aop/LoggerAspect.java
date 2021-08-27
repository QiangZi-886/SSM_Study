package com.yang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 利用spring封装好的框架来实现面向切面AOP的操作，底层依然是动态代理的一个模式
 *
 * Spring框架中不需要创建InvocationHandler，只需要创建一个切面对象，将所有的非业务代码在切面对象中完成即可，
 * Spring框架会自动根据切面类以及目标类生成一个代理对象
 *      注意：这里的切面类，在spring底层仍需要一个（bean）对象来进行对AOP的实现，
 *      所以原本是需要在xml配置文件中去配置当前这个类的具体对象的，但是现在可以使用注解的方式来简化bean对象的一个配置。
 */
@Aspect     //表示该类是一个切面类----------使其成为一个切面对象
@Component  //表示将该类的对象注入到IoC容器----------Component注解，交给IoC管理。实际上就是简化了在xml文件中配置bean对象的操作
public class LoggerAspect {

    /**
     *首先是在方法执行之前打印出一个输出方法名和参数的日志信息
     *  使用Before()注解的方式在方法开始执行之前 插入 日志信息，然后Before需要参数
     *      参数使用execution表达式来写      execution：切入点表达式，表示的是在某个包下的某些方法的执行
     *
     *
     *  execution(public int com.yang.utils.Impl.CalImpl.*())这里的*是方法名，指的是在指定类中的任意方法，后面的()指的是方法参数
     *  方法参数也可以用通配符来写，但是就不能写成*了，需要写成..
     *
     *  整个注解表达的意思就是切入的地方在CalImpl类中的任意方法，方法可以有任意参数，那么什么时候切入呢？
     *  就是在Before，在这些方法开始执行之前切入，
     */
    @Before(value = "execution(public int com.yang.utils.Impl.CalImpl.*(..))")
    public void before(JoinPoint joinPoint){    //JoinPoint 连接点。实际上就是讲目标方法的信息抽象成一个joinPoint并传进来
        //获取方法名,通过getSignature()方法可以获取到目标的方法等信息，再使用getName获得到方法名
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(name+" 方法的参数是："+args);

    }

    @After(value = "execution(public int com.yang.utils.Impl.CalImpl.*(..))")
    public void after(JoinPoint joinPoint){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行结束");
    }

    /**
     * 实际上是将结果作为returning="result"中的result，然后再映射到afterReturning()方法的Object object中去，最后再打印输出
     *
     * 注意！！returning的参数结果应该与Object的参数相同。即取为result就应该都为result，取abc就都为abc
     */
    @AfterReturning(value = "execution(public int com.yang.utils.Impl.CalImpl.*(..))",returning = "result")//指的是方法执行结束，return之后
    public void afterReturning(JoinPoint joinPoint,Object result){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法的返回结果是："+result);

    }

    @AfterThrowing(value = "execution(public int com.yang.utils.Impl.CalImpl.*(..))",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        //获取方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法抛出了异常："+exception);
    }


}
