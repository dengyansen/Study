package aop;

public aspect TestAspectJ {
    pointcut select() : execution(* aop.Person.say(..));

    after() : select(){
        System.out.printf(" jjjjjj");
    }

}
