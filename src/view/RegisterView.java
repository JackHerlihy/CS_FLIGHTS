/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame
{
    private static RegisterView registerViewInstance;

    private JPanel register;
    private JTextField name, email;
    private JTextArea address;
    private JPasswordField pword;
    private JButton submit, cancel;
    private JLabel nameLBL, emailLBL, addressLBL, pwordLBL;

    private RegisterView()
    {
        setSize(600,500);
        setTitle("Register");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

        name = new JTextField(30);
        name.setBounds(300, 70, 200, 30);
        
        email = new JTextField();
        email.setBounds(300, 110, 200, 30);

        address = new JTextArea();
        address.setBounds(300, 150, 200, 120);

        pword = new JPasswordField(15);
        pword.setBounds(300, 280, 200, 30);

        submit = new JButton("Submit");
        submit.setBounds(150, 320, 100, 30);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,320,100,30);

        nameLBL = new JLabel("Name");
        nameLBL.setBounds(80, 70, 200, 30);

        emailLBL = new JLabel("Email");
        emailLBL.setBounds(80, 110, 200, 30);

        addressLBL = new JLabel("Address");
        addressLBL.setBounds(80, 150, 200, 30); 

        pwordLBL = new JLabel("Password");
        pwordLBL.setBounds(80, 280, 200, 30);

        register = new JPanel();
        register.setLayout(null);
        register.add(nameLBL);
        register.add(name);
        register.add(emailLBL);  
        register.add(email);
        register.add(addressLBL);
        register.add(address);
        register.add(pwordLBL);
        register.add(pword);
        register.add(submit);
        register.add(cancel);
        
        add(register);
    
    }

    public static RegisterView getRegisterViewInstance()
    {
        if (null == registerViewInstance)
        {
            registerViewInstance = new RegisterView();
        }
        return registerViewInstance;
    }

    public JTextField getFullName() {
        return name;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextArea getAddress() {
        return address;
    }

    public JPasswordField getPword() {
        return pword;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getCancel() {
        return cancel;
    }

    
}