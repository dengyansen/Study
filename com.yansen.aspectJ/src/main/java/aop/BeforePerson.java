package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforePerson {
    /**
     * description: 利用execution表达式定义切点
     */
    @Pointcut("execution(* aop.Person.say(..))")
    public void pointCut(){
    }
    @Before(value = "pointCut()")
   public void beforePerson(){
        System.out.println("hello,before person");
    }
}
