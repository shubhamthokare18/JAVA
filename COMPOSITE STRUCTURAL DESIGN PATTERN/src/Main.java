import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Component {
    void showPrice();
}

// Leaf Class
class Leaf implements Component {

    private String name;
    private int price;

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}

// Composite Class
class Composite implements Component {

    private String name;
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public void showPrice() {
        System.out.println("\n" + name);
        for (Component component : components) {
            component.showPrice();
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        // Leaf Objects
        Component hdd = new Leaf("HDD", 4000);
        Component ram = new Leaf("RAM", 3000);
        Component cpu = new Leaf("CPU", 9000);
        Component mouse = new Leaf("Mouse", 500);
        Component monitor = new Leaf("Monitor", 8000);

        // Composite Objects
        Composite computer = new Composite("Computer");
        Composite peripherals = new Composite("Peripherals");
        Composite cabinet = new Composite("Cabinet");
        Composite motherboard = new Composite("Motherboard");

        // Build Tree Structure
        motherboard.addComponent(ram);
        motherboard.addComponent(cpu);

        cabinet.addComponent(motherboard);
        cabinet.addComponent(hdd);

        peripherals.addComponent(mouse);
        peripherals.addComponent(monitor);

        computer.addComponent(cabinet);
        computer.addComponent(peripherals);

        // Show Prices
        computer.showPrice();
    }
}