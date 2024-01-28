package ConcurrencyPkg.executorservice;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor= (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        threadPoolExecutor.shutdown();
        LinkedList<Integer> ll=new LinkedList<Integer>();

    }
}
