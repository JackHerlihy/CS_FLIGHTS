package model;

public class Reservation {
    private String flightNumber;
    private String orderId;
    private String date;
    private String time;
    private String userEmail;
    private double price;

    public Reservation(String flightNumber, String date, String time, String userEmail, double price) {
        this.flightNumber = flightNumber;
        this.date = date;
        this.time = time;
        this.userEmail = userEmail;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return flightNumber + "," + date + "," + time + "," + userEmail + "," + price +"\n";
    }
    
}
