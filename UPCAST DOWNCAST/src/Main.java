class Animal {
    public void animalSound() {
        System.out.println("ANIMAL SOUND");
    }
}
class Dog extends Animal {
    public void dogBark() {
        System.out.println("DOG BARK");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            animal.animalSound();
            ((Dog) animal).dogBark();
            dog.animalSound();
            dog.dogBark();
        } else {
            System.out.println("ANIMAL IS NOT A DOG INSTANCE");
        }
    }
}