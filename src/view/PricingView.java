package view;

import javax.swing.*;
import java.awt.*;

public class PricingView extends JFrame
{
    private JPanel pricing;
    private JLabel messageLBL, luggageLBL, seatLBL, priceLBL, bookingPrice;
    private JComboBox<String> seat;
    private JSpinner luggage;
    private JButton book, cancel;
    private static PricingView viewInstance;
    
    public static PricingView getViewInstance()
    {
        if (viewInstance == null)
        {
            viewInstance = new PricingView();
        }
        return viewInstance;
    }
     
    public PricingView()
    {
        setSize(500,400);
        setTitle("Booking");
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(null);

        messageLBL = new JLabel("Select your luggage and seat to complete booking",  SwingConstants.CENTER);
        messageLBL.setBounds(0, 30, 500, 30);

        luggageLBL = new JLabel("Luggage");
        luggageLBL.setBounds(100, 70, 120, 30);

        seatLBL = new JLabel("Seat");
        seatLBL.setBounds(100, 110, 120, 30);

        priceLBL = new JLabel("Total price:");
        priceLBL.setBounds(100, 150, 120, 30);

        luggage = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
        luggage.setEditor(new JSpinner.DefaultEditor(luggage));
        luggage.setBounds(300, 70, 100, 30);

        seat = new JComboBox<String>();
        seat.setBounds(300, 110, 100, 30);

        bookingPrice = new JLabel("0");
        bookingPrice.setBounds(300, 150, 100, 30);

        book = new JButton("Book");
        book.setBounds(130, 230, 100, 30);

        cancel = new JButton("Cancel");
        cancel.setBounds(240, 230, 100, 30);

        pricing = new JPanel();
        pricing.setLayout(null);
        pricing.add(messageLBL);
        pricing.add(luggageLBL);
        pricing.add(luggage);
        pricing.add(seatLBL);
        pricing.add(seat);
        pricing.add(priceLBL);
        pricing.add(bookingPrice);
        pricing.add(book);
        pricing.add(cancel);
        add(pricing);

    }

    public JSpinner getLuggage()
    {
        return luggage;
    }

    public JComboBox<String> getSeat()
    {
        return seat;
    }

    public JLabel getPrice()
    {
        return bookingPrice;
    }

    public JButton getBook()
    {
        return book;
    }

    public JButton getCancel()
    {
        return cancel;
    }
}