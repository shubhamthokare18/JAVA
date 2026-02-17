import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("ENTER DAY NUMBER (1-7): ");
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        switch (dayNumber) {
            case 1:
                System.out.println("MONDAY");
                break;
            case 2:
                System.out.println("TUESDAY");
                break;
            case 3:
                System.out.println("WEDNESDAY");
                break;
            case 4:
                System.out.println("THURSDAY");
                break;
            case 5:
                System.out.println("FRIDAY");
                break;
            case 6:
                System.out.println("SATURDAY");
                break;
            case 7:
                System.out.println("SUNDAY");
                break;
            default:
                System.out.println("INVALID DAY NUMBER");
        }
    }
}