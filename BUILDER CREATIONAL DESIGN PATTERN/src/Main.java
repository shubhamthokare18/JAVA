public class Main {
    public static void main(String[] args) {

        Phone phone = new Phone.PhoneBuilder()
                .setOs("Android")
                .setRam(8)
                .setBattery(5000)
                .setProcessor("Snapdragon")
                .setScreenSize(6.5)
                .build();

        System.out.println(phone);
    }
}