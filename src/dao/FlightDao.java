package dao;

import java.util.List;
import model.Flight;

public class FlightDao implements IFlightDao{
    List<Flight> reservations;
    String file = "Resources/flights.txt";
    
    @Override
    public boolean addFlight(Flight f) {
        return true;
    }

    @Override
    public boolean updateFlight() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

}
