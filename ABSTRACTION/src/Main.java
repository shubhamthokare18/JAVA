abstract class Animal {
    abstract void animalSound();
    public void animalSleep() {
        System.out.println("ANIMAL SLEEP: ZZZZZZZZZZ");
    }
}
class Dog extends Animal {
    @Override
    public void animalSound() {
        System.out.println("DOG SOUND: BOW");
    }
}
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.animalSound();
        dog.animalSleep();
    }
}