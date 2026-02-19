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
}

public class Main {

    public static void main(String[] args) {

        // Parent object
        Animal animal = new Animal();
        animal.animalSound();

        // Child object
        Dog dog = new Dog();
        dog.animalSound();

        // Runtime Polymorphism (Parent reference → Child object)
        Animal animalRef = new Dog();
        animalRef.animalSound();
    }
}
