/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.dao;

import dao.ScheduleDao;
import java.util.List;
import model.Schedule;
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
public class ScheduleDaoTest {
    
    public ScheduleDaoTest() {
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
     * Test of getFlightSchedule method, of class ScheduleDao.
     */
    @org.junit.Test
    public void testGetFlightScheduleFullFlight() {
        System.out.println("getFlightSchedule");
        Schedule flight = new Schedule("NOC","ALC","29-Nov-2019");
        ScheduleDao instance = new ScheduleDao();
        //List<Schedule> expResult = null;
        List<Schedule> result = instance.getFlightSchedule(flight);
        assertEquals(1, result.size());
        
    }
    
    @org.junit.Test
    public void testGetFlightScheduleNotFullFlight() {
        System.out.println("getFlightSchedule");
        Schedule flight = new Schedule("NOC","ALC","03-Dec-2019");
        ScheduleDao instance = new ScheduleDao();
        //List<Schedule> expResult = null;
        List<Schedule> result = instance.getFlightSchedule(flight);
        assertEquals(2, result.size());
        
    }
    
}
