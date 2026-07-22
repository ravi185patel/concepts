package ConcurrencyPkg.executorservice.rejectionpolicies;

import java.util.concurrent.*;

/*
CallerRunsPolicy
Behavior: The pool does not reject the task or throw an exception.
Instead, the caller thread (e.g., main) executes the task itself.

Best Used For: Backpressure management and rate-limiting.
Executing tasks on the caller thread slows down incoming submissions,
giving worker threads time to clear the queue.

Main Thread                                 ThreadPoolExecutor
-----------                                 ------------------
1. executor.execute(task) ---------> Is core thread available? (No)
                                     Is task queue full?       (Yes)
                                     Is max pool size reached? (Yes)
                                             |
                                             v
                                   Trigger Rejection Handler
                                             |
                                             v
2. Executes r.run() <--------------- CallerRunsPolicy.rejectedExecution()
   (Main thread pauses here
    and runs task.run() itself)
                                             |
3. Resumes next line of code <---------------+

Java
 */
public class CallerRunsPolicyExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " running on thread: " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            });
        }
        executor.shutdown();

        /*
       1) main Thread Submits Task: The main thread enters ThreadPoolExecutor.execute(task).
       2) Pool Reaches Full Capacity: All core threads are busy, the workQueue is completely full,
        and max threads have been spawned.
       3) Rejection Triggered: ThreadPoolExecutor
        calls rejectedExecutionHandler.rejectedExecution(task, this) synchronously
        on the current thread (main).
       4) CallerRunsPolicy Invoked: Inside rejectedExecution(),
         CallerRunsPolicy checks if the pool is shut down. If it is active,
         it calls task.run() directly.
       5) Main Thread Executes Task: Because .run() is invoked in-line,
         the main thread is forced to execute the task's logic right then and there.
       6) Main Thread Resumes: Once task.run() finishes, control returns back to main,
         allowing it to move on to the next line of code.
         */
    }
}