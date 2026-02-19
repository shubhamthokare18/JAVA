// Parent class
class Vehicle {

    protected String brand = "Ford";
}

// Child class
class Car extends Vehicle {

    private final String model = "Mustang";

    public void printDetails() {
        System.out.println("Car Brand: " + brand + ", Car Model: " + model);
    }
}

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        car.printDetails();
    }
}
