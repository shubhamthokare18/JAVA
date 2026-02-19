public class Main {

    public static void main(String[] args) {

        // Autoboxing: Converting primitive int → Integer object
        int primitiveValue = 10;
        Integer boxedValue = primitiveValue;

        System.out.println("Autoboxed Integer Object: " + boxedValue);

        // Unboxing: Converting Integer object → primitive int
        Integer wrapperValue = 20;
        int unboxedValue = wrapperValue;

        System.out.println("Unboxed Primitive Value: " + unboxedValue);
    }
}
