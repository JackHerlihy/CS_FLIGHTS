/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.dao;

import dao.AirportDao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AirportDaoTest {
    
    public AirportDaoTest() {
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
     * Test of getAirportsNames method, of class AirportDao.
     */
    @org.junit.Test
    public void testGetAirportsNames() {
        System.out.println("getAirportsNames");
        AirportDao instance = new AirportDao();
        //List<String> expResult = null;
        List<String> result = instance.getAirportsNames();
        assertEquals(8, result.size());
        
    }

    /**
     * Test of getAirportCode method, of class AirportDao.
     */
    @org.junit.Test
    public void testGetAirportCode() {
        System.out.println("getAirportCode");
        String name = "Knock";
        AirportDao instance = new AirportDao();
        String expResult = "NOC";
        String result = instance.getAirportCode(name);
        assertEquals(expResult, result);
    }
    
}
