package controller;

import dao.IScheduleDao;
import dao.ScheduleDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Schedule;
import view.SearchFlightsView;
import view.SearchResults;


public class SearchResultsController implements ActionListener {
    
    private JTable departureJT, returnJT;
    private JLabel deptDateJL, retDateJL;
    private JButton selectBTN, backBTN;
    private SearchResults srv;
    private Schedule flight;
    private Schedule returnFlight;
    private List<Schedule> outbound;
    private List<Schedule> inbound;
    
    public SearchResultsController(Schedule flight, Schedule returnFlight){
    
        this.flight = flight;
        this.returnFlight = returnFlight;
        
        srv = SearchResults.getViewInstance();
        
        deptDateJL = srv.getDeptDate();
        retDateJL = srv.getRetDate();
        departureJT = srv.getDepResults();
        returnJT = srv.getRetResults();
        selectBTN = srv.getSelect();
        selectBTN.addActionListener(this);
        backBTN = srv.getBack();
        backBTN.addActionListener(this);
        
        fillComponents();
        
        srv.setVisible(true);

    }

    SearchResultsController() {
        srv = SearchResults.getViewInstance();
        srv.setVisible(true);
    }
    
    private void fillComponents(){
        
        IScheduleDao sDao = new ScheduleDao();
        
        outbound = sDao.getFlightSchedule(flight);
        inbound = sDao.getFlightSchedule(returnFlight);
        
        DefaultTableModel oModel = (DefaultTableModel)departureJT.getModel();
        DefaultTableModel iModel = (DefaultTableModel)returnJT.getModel();       
        
        deptDateJL.setText(outbound.get(1).getDate());
        oModel.setRowCount(0);
        outbound.stream().forEach((f) -> {
            oModel.addRow(f.toArray());
        });
        
        retDateJL.setText(inbound.get(1).getDate());
        iModel.setRowCount(0);
        inbound.stream().forEach((f) -> {
            iModel.addRow(f.toArray());
        }); 
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        Object source = e.getSource();
        
        if(source == backBTN){
            srv.setVisible(false);
            SearchFlightsController sfc = new SearchFlightsController();
        }
        
        else if(source == selectBTN){
            
            if(departureJT.getSelectionModel().isSelectionEmpty() || returnJT.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null,"Please select both a departure and return flight!");
;           }
            else {
                System.out.println(this.getClass() + " selected outbound: " + outbound.get(departureJT.getSelectedRow()).toString());
                System.out.println(this.getClass() + " selected inbound: " + inbound.get(returnJT.getSelectedRow()).toString());
                
                srv.setVisible(false);
                BookingController pc = new BookingController(outbound.get(departureJT.getSelectedRow()), inbound.get(returnJT.getSelectedRow()));
            }
            
        }
    }
    
}
