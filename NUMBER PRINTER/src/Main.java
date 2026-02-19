// Worker thread class
class NumberPrinterThread extends Thread {

    public NumberPrinterThread(String name) {
        super(name); // Set thread name
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i <= 10; i++) {

                System.out.println(
                        "Number: " + i +
                                " | Executed by: " + Thread.currentThread().getName()
                );

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt status
            System.out.println("Thread interrupted.");
        }
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        NumberPrinterThread thread =
                new NumberPrinterThread("NUMBER-THREAD");

        thread.start();
    }
}
