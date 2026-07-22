package ConcurrencyPkg.executorservice.rejectionpolicies;

import java.util.concurrent.*;

/*
DiscardPolicy

Behavior: Silently drops the rejected task without throwing any exception.

Best Used For: Non-critical background telemetry, metrics logging,
or event notifications where losing occasional data points is completely acceptable.

 */
public class DiscardPolicyExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.DiscardPolicy()
        );

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Executing task " + taskId);
            });
        }
        
        // Task 3 is silently dropped without throwing any exceptions
        executor.shutdown();
    }
}