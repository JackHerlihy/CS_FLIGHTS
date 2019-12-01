/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.controller;

import controller.BookingController;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shane
 */
public class BookingControllerTest {
    
    public BookingControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addListener method, of class BookingController.
     */
    @org.junit.Test
    public void testAddListener() {
        System.out.println("addListener");
        BookingController instance = new BookingController();
        instance.addListener();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class BookingController.
     */
    @org.junit.Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        BookingController instance = new BookingController();
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addLuggageCost method, of class BookingController.
     */
    @org.junit.Test
    public void testAddLuggageCost() {
        System.out.println("addLuggageCost");
        BookingController instance = new BookingController();
        instance.addLuggageCost();
       
        
    }
    
}
