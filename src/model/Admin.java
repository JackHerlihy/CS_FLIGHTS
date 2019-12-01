package model;

import java.util.ArrayList;

public class Admin {
    private String fullname;
    private String email;
    private String password;
    private String address;
    private Boolean validLogin;
    private ArrayList<Admin> admin;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin(String fullname, String email, String password, String address) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getFullname() 
    {
        return fullname;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getPassword() 
    {
        return password;
    }

    public String getAddress() 
    {
        return address;
    }
     
}
