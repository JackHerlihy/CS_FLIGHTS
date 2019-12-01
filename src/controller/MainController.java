package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.User;
import view.MainView;

public class MainController implements ActionListener{
    
    private JTable bookings;
    private JButton edit, delete, add, logout;
    private JLabel message;
    private MainView mv;
    
    public MainController() {
        mv = MainView.getViewInstance();
        User.getLoggedIn();
        System.out.print(User.getLoggedIn().getEmail());
        bookings = mv.getBookings();
        
        edit = mv.getEdit();
        edit.addActionListener(this);
        
        delete = mv.getDelete();
        delete.addActionListener(this);
        
        add = mv.getAdd();
        add.addActionListener(this);
        
        getReservations();
                
        mv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();    
        
        if(source == add){
            mv.setVisible(false);
            
            SearchFlightsController sfc = new SearchFlightsController();
            sfc.initCompnents();
        }
    }
    
    private void getReservations() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
