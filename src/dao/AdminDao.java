
package dao;

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
import model.User;

public class AdminDao implements IAdminDao
{
    List<Admin> admins;
    
    @Override
    public List<Admin> getAdmins() 
    {
        File tempFile = new File("Resources/admins.txt");
        boolean exists = tempFile.exists();
        System.out.println("Reading admins from file " + exists);

        admins = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("Resources/admins.txt"))) 
        {
            String str;

            while ((str = in.readLine()) != null) {

                String[] lines = str.split(",");
                
                //System.out.println(lines[0] + "" + lines[1]);
                
                if(lines.length > 2)
                {
                    admins.add(new Admin(lines[1], lines[2]));
                    //System.out.println(admins);
                }
                
            }
            } catch (IOException e) {
            System.out.println("File Read Error");
        }
        return admins;
        }
    
    @Override
    public Boolean validateAdmin(Admin adminUser) 
    {
        getAdmins();
        
        System.out.println(adminUser.getEmail() + " " + adminUser.getPassword());
        Boolean validLogon = false;
        for(Admin curAdmin : admins){
            if(adminUser.getEmail().equals(curAdmin.getEmail()) && adminUser.getPassword().equals(curAdmin.getPassword()))
            {
                validLogon = true;
            }    
        }
        return validLogon;
        
    }

    @Override
    public boolean addAdmin(Admin newAdmin) {
        boolean exists = false;
        
        getAdmins();
        
        System.out.print(getAdmins().size() + " --");
        
        for(Admin admin : admins){
            System.out.print(admin.getEmail() + " -- " + newAdmin.getEmail());
            if(admin.getEmail().equals(newAdmin.getEmail())) {
               exists = true; 
            }
        }
        
        if(!exists){
            try (Writer output = new BufferedWriter(new FileWriter("Resources/admins.txt", true))) {
            
                String tempAddress = newAdmin.getAddress().replaceAll(",",".");
                tempAddress = tempAddress.replaceAll("\n",".");
                tempAddress = tempAddress.replaceAll("\\.+",".");

                String newAdminString = newAdmin.getFullname() + "," + newAdmin.getEmail() + "," + newAdmin.getPassword() + "\n";

                output.append(newAdminString);
                System.out.println("New admin added: " + newAdminString);
                    
            } catch (IOException ex) {
                System.out.println("Admin could not be addded");
            }
        }   
        
        return exists;
    }

    
}
