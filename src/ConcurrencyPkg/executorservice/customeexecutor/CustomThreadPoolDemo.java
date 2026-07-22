package ConcurrencyPkg.executorservice.customeexecutor;

public class CustomThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        // Initialize pool with 3 worker threads and a queue capacity of 5
        CustomThreadPool threadPool = new CustomThreadPool(3, 5);

        // 1. Submit normal tasks
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + taskId);
                try {
                    Thread.sleep(200); // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 2. Submit a failing task (Worker should catch error and survive)
        threadPool.execute(() -> {
            throw new RuntimeException("Simulated error inside custom worker!");
        });

        // 3. Submit post-error task to prove worker thread is still alive
        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " executing recovery task.");
        });

        // Allow tasks to complete
        Thread.sleep(1500);

        // 4. Initiate graceful pool shutdown
        System.out.println("\n--- Initiating Pool Shutdown ---");
        threadPool.shutdown();
    }
}
