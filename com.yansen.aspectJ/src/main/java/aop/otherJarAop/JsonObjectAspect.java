package aop.otherJarAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author jasen
 */
@Aspect
public class JsonObjectAspect {
    @Pointcut("execution(* java.lang.String.equals(..))")
    public void modelLayer() {
    }
    @Around("modelLayer()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("hello,before to json");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("hello,after to json");
        return obj;
    }
}
