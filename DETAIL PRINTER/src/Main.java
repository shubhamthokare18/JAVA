class Person {

    private int id;
    private String name;

    // Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to print details
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class Main {

    public static void main(String[] args) {

        Person person = new Person(1, "SHUBHAM");

        person.printDetails();
    }
}
