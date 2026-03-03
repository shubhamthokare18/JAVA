public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String title) {
        System.out.println("HEY " + name + " VIDEO UPLOADED: " + title);
    }
}