package ConcurrencyPkg.executorservice.rejectionpolicies;

import java.util.concurrent.*;

/*
AbortPolicy (Default Policy)

Behavior: Throws a RejectedExecutionException immediately when the work queue is full
and no additional non-core threads can be created.

Best Used For: Critical transactional systems where failing fast is required
to prevent data inconsistency or system degradation under load.
 */
public class AbortPolicyExample {
    public static void main(String[] args) {
        // Pool capacity: Core = 1, Max = 1, Queue = 1 (Max capacity = 2 tasks)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.AbortPolicy() // Explicit default
        );

        try {
            for (int i = 1; i <= 3; i++) {
                final int taskId = i;
                executor.execute(() -> {
                    try { Thread.sleep(1000); } catch (InterruptedException e) {}
                    System.out.println("Executed Task " + taskId);
                });
            }
        } catch (RejectedExecutionException e) {
            System.err.println("Task rejected via AbortPolicy: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}