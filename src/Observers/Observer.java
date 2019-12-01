import Observers.FlightStatus;

public interface Observer
{
     void receiveUpdate(FlightStatus subject);
}