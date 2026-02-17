import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
            System.out.println("TASK: " + taskNumber + " EXECUTED BY: " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}