package controller;

import dao.AirportDao;
import dao.IAirportDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import model.Airport;
import model.Schedule;
import org.jdatepicker.impl.JDatePickerImpl;

import view.MainView;
import view.SearchFlightsView;

public class SearchFlightsController {
    
    //private JPanel searchFlightJP;
    private JComboBox<String> originCB, destinationCB;
    private JDatePickerImpl departureDP, returnDP;
    private SearchFlightsView sfv;
    private MainView mv;
    private JButton searchBTN, backBTN;
    private JRadioButton noReturnBTN, returnBTN;
    private JDatePickerImpl datePicker1;
    private JLabel radioNoReturn;
    
    public SearchFlightsController(){
        sfv = SearchFlightsView.getViewInstance();
        sfv.setVisible(true);
    }
    
    public void initCompnents(){
        originCB = sfv.getOrigin();
        destinationCB = sfv.getDestination();
        departureDP = sfv.getDatePicker();
        returnDP = sfv.getDatePicker1();
        searchBTN = sfv.getSearch();
        backBTN = sfv.getBack();
        noReturnBTN = sfv.getNoReturnBTN();
        returnBTN = sfv.getReturnBTN();
        datePicker1 = sfv.getDatePicker1();
        radioNoReturn = sfv.getReturnLBL();
        
        fillComboBoxes();
        addListeners();
    }
    
    public void fillComboBoxes() {
        IAirportDao airportDao = new AirportDao();
        List<String> airports = new ArrayList<>();
        
        airports = airportDao.getAirportsNames();
        
        String[] airportNamesArray = airports.toArray(new String[airports.size()]);
        
        originCB.setModel(new DefaultComboBoxModel<>(airportNamesArray));
        destinationCB.setModel(new DefaultComboBoxModel<>(airportNamesArray));
    }
    
    public void addListeners()
    {
        searchBTN.addActionListener((ActionEvent e) -> {                   
            String origin = originCB.getSelectedItem().toString(); 
            String dest = destinationCB.getSelectedItem().toString();            
            String date = departureDP.getJFormattedTextField().getText();
            String returnDate = returnDP.getJFormattedTextField().getText();
            
            IAirportDao aDao = new AirportDao();
            
            String oCode = aDao.getAirportCode(origin);
            String dCode = aDao.getAirportCode(dest);
            
            System.out.println(oCode + " - " + dCode);
            Schedule flight = new Schedule(oCode, dCode, date);
            Schedule returnFlight = new Schedule(dCode, oCode, returnDate);
            try{
            SearchResultsController src = new SearchResultsController(flight, returnFlight);
            sfv.setVisible(false);
            }
            catch(IndexOutOfBoundsException er)
            {
            JOptionPane.showMessageDialog(sfv, "No Flights Available", "Error", JOptionPane.ERROR_MESSAGE);
            //srv.setVisible(false);
            //sfv = SearchFlightsView.getViewInstance();
           sfv.setVisible(true);
            }
            
        });

        backBTN.addActionListener((ActionEvent e) -> {
            mv = MainView.getViewInstance();
            mv.setVisible(true);
            sfv.setVisible(false);
        }); 
        
        noReturnBTN.addActionListener((ActionEvent e) -> { 
                     datePicker1.setVisible(false);
                     radioNoReturn.setText("");
        });   
        returnBTN.addActionListener((ActionEvent e) -> { 
                     datePicker1.setVisible(true);
                     radioNoReturn.setText("Return Date");
        });
    }
}
