package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Airport;

public class AirportDao implements IAirportDao{
    List<String> airports;
    
    @Override
    public List<String> getAirportsNames() {
        airports = new ArrayList<>();
        
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/airports.txt"))) {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
                airports.add(lines[1]);

                //System.out.println(lines[1]);
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return airports;
    }
    
    @Override
    public String getAirportCode(String name) {
        String code = "";
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/airports.txt"))) {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
       
                if(lines[1].equals(name)){
                    code = lines[0];
                }
                //System.out.println(code);
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        
        return code;
    }
}
