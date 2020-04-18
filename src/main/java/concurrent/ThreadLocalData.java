package concurrent;

import netscape.security.UserTarget;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalData {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        UserRequest innerClass = new UserRequest();
        for(int i = 1; i <= 2; i++) {
            new Thread(() -> {
                for(int j = 0; j < 4; j++) {
                    SessionHandler.setUser(Thread.currentThread().getName());
                    System.out.println(SessionHandler.get());
                }
//                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();
    }
    static class UserRequest implements Runnable{
        public void run() {
            SessionHandler.setUser(Thread.currentThread().getName());
        }
    }
    public static class SessionHandler {
        public static ThreadLocal<String> session = new ThreadLocal<String>();
        public static String get() {
            return session.get();
        }

        public static void setUser(String name) {
            session.set(name);
        }
    }
}
