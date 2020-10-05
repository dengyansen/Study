package src.main.java.streamAndLambda;

import src.main.java.concurrent.Rests;

public class TestFuture {
    public static void main(String[] args) {
        System.out.println("11 main thread id ="+Thread.currentThread().getId());
        String aaa = Rests.exc(() -> {
            System.out.println("22 local Thread i ="+Thread.currentThread().getId());
            System.out.println("sleep 3000ms");
            Thread.sleep(3000);
            System.out.println("sleep over");
            return "this is task";
        }).toUpperCase();
        System.out.println(aaa);
        System.out.println("33 main thread id ="+Thread.currentThread().getId());
    }
}
