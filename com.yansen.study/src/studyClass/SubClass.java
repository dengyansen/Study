package studyClass;

import java.util.concurrent.CountDownLatch;

public class SubClass extends ParentClass{
    public static void main(String[] args) throws InterruptedException {
        SubClass sub = new SubClass();
        System.out.println(sub.count);
        CountDownLatch latch = new CountDownLatch(10);
        CountDownLatch latch2 = new CountDownLatch(10);
        for(int i = 0;i<10;i++){
            new Thread(() ->{
                try {
                    latch.countDown();
                    System.out.println("wait ");
                    latch.await();
                    System.out.println("run thread= "+Thread.currentThread().getId()+"time ="+System.currentTimeMillis());
                    for(int j = 0;j < 10000; j++){
                        sub.count++;
                    }
                    latch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch2.await();
        System.out.println("最后数字="+sub.count);
    }
}
