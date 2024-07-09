package jvm.loadclass;

import java.util.Random;

public class IntProducer {
    //用随机值来加载静态域赋值，如果被加载两次age应该会是不同的值
    public static int age = getRandom();

    public static int getRandom()
    {
        Random ran = new Random(System.nanoTime());
        int rand = ran.nextInt(10);
        System.out.println("IntProducer 被加载，产生随机数："+rand);
        return rand;
    }
}
