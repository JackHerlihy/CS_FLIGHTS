/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IAdminDao;
import dao.AdminDao;
import model.Admin;
import view.LoginView;
import view.AdminLoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Admin;

public class AdminLoginController implements ActionListener
{
    private JButton submitBTN;
    private JTextField email;
    private JPasswordField pword;
    private AdminLoginView av;
    
    public AdminLoginController()
    {
        av = AdminLoginView.getAdminLoginViewInstance();
        
        submitBTN = av.getSubmit();
        submitBTN.addActionListener(this);
        email = av.getEmail();
        pword = av.getPword();
        
        //addListeners();
        
        av.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == submitBTN) {
            IAdminDao adminDao = new AdminDao();
            Boolean validAdmin = adminDao.validateAdmin(new Admin(email.getText(),String.valueOf(pword.getPassword())));
            
            if(validAdmin){
                System.out.print("Admin ok");
                
                MainController mc = new MainController();
                
                av.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid email or password!");
            }
        }
}
}
