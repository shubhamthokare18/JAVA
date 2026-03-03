import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    private String title;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (Observer observer : observers) {
            observer.update(title);
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubscribers();
    }
}