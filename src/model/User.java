package model;

import java.util.ArrayList;

public class User {
    private String fullname;
    private String email;
    private String password;
    private String address;
    private Boolean validLogin;
    private ArrayList<User> models;
    public static User loggedIn;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String fullname, String email, String password, String address) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.address = formatAddress(address);
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
    
    private String formatAddress(String address){
        String formattedAddress = address.replaceAll(",",".");
        formattedAddress = formattedAddress.replaceAll("\n",".");
        formattedAddress = formattedAddress.replaceAll("\\.+",".");
        
        return formattedAddress;
    }

    @Override
    public String toString() {
        return fullname + "," + email + "," + password + "," + address + "\n";
    }

    public static void setLoggedIn(User loggedIn) {
        User.loggedIn = loggedIn;
    }

    public static User getLoggedIn() {
        return loggedIn;
    }
    
}
