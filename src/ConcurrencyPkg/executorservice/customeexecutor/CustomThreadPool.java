package ConcurrencyPkg.executorservice.customeexecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<CustomWorker> workerThreads;
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    public CustomThreadPool(int poolSize, int queueCapacity) {
        this.taskQueue = new ArrayBlockingQueue<>(queueCapacity);
        this.workerThreads = new ArrayList<>(poolSize);

        // Pre-start worker threads and pass shared references
        for (int i = 0; i < poolSize; i++) {
            CustomWorker worker = new CustomWorker(
                    "CustomPool-Worker-" + (i + 1), 
                    this.taskQueue, 
                    this.isShutdown
            );
            workerThreads.add(worker);
            worker.start();
        }
    }

    /**
     * Submits a new task to the queue. Blocks if the queue is full.
     */
    public synchronized void execute(Runnable task) {
        if (isShutdown.get()) {
            throw new IllegalStateException("ThreadPool is shut down. Cannot accept new tasks.");
        }
        try {
            taskQueue.put(task); // Blocks caller if task queue is full
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task submission interrupted: " + e.getMessage());
        }
    }

    /**
     * Initiates a graceful shutdown of all worker threads.
     */
    public synchronized void shutdown() {
        if (isShutdown.getAndSet(true)) {
            return; // Already shut down
        }

        // Interrupt all worker threads stuck in taskQueue.take()
        for (CustomWorker worker : workerThreads) {
            worker.interrupt();
        }
    }
}