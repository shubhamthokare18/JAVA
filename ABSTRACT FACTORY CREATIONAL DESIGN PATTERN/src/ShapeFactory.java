public class ShapeFactory implements Factory {

    @Override
    public Shape create() {

        return new Circle();
    }
}
