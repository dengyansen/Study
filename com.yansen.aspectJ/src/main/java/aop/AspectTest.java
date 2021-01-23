package aop;

import aop.otherJarAop.User;

public class AspectTest {

    public static void main(String[] args) {
//        System.out.println("hello");
//        Person person = new Person();
//        person.say();
        System.out.println("test 第三方jar");
        User user = new User();
        user.setId(1);
        user.setName("yansen");

        String res = user.getName();
        System.out.println("99999".equals(res));

    }
}
