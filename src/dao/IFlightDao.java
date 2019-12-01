package dao;

import model.Flight;

public interface IFlightDao {
    public boolean addFlight(Flight f);
    public boolean updateFlight();
}
