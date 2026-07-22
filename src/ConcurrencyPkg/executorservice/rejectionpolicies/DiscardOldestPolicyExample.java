package ConcurrencyPkg.executorservice.rejectionpolicies;

import java.util.concurrent.*;

/*
Behavior: Drops the oldest unhandled task at the head of the work queue
and attempts to re-submit the current task.

Best Used For: Real-time data feeds, UI state updates,
or stock market ticker updates where newer incoming data completely supersedes older queued data.

 */
public class DiscardOldestPolicyExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Processing Task " + taskId);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            });
        }

        // Task 2 gets dropped from the head of the queue to make space for Task 3
        executor.shutdown();
    }
}