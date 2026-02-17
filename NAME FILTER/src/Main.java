import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nameArrayList = new ArrayList<>();
        nameArrayList.add("ALICE");
        nameArrayList.add("BHAVESH");
        nameArrayList.add("AMIT");
        nameArrayList.add("CHARLIE");
        nameArrayList.add("ANKIT");
        System.out.println("NAME ARRAY LIST: " + nameArrayList);
        System.out.println("NAME START WITH 'A':");
        for (String element : nameArrayList) {
            if (element.startsWith("A")) {
                System.out.println(element);
            }
        }
    }
}