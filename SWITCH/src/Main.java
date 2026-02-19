import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter day number (1-7): ");
            int dayNumber = scanner.nextInt();

            String dayName = getDayName(dayNumber);

            System.out.println(dayName);
        }
    }

    // Method to return day name
    public static String getDayName(int dayNumber) {

        return switch (dayNumber) {
            case 1 -> "MONDAY";
            case 2 -> "TUESDAY";
            case 3 -> "WEDNESDAY";
            case 4 -> "THURSDAY";
            case 5 -> "FRIDAY";
            case 6 -> "SATURDAY";
            case 7 -> "SUNDAY";
            default -> "INVALID DAY NUMBER";
        };
    }
}
