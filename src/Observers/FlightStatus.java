package Observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


public class FlightStatus{

    private String status;
    private List<Observer> observers = new ArrayList<Observer>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        System.out.println("Changing the status to [" + status + "] ");
        this.status = status;
        this.notifyObservers();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        System.out.println("Notifying observers");
        observers.stream().forEach((observer) -> {
        });
    }
}