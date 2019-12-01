package Observers;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    public void receiveUpdate(FlightStatus subject)
    {
        System.out.println("update received by [" + this.getClass().getSimpleName() + "]");
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

