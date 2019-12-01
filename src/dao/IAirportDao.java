package dao;

import java.util.List;
import model.Airport;

public interface IAirportDao {
    List<String> getAirportsNames();
    String getAirportCode(String name);
}
