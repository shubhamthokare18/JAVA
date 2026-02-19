class Animal {

    public void animalSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    public void animalSound() {
        System.out.println("Dog barks");
    }

    public void dogBark() {
        System.out.println("Dog bark method called");
    }
}

public class Main {

    public static void main(String[] args) {

        // Upcasting (Parent reference → Child object)
        Animal animal = new Dog();

        // Runtime polymorphism
        animal.animalSound();

        // Safe downcasting using instanceof (pattern matching)
        if (animal instanceof Dog dog) {
            dog.dogBark();
        } else {
            System.out.println("Animal is not a Dog instance");
        }
    }
}
