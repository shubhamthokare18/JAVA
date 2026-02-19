import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        try {

            for (int i = 1; i <= 10; i++) {

                int taskNumber = i;

                executor.submit(() -> {
                    System.out.println(
                            "Task " + taskNumber +
                                    " executed by: " + Thread.currentThread().getName()
                    );
                });
            }

        } finally {

            // Graceful shutdown
            executor.shutdown();

            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
