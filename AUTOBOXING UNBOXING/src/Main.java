//public class Main {
//
//    public static void main(String[] args) {
//
//        // Autoboxing: Converting primitive int → Integer object
//        int primitiveValue = 10;
//        Integer boxedValue = primitiveValue;
//
//        System.out.println("Autoboxed Integer Object: " + boxedValue);
//
//        // Unboxing: Converting Integer object → primitive int
//        Integer wrapperValue = 20;
//        int unboxedValue = wrapperValue;
//
//        System.out.println("Unboxed Primitive Value: " + unboxedValue);
//    }
//}



public class Main {

    public static void main(String[] args) {

        int num1 = 10;          // Primitive type
        Integer num2 = 20;      // Wrapper class (Auto-boxing)

        // Auto-unboxing happens here (Integer → int)
        int sum = num1 + num2;

        System.out.println("Sum: " + sum);
    }
}