package model;

public class Flight {
    String number;
    String date;
    String time;
    int passengers;
    int capacity;
    String status;

    public Flight(String number, String date, String time, int passengers, int capacity, String status) {
        this.number = number;
        this.date = date;
        this.time = time;
        this.passengers = passengers;
        this.capacity = capacity;
        this.status = status;
    }

    @Override
    public String toString() {
        return number + "," + date + "," + time + "," + passengers + "," + capacity + "," + status + "\n";
    }
    
    
}
