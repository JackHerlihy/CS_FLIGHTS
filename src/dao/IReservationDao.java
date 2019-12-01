package dao;

import java.util.List;
import model.Reservation;

public interface IReservationDao {
    public boolean addReservation(Reservation res);
    public List<Reservation> getUserResevations();
}
