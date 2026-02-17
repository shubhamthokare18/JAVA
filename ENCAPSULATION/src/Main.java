class Person {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
public class Main {
        public static void main(String[] args) {
        Person person = new Person();
        person.setName("SHUBHAM");
        System.out.println("PERSON NAME: " + person.getName());
    }
}