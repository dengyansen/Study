package concurrent;

public  class TestLockObjectInstance {
    public static void main(String[] args) throws InterruptedException {
        LockObject object = new LockObject();
        ThreadA a = new ThreadA(object);
        ThreadB b = new ThreadB(object);
        a.start();
        b.start();
        //等待AB执行完
        a.join();
        b.join();
        System.out.println(object.a);
    }
    public static class ThreadA extends Thread {
        LockObject o = null;
        ThreadA(LockObject o){
            this.o = o;
        }
        @Override
        public void run() {
            int i = 0;
            for(;i<100000000;i++){
                o.test4();
            }
        }
    }
    public static class ThreadB extends Thread {
        LockObject o = null;
        ThreadB(LockObject o){
            this.o = o;
        }
        @Override
        public void run() {
            int i = 0;
            for(;i<100000000;i++){
                o.test5();
            }
            System.out.println("ThreadB i=-------"+i);
        }
    }
    public static class LockObject {
        public  Integer a = 0;
        synchronized void  test4(){
            ++a;
        }
        synchronized void  test5(){
            ++a;
        }
    }
}
