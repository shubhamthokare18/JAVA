public class Main {

    public static void main(String[] args) {

        Channel channel = new Channel();

        Observer s1 = new Subscriber("AXAR");
        Observer s2 = new Subscriber("SHIKHAR");
        Observer s3 = new Subscriber("HARDIK");
        Observer s4 = new Subscriber("KEVIN");
        Observer s5 = new Subscriber("PARTHIV");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);
        channel.subscribe(s4);
        channel.subscribe(s5);

        channel.unSubscribe(s3);

        channel.upload("HOW TO LEARN CODING?");
    }
}