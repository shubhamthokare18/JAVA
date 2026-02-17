import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println("HI FROM THREAD");
        for (int i = 1; i <= 10; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }
}