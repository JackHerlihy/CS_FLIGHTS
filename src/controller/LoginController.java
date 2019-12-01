package controller;

import dao.IUserDao;
import dao.UserDao;
import view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.User;
import view.RegisterView;

public class LoginController implements ActionListener
{
    private JButton submitBTN;
    private JButton registerBTN;
    private JButton adminLoginBTN;
    private JTextField email;
    private JPasswordField pword;
    private LoginView lv;

    public LoginController(){
        lv = LoginView.getLoginViewInstance();
        
        submitBTN = lv.getSubmit();
        submitBTN.addActionListener(this);
        registerBTN = lv.getRegister();
        registerBTN.addActionListener(this);
        adminLoginBTN = lv.getAdminLogin();
        adminLoginBTN.addActionListener(this);
        email = lv.getEmail();
        pword = lv.getPword();
        
        lv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == submitBTN) {
            IUserDao userDao = new UserDao();
            Boolean validUser = userDao.validateUser(new User(email.getText(),String.valueOf(pword.getPassword())));
            User.setLoggedIn(new User(email.getText(),String.valueOf(pword.getPassword())));
            if(validUser){
                System.out.print("User ok");
                
                MainController mc = new MainController();
                
                lv.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid email or password!");
            }
        }
        
        else if(source == registerBTN){
            System.out.println("Register");
            
            lv.setVisible(false);
            RegisterController rc = new RegisterController();
        }
        
        else if(source == adminLoginBTN) {
           System.out.print("admin login");
            lv.setVisible(false);
            
            AdminLoginController ac = new AdminLoginController(); 
        }
    }
}