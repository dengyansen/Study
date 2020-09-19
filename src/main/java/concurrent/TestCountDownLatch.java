package concurrent;

import java.util.concurrent.CountDownLatch;
//闭锁
public class TestCountDownLatch {
    public static void main(String[] args) throws Exception{
        int nThread = 3;
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(nThread);

        for(int i = 0;i<nThread;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    long threadId = Thread.currentThread().getId();
//                    System.out.println("thread"+thred+"run");
//                }
//            }).start();
            new Thread( () ->{
                long threadId = Thread.currentThread().getId();
                System.out.println("this thread is "+threadId+ "waiting to run...");
                try {
                    start.await();
                    System.out.println("this thread is "+threadId+"start  run...");
                    Thread.sleep(200);
                    System.out.println("this thread is "+threadId+"finish  run...");
                    end.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        long startTime = System.currentTimeMillis();
        start.countDown();
        end.await();
        System.out.println("everything is ok ,start run");
        System.out.println("every thread finish run ---------- ,total run time ="+ (System.currentTimeMillis() - startTime));
    }
}
