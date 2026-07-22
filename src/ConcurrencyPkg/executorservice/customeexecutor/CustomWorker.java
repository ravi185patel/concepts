package ConcurrencyPkg.executorservice.customeexecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomWorker extends Thread {
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isShutdown;

    public CustomWorker(String name, BlockingQueue<Runnable> taskQueue, AtomicBoolean isShutdown) {
        super(name);
        this.taskQueue = taskQueue;
        this.isShutdown = isShutdown;
    }

    // Inside CustomWorker.java
    @Override
    public void run() {
        // Keep running while pool is active OR while tasks remain in the queue
        // 1. THIS run() method was launched via thread.start() ONCE when the worker was born.
        while (!isShutdown.get() || !taskQueue.isEmpty()) {
            try {
                // 2. The thread puts ITSELF to sleep waiting on the queue.
                // Thread WAITS here (blocked) if queue is empty until a new task arrives
                Runnable task = taskQueue.take();

                try {
                    // 3. The thread calls .run() directly on the task object!
                    //    Because the worker thread is ALREADY a running background thread,
                    //    calling task.run() executes the task's code INSIDE this worker thread.
                    task.run(); // Execute task on this worker thread
                } catch (RuntimeException e) {
                    // Prevent uncaught exceptions from killing the worker thread
                    System.err.printf("[%s] Task threw exception: %s%n", getName(), e.getMessage());
                }

            } catch (InterruptedException e) {
                // Triggered via worker.interrupt() during shutdown
                if (isShutdown.get() && taskQueue.isEmpty()) {
                    break; // Queue is empty and pool is shutting down; exit loop
                }
            }
        }
        System.out.println("[" + getName() + "] Worker stopped cleanly.");
    }
}