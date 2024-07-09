package classStudy;

import java.math.BigDecimal;
import java.util.List;

public class TestMethodChange {
    static class Person {
        int age;
        String name;
    }

    public static void main(String[] args) {
        System.out.println("807".charAt(1));
        char ss = "807".charAt(1);
        System.out.println(String.valueOf(ss));

//        9 9999 9999 1;



        Person person = new Person();
        person.age = 10;
        person.name = "ys";
        changePer(person);

    }

    private static Person changePer(Person person) {
        Person temp = person;
        temp.name = "xs";
        person = new Person();
        return person;
    }
    public int getNumByList(List<Integer> list) {
        int num = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            int temp =  list.get(i) * (int)Math.pow(10, i);
            num += temp;
        }
        return num;
    }
}
