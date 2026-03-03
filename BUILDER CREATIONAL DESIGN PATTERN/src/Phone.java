public class Phone {

    private final String os;
    private final int ram;
    private final int battery;
    private final String processor;
    private final double screenSize;

    // Private constructor (called only by Builder)
    private Phone(PhoneBuilder builder) {
        this.os = builder.os;
        this.ram = builder.ram;
        this.battery = builder.battery;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
    }

    @Override
    public String toString() {
        return "PHONE {" +
                "OS='" + os + '\'' +
                ", RAM=" + ram +
                ", BATTERY=" + battery +
                ", PROCESSOR='" + processor + '\'' +
                ", SCREEN SIZE=" + screenSize +
                '}';
    }

    // Static Builder Class
    public static class PhoneBuilder {

        private String os;
        private int ram;
        private int battery;
        private String processor;
        private double screenSize;

        public PhoneBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setBattery(int battery) {
            this.battery = battery;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}