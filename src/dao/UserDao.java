package dao;

import model.User;
import model.Admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDao implements IUserDao 
{
    List<User> models;
    List<Admin> admins;

    @Override
    public List<User> getUsers() {
        File tempFile = new File("Resources/users.txt");
        boolean exists = tempFile.exists();
        System.out.println("Reading users from file " + exists);

        models = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/users.txt"))) {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
                
                if(lines.length > 2)
                {
                    models.add(new User(lines[1], lines[2]));
                }
                
            }
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return models;
    }
    
    @Override
    public Boolean validateUser(User loginUser) {
        getUsers();
        
        System.out.println(loginUser.getEmail() + " " + loginUser.getPassword());
        Boolean validLogon = false;
        for(User curUser : models){
            if(loginUser.getEmail().equals(curUser.getEmail()) && loginUser.getPassword().equals(curUser.getPassword()))
            {
                validLogon = true;
            }    
        }
        return validLogon;
        
    }

    @Override
    public boolean addUser(User newUser) {
        boolean exists = false;
        
        getUsers();
        
        System.out.print(getUsers().size() + " --");
        
        for(User user : models){
            System.out.print(user.getEmail() + " -- " + newUser.getEmail());
            if(user.getEmail().equals(newUser.getEmail())) {
               exists = true; 
            }
        }
        
        if(!exists){
            try (Writer output = new BufferedWriter(new FileWriter("Resources/users.txt", true))) {
          
                output.append(newUser.toString());
                
                System.out.println("New user added: " + newUser.toString());
                    
            } catch (IOException ex) {
                System.out.println("User could not be addded");
                return true;
                
            }
        }   
        
        return exists;
    }
    
    
    /*public List<Admin> getAdmins() {
        File tempFile = new File("Resources/admins.txt");
        boolean exists = tempFile.exists();
        System.out.println("Reading admins from file " + exists);

        admins = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/admins.txt"))) 
        {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
                
                if(lines.length > 2)
                {
                    admins.add((Admin) new User(lines[1], lines[2]));
                }
                
            }
            } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return admins;
        }
    
    @Override
    public Boolean validateAdmin(Admin adminUser) {
        getAdmins();
        
        System.out.println(adminUser.getEmail() + " " + adminUser.getPassword());
        Boolean validLogon = false;
        for(Admin curAdmin : admins){
            if(adminUser.getEmail().equals(curAdmin.getEmail()) && adminUser.getPassword().equals(adminUser.getPassword()))
            {
                validLogon = true;
            }    
        }
        return validLogon;
        
    }*/

    
}
