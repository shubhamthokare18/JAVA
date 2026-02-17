class Animal {
    public void animalSound() {
        System.out.println("ANIMAL SOUND");
    }
}

class Dog extends Animal {
    @Override
    public void animalSound() {
        System.out.println("DOG SOUND");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal =new Animal();
        Dog dog = new Dog();
        animal.animalSound();
        dog.animalSound();
    }
}