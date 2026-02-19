class Person {

    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // toString method (optional but recommended)
    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }
}

public class Main {

    public static void main(String[] args) {

        Person person = new Person("SHUBHAM");

        System.out.println("Person Name: " + person.getName());

        // Updating name using setter
        person.setName("RAHUL");

        System.out.println("Updated Person: " + person);
    }
}
