public class Main {

    public static void main(String[] args) {

        Factory factory = new ShapeFactory();
        Shape shape = factory.create();
        shape.draw();
    }
}