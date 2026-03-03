public interface Subject {
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notifySubscribers();
}