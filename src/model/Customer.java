package model;

public class Customer extends User {
    
    public Customer(String email, String password) {
        super(email, password);
    }

    public Customer(String firstname, String email, String password, String address) {
        super(firstname, email, password, address);
    }

}
