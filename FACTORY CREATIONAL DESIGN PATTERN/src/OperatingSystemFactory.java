// OperatingSystemFactory.java
public class OperatingSystemFactory {

    public static Os getInstance(OSType type) {

        switch (type) {
            case OPEN:
                return new Android();

            case CLOSE:
                return new Ios();

            case WINDOWS:
                return new Windows();

            default:
                throw new IllegalArgumentException("Invalid OS Type");
        }
    }
}