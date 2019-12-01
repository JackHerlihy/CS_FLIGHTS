package view;

import javax.swing.*;
import java.awt.*;


public class LoginView extends JFrame
{
            private static LoginView LoginViewInstance;
            
            private JPanel login;
            private JTextField email;
            private JPasswordField pword;
            private JButton submit, register, adminlogin;
            private JLabel headingLBL, emailLBL, pwordLBL;

           // LoginController controller;
            //test

            private LoginView()
            {
                setSize(600,400);
                setTitle("Login");
                setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                setResizable(false);
                setLocationRelativeTo(null);

                //controller = new
                headingLBL = new JLabel("Welcome, please login or register a new account.");
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


                register = new JButton("Register");
                register.setBounds(320,160,100,30);
                
                adminlogin = new JButton("Admin Login");
                adminlogin.setBounds(225,200,130,30);

                login = new JPanel();
                login.setLayout(null);
                login.add(headingLBL);
                login.add(emailLBL);
                login.add(email);
                login.add(pwordLBL);
                login.add(pword);
                login.add(submit);
                login.add(register);
                login.add(adminlogin);
                add(login);

                //setVisible(true);

            }
            
            public static LoginView getLoginViewInstance()
            {
                if (null == LoginViewInstance)
                {
                    LoginViewInstance = new LoginView();
                }
                return LoginViewInstance;
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
            
            public JButton getAdminLogin()
            {
                return adminlogin;
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

            public JPanel getLogin() {
                return login;
            }

            public void showErrorMessage(){
                JOptionPane.showMessageDialog(null, "Invalid email or password");

            }
        }
 