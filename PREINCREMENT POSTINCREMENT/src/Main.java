//public class Main {
//    public static void main(String[] args) {
//        int number1 = 10;
//        System.out.println("PRE INCREMENT: " + ++number1);
//        int number2 = 10;
//        System.out.println("POST INCREMENT: " + number2++);
//    }
//}



public class Main {
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = ++number1;
        int number3 = number1++;
        System.out.println("NUMBER 1: " + number1);
        System.out.println("NUMBER 2: " + number2);
        System.out.println("NUMBER 3: " + number3);
    }
}