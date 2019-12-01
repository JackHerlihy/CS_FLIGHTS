package view;


//  must import JDatePicker.jar from lib folder


import javax.swing.*;
import javafx.scene.control.DatePicker;
import java.util.*;
import java.awt.*;
import java.time.LocalDate;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;

public class SearchFlightsView extends JFrame
{
    private static SearchFlightsView viewInstance;
    private JPanel main;
    private JComboBox<String> origin, destination;
    private UtilDateModel model, model1;
    private Properties p, p1;
    private JDatePanelImpl datePanel, datePanel1;
    private JDatePickerImpl datePicker,datePicker1;
    private JLabel originLBL, destinationLBL, departureLBL, returnLBL;
    private JButton search, back;
    private JRadioButton noReturnBTN, returnBTN;
    
    public static SearchFlightsView getViewInstance()
    {
        if (viewInstance == null)
        {
            viewInstance = new SearchFlightsView();
        }
        return viewInstance;
   }
    
    public SearchFlightsView()
    {
        setSize(600,400);
        setTitle("Search Flights");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

        origin = new JComboBox<String>();   
        origin.setBounds(300, 70, 200, 30);

        destination = new JComboBox<String>();        
        destination.setBounds(300, 110, 200, 30);

        originLBL = new JLabel("Flight Origin");       
        originLBL.setBounds(80, 70, 200, 30);

        destinationLBL = new JLabel("Flight Destination");       
        destinationLBL.setBounds(80, 110, 200, 30);

        noReturnBTN = new JRadioButton("No return flight");
        noReturnBTN.setBounds(170, 150, 130,30);

        returnBTN = new JRadioButton("Return Flight");
        returnBTN.setBounds(320, 150, 100, 30);

        model = new UtilDateModel();
        model.setSelected(true);
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel,new DateComponentFormatter());
        datePicker.setBounds(300, 190, 150, 30);

        model1 = new UtilDateModel();
        model1.setSelected(true);
        p1 = new Properties();
        p1.put("text.today", "Today");
        p1.put("text.month", "Month");
        p1.put("text.year", "Year");
        datePanel1 = new JDatePanelImpl(model1, p1);
        datePicker1 = new JDatePickerImpl(datePanel1,new DateComponentFormatter());
        datePicker1.setBounds(300, 230, 150, 30);

        departureLBL = new JLabel("Departure Date");
        departureLBL.setBounds(80, 190, 200, 30);

        returnLBL = new JLabel("Return Date");
        returnLBL.setBounds(80, 230, 200, 30);

        search = new JButton("Search");
        search.setBounds(170, 270, 100, 30);

        back = new JButton("Back");
        back.setBounds(280, 270, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(noReturnBTN);
        bg.add(returnBTN);
        
        returnBTN.setSelected(true);

        main = new JPanel();
        main.setLayout(null);
        main.add(origin);
        main.add(destination);
        main.add(originLBL);
        main.add(destinationLBL);
        main.add(noReturnBTN);
        main.add(returnBTN);
        main.add(datePicker);
        main.add(departureLBL);
        main.add(datePicker1);
        main.add(returnLBL);
        main.add(search);
        main.add(back);
        add(main);
    }

    public JLabel getReturnLBL()
    {
        return returnLBL;
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public JDatePickerImpl getDatePicker1() {
        return datePicker1;
    }
    
    public JComboBox<String> getOrigin() {
        return origin;
    }

    public JComboBox<String> getDestination() {
        return destination;
    }

    public JDatePickerImpl getDeparture() {
        return datePicker;
    }

    public JDatePickerImpl getReturn()
    {
        return datePicker1;
    }

    public JButton getSearch() {
        return search;
    }

    public JRadioButton getNoReturnBTN()
    {
        return noReturnBTN;
    }

    public JRadioButton getReturnBTN()
    {
        return returnBTN;
    }

    public JButton getBack()
    {
        return back;
    }
}
