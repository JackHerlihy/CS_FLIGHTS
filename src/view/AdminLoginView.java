/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;

public class AdminLoginView extends JFrame
{
    private static AdminLoginView AdminLoginViewInstance;
            
    private JPanel adminlogin;
    private JTextField email;
    private JPasswordField pword;
    private JButton submit, register;
    private JLabel headingLBL, emailLBL, pwordLBL;
    
    private AdminLoginView()
    {
        setSize(600,400);
        setTitle("Admin Login");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

                //controller = new
        headingLBL = new JLabel("Welcome, please login.");
        headingLBL.setHorizontalAlignment(JLabel.CENTER);
        headingLBL.setBounds(100,20,400,70);

        emailLBL = new JLabel("Email");
        emailLBL.setBounds(80, 70, 200, 30);

        pwordLBL = new JLabel("Password");
        pwordLBL.setBounds(80, 110, 200, 30);

        email = new JTextField(15);
        email.setBounds(300, 70, 200, 30);

        pword = new JPasswordField(15);
        pword.setBounds(300, 110, 200, 30);

        submit = new JButton("Submit");
        submit.setBounds(150, 160, 100, 30);


        adminlogin = new JPanel();
        adminlogin.setLayout(null);
        adminlogin.add(headingLBL);
        adminlogin.add(emailLBL);
        adminlogin.add(email);
        adminlogin.add(pwordLBL);
        adminlogin.add(pword);
        adminlogin.add(submit);
        add(adminlogin);

        //setVisible(true);

    }
    public static AdminLoginView getAdminLoginViewInstance()
    {
            if (null == AdminLoginViewInstance)
            {
                AdminLoginViewInstance = new AdminLoginView();
            }
            return AdminLoginViewInstance;
    }
    
    public JPasswordField getPword() {
                return pword;
            }

            public JButton getSubmit() {
                return submit;
            }

            public JButton getRegister() {
                return register;
            }
            

            public JLabel getHeadingLBL() {
                return headingLBL;
            }

            public JLabel getEmailLBL() {
                return emailLBL;
            }

            public JLabel getPwordLBL() {
                return pwordLBL;
            }

            public JTextField getEmail() {
                return email;
            }

          

            public void showErrorMessage(){
                JOptionPane.showMessageDialog(null, "Invalid email or password");

            }
}
