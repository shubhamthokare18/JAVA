public class Main extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("NUMBER: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException interruptedException) {
            System.out.println("THREAD INTERRUPTED");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}