package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame
{
    private JPanel main;
    private JTable bookings;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JButton edit, delete, add, logout;
    private JLabel message;
    private static MainView viewInstance;
    
    public static MainView getViewInstance()
    {
        if (viewInstance == null)
        {
            viewInstance = new MainView();
        }
        return viewInstance;
    }
    
    public MainView()
    {
        setSize(400,400);
        setTitle("Main Menu");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

        String [] headings = {"Flight", "Dep", "Dest", "Dept Time", "Arr Time"};
        model = new DefaultTableModel(headings, 1){

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        bookings = new JTable(model);
        bookings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(bookings);
        scroll.setBounds(30, 60, 350, 250);
            
        edit = new JButton("EDIT");
        edit.setBounds(40, 320, 100, 30);

        delete = new JButton("DELETE");
        delete.setBounds(150, 320, 100, 30);

        add = new JButton("ADD");
        add.setBounds(260, 320, 100, 30);

        logout = new JButton("LOGOUT");
        logout.setBounds(280, 10, 100, 30);

        message = new JLabel("Welcome, Please view your booking below");
        message.setBounds(30, 10, 300, 30);

        main = new JPanel(null);

        main.add(message);
        main.add(scroll);
        main.add(edit);
        main.add(delete);
        main.add(add);
        main.add(logout);

        add(main);
    }

    public JTable getBookings()
    {
        return bookings;
    }

    public JButton getEdit()
    {
        return edit;
    }

    public JButton getDelete()
    {
        return delete;
    }

    public JButton getAdd()
    {
        return add;
    }

    public JButton getLogout()
    {
        return logout;
    }
}