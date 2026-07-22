package ConcurrencyPkg.executorservice;

import java.util.LinkedList;
import java.util.concurrent.*;

public class ExecuteServiceDemo {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor= (ThreadPoolExecutor) Executors.newSingleThreadExecutor();


//          Executors.newFixedThreadPool() ->blocking queue
//          Executors.newCachedThreadPool() -> sync queue
//          Executors.newScheduledThreadPool() -> DelayedWorkQueue
//          Executors.newSingleThreadExecutor() --> single thread + linked blocking queue

        /*
        Production Tip: In production systems (e.g., Spring/Microservices),
        it's generally recommended to construct a ThreadPoolExecutor directly rather than relying on Executors factory defaults.
        This allows you to set an explicit queue capacity (e.g., ArrayBlockingQueue(1000))
        and a explicit rejection handler (like CallerRunsPolicy) to avoid memory leak risks.
         */
//        threadPoolExecutor.shutdown();
//        LinkedList<Integer> ll=new LinkedList<Integer>();

        BlockingQueue<Runnable> blockigQueue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,blockigQueue);

        threadPoolExecutor1.execute(()->System.out.println(10));
        threadPoolExecutor1.execute(()->System.out.println(20));
        threadPoolExecutor1.execute(()->System.out.println(30));


        threadPoolExecutor1.shutdown();

    }
}
