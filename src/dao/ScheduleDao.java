package dao;

import model.Schedule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao implements IScheduleDao{
    List<Schedule> f_schedule;
        
    @Override
    public List<Schedule> getFlightSchedule(Schedule flight){
        
        f_schedule = new ArrayList<>();
        
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/FlightSchedule.txt"))) {
            String str;

            while ((str = in.readLine()) != null) {
                if(!str.equals("")){
                    String[] lines = str.split(",");
                    boolean flightFull = false;
                    if(lines[1].equals(flight.getOrigin()) && lines[2].equals(flight.getDest())){

                        try (BufferedReader inFlights = new BufferedReader(new FileReader("Resources/Flights.txt"))) {
                            String strFlights;

                            while ((strFlights = inFlights.readLine()) != null) {
                                String[] linesFlight = strFlights.split(",");
                                System.out.println(lines[0] + " " + linesFlight[0] + " - " + linesFlight[1] + " " + flight.getDate() + " " + lines[3] + " " + linesFlight[2] + " - " + Integer.parseInt(linesFlight[3]));
                                System.out.println(lines[0].equals(linesFlight[0]) + " " + linesFlight[1].equals(flight.getDate()) + " " + lines[3].equals(linesFlight[2]) + " " + (Integer.parseInt(linesFlight[3]) == 0 ));
                                if(lines[0].equals(linesFlight[0]) && linesFlight[1].equals(flight.getDate()) && lines[3].equals(linesFlight[2]) && (Integer.parseInt(linesFlight[3]) == 0 )){
                                    flightFull = true;
                                }
                            }
                        }

                        if(!flightFull){
                            Schedule f = new Schedule(lines[0], lines[1], lines[2], lines[3], lines[4], flight.getDate(), Integer.parseInt(lines[5]), Double.parseDouble(lines[6]));
                                    f_schedule.add(f);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }    
        
        return f_schedule;
    }

}


