package controller;

import dao.IUserDao;
import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RegisterView;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.User;
   
class RegisterController implements ActionListener{
    
    private JPanel registerJP;
    private JTextField nameTF, emailTF;
    private JTextArea addressTA;
    private JPasswordField pwordPF;
    private JButton submitBTN, cancelBTN;
    private RegisterView rv;
    
    public RegisterController(){
        rv = RegisterView.getRegisterViewInstance();
         
        submitBTN = rv.getSubmit();
        submitBTN.addActionListener(this);
        
        cancelBTN = rv.getCancel();
        cancelBTN.addActionListener(this);
        
        nameTF = rv.getFullName();
        addressTA = rv.getAddress();
        emailTF = rv.getEmail();
        pwordPF = rv.getPword();
        addressTA = rv.getAddress();
        
        rv.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == submitBTN){
            IUserDao userDao = new UserDao();
            boolean exists = userDao.addUser(new User(nameTF.getText(), emailTF.getText(), String.valueOf(pwordPF.getPassword()),addressTA.getText()  ));
            
            if(!exists){
                rv.setVisible(false);
                
                MainController mc = new MainController();
            }
            else{
                JOptionPane.showMessageDialog(null, "User with that email already exists!!");
            }
        }
        
        else if (source == cancelBTN) {
            rv.setVisible(false);
            
            LoginController lc = new LoginController();
        }
    }
    
    
}
