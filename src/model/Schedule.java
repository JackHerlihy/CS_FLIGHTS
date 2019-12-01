package model;

import java.util.ArrayList;

public class Schedule{
    private String flightNum;
    private String origin;
    private String dest;
    private String deptTime;
    private String arrTime;
    private String date;
    private int capacity;
    private double price;
    private ArrayList<Schedule> f_Schedule;

public Schedule(String flightNum, String originAirport, String destAirport, String deptTime, String arrTime, String date, int capacity, double price){
        this.flightNum = flightNum;
        this.origin = originAirport;
        this.dest = destAirport;
        this.deptTime = deptTime;
        this.arrTime = arrTime;
        this.date = date;
        this.capacity = capacity;
        this.price = price;        
    }

    public Schedule(String origin, String dest, String date) {
        this.origin = origin;
        this.dest = dest;
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }

    public String getDate() {
        return date;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }
    
    public String getFlightNumber() {
        return flightNum;
    }

    public String getDepartureTime() {
        return deptTime;
    }

    public String getArrivalTime() {
        return arrTime;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public double getPrice() {
        return price;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return "Schedule{" + "flightNum=" + flightNum + ", origin=" + origin + ", dest=" + dest + ", deptTime=" + deptTime + ", arrTime=" + arrTime + ", date=" + date + ", f_Schedule=" + f_Schedule + '}';
    }
    public String [] toArray() {
        return new String [] {flightNum, origin, dest, deptTime, arrTime };
    }
            
}

