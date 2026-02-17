public class Main {
    protected String carBrand = "FORD";
}
class Car extends Main {
    private final String carModel = "MUSTANG";
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("CAR BRAND: " + car.carBrand + ", CAR MODEL: " + car.carModel);
    }
}