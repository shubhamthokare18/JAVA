// Main.java
public class Main {

    public static void main(String[] args) {

        Os os = OperatingSystemFactory.getInstance(OSType.OPEN);
        os.spec();
    }
}