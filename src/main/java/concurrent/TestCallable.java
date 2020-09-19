package concurrent;
import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService  executor = Executors.newFixedThreadPool(1);
        Task task = new Task() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call run");
                Thread.sleep(1000);
                System.out.println("call run finish");
                return 12;
            }
        };
        Future<Integer> result =  executor.submit(task);
        System.out.println(result);
//        executor.shutdown();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println("主线程在执行任务");

        System.out.println("task运行结果"+result.get());
        System.out.println("use time ="+(System.currentTimeMillis() - start));
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++)
                sum += i;
            return sum;
        }
    }
}
