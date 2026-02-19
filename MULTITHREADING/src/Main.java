import java.util.Map;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        try {

            // ===== Manual Thread Creation =====
            Thread manualThread = new Thread(new TaskRunnable(), "MANUAL-THREAD");
            manualThread.start();


            // ===== ExecutorService (Thread Pool) =====
            ExecutorService executor = Executors.newFixedThreadPool(2);

            // Submit Runnable task
            executor.submit(new TaskRunnable());

            // Submit Callable task
            Future<Result> future = executor.submit(new TaskCallable());

            // Get result from Callable
            Result result = future.get();
            System.out.println("Callable completed successfully: " + result);


            // ===== Shutdown Executor =====
            shutdownExecutor(executor);


            // ===== Print JVM Thread Info =====
            printAllThreadsInfo();

        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void shutdownExecutor(ExecutorService executor) throws InterruptedException {

        executor.shutdown();

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }


    private static void printAllThreadsInfo() {

        System.out.println("\n===== JVM Threads Info =====");

        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();

        for (Thread thread : threadMap.keySet()) {
            System.out.println(thread.getName() + " -> " + thread.getState());
        }
    }
}


// ===== Runnable Implementation =====
class TaskRunnable implements Runnable {

    private static final int SLEEP_MS = 1000;

    @Override
    public void run() {

        for (int i = 1; i <= 5; i++) {

            try {
                Thread.sleep(SLEEP_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
                return;
            }

            System.out.println(
                    "Running: " + Thread.currentThread().getName()
                            + " | Count: " + i
            );
        }
    }
}


// ===== Callable Result Object =====
class Result {

    private final String message = "I am Callable Result Object";

    @Override
    public String toString() {
        return message;
    }
}


// ===== Callable Implementation =====
class TaskCallable implements Callable<Result> {

    @Override
    public Result call() throws Exception {

        Thread.sleep(500);

        System.out.println(
                "Callable executed by: " + Thread.currentThread().getName()
        );

        return new Result();
    }
}
