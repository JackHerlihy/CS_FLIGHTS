package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import model.Reservation;
import model.User;

public class ReservationDao implements IReservationDao {
    List<Reservation> reservations;
    String file = "Resources/reservations.txt";
    
    @Override
    public boolean addReservation(Reservation res){
        
        try (Writer output = new BufferedWriter(new FileWriter(file, true))) {
          
            output.append(res.toString());

            System.out.println("New reservation added: " + res.toString());
                    
        } catch (IOException ex) {
            System.out.println("Reservation could not be addded");
            return false;        
        } 
        
        return true;
    }
    
    @Override
    public List<Reservation> getUserResevations(){
        
        System.out.println("Reading reservations from file for: " + User.getLoggedIn().getEmail());

        reservations = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
                
                if(lines.length > 4 && lines[3].equals(User.getLoggedIn().getEmail()))
                {
                    reservations.add(new Reservation(lines[0], lines[1], lines[2], lines[3], Float.parseFloat(lines[4])));
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        return reservations;
    }

}
