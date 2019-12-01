package controller;

import dao.FlightDao;
import dao.IFlightDao;
import dao.IReservationDao;
import dao.ReservationDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Flight;
import model.Reservation;
import model.Schedule;
import model.User;
import view.PricingView;

public class BookingController implements ActionListener{
    private JComboBox<String> seat;
    private JSpinner luggageSPR;
    private JButton acceptBTN, cancelBTN;
    private JLabel priceLBL;
    private PricingView pv;
    private Schedule flight;
    private Schedule returnFlight;
    private int bags;
    private double price, bagsPrice;
    
    public BookingController(Schedule flight, Schedule returnFlight){
        this.flight = flight;
        this.returnFlight = returnFlight;
        
        pv = PricingView.getViewInstance();
        price = 0;
        price = flight.getPrice() + returnFlight.getPrice();
        bags = 0;
        
        luggageSPR = pv.getLuggage();    
        priceLBL = pv.getPrice();
        priceLBL.setText(Double.toString(price));
        acceptBTN = pv.getBook();
        acceptBTN.addActionListener(this);
        cancelBTN = pv.getCancel();
        cancelBTN.addActionListener(this);
        
        addListener();
        pv.setVisible(true);
    }
    
    public BookingController(){
        pv = PricingView.getViewInstance();
        pv.setVisible(true);
    }
    
    public void addListener(){
        luggageSPR.addChangeListener((ChangeEvent e) -> {
            addLuggageCost();
        });
    }
    
    public void addLuggageCost() {
        System.out.println("changes");
    
            switch((int)luggageSPR.getValue()){
                case 1:
                    bagsPrice = 50;
                    bags = 1;
                    break;
                case 2:
                    bagsPrice = 100;
                    bags = 2;
                    break;
                case 3:
                    bagsPrice = 150.0;
                    bags = 3;
                    break;
                default:
                    bagsPrice = 0.00;
                    break;
            }
            
            priceLBL.setText(Double.toString(price + bagsPrice));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == acceptBTN){
            IReservationDao rDao = new ReservationDao();
            
            rDao.addReservation(new Reservation(flight.getFlightNumber(), flight.getDate(), flight.getDepartureTime(), User.getLoggedIn().getEmail(), price));
            rDao.addReservation(new Reservation(returnFlight.getFlightNumber(), returnFlight.getDate(), returnFlight.getDepartureTime(), User.getLoggedIn().getEmail(), price));
        
            IFlightDao fDao = new FlightDao();
            fDao.addFlight(new Flight(flight.getFlightNumber(), flight.getDate(), flight.getDepartureTime(),(flight.getCapacity()-1), 1, "Scheduled"));
        
            MainController mc = new MainController();
                
            pv.setVisible(false);
        }
        else if (source == cancelBTN){
            pv.setVisible(false);
            SearchResultsController sfc = new SearchResultsController();
        }
    }
}
