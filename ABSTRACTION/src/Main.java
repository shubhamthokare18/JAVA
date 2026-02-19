// Abstract class
abstract class Animal {

    // Abstract method (no body)
    abstract void animalSound();

    // Concrete method
    public void animalSleep() {
        System.out.println("Animal is sleeping... Zzzzz");
    }
}

// Child class (inherits Animal)
class Dog extends Animal {

    // Providing implementation for abstract method
    @Override
    void animalSound() {
        System.out.println("Dog barks: Bow Bow");
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        // Creating object of Dog
        Animal dog = new Dog();   // Upcasting (Best Practice)

        dog.animalSound();  // Calls Dog implementation
        dog.animalSleep();  // Calls Animal method
    }
}
