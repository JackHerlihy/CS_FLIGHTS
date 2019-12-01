package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.ScrollPane;

import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

public class SearchResults extends JFrame
{
    private JPanel results;
    private JTable departureResults, returnResults;
    private DefaultTableModel dModel, rModel;
    private JScrollPane scroll, scroll1;
    private JButton select, back;
    private JLabel message, deptDate, retDate;
    private static SearchResults viewInstance;
    
    public static SearchResults getViewInstance()
    {
        if (viewInstance == null)
        {
            viewInstance = new SearchResults();
        }
        return viewInstance;
   }
    
    public SearchResults() 
    {
        setSize(500,800);
        setTitle("Search Results");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

        message = new JLabel("Please select your departure and return flights", SwingConstants.CENTER);
        message.setBounds(0,0,500,90);
        
        deptDate = new JLabel("", SwingConstants.CENTER);
        deptDate.setBounds(0,70,500,20);
        
        String [] headings = {"Flight", "From", "To", "Dept Time", "Arr Time"};
        dModel = new DefaultTableModel(headings, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
        rModel = new DefaultTableModel(headings, 0){

            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        
        departureResults = new JTable(dModel);
        departureResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        departureResults.setRowHeight(35);

        scroll = new JScrollPane(departureResults);
        scroll.setBounds(65, 100, 370, 230);

        returnResults = new JTable(rModel);
        returnResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        returnResults.setRowHeight(35);
        
        retDate = new JLabel("", SwingConstants.CENTER);
        retDate.setBounds(0,350,500,20);
        
        scroll1 = new JScrollPane(returnResults);
        scroll1.setBounds(65, 380, 370, 230);
        
        DefaultTableCellRenderer dRenderer = (DefaultTableCellRenderer)
        departureResults.getDefaultRenderer(String.class);
        dRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer rRenderer = (DefaultTableCellRenderer)
        returnResults.getDefaultRenderer(String.class);
        rRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        select = new JButton("Select");
        select.setBounds(140, 630, 100, 30);

        back = new JButton("Back");
        back.setBounds(260, 630, 100, 30);

        results = new JPanel();
        results.setLayout(null);
        results.add(message);
        results.add(deptDate);
        results.add(retDate);
        results.add(scroll);
        results.add(scroll1);
        results.add(select);
        results.add(back);
        add(results);

    }

    public JButton getSelect() {
        return select;
    }

    public JButton getBack() {
        return back;
    }
    
    public JTable getDepResults()
    {
        return departureResults;
    }

    public JTable getRetResults()
    {
        return returnResults;
    }

    public JLabel getDeptDate() {
        return deptDate;
    }

    public JLabel getRetDate() {
        return retDate;
    }
    
    
}