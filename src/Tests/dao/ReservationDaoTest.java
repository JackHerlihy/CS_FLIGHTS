package Tests.dao;

import dao.ReservationDao;
import java.util.List;
import model.Reservation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservationDaoTest {
    
    public ReservationDaoTest() {
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
     * Test of addReservation method, of class ReservationDao.
     */
    @org.junit.Test
    public void testAddReservation() {
        System.out.println("addReservation");
        Reservation res = new Reservation("FL101","29-Nov-2019","09:00","shane");
        ReservationDao instance = new ReservationDao();
        boolean expResult = true;
        boolean result = instance.addReservation(res);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserResevations method, of class ReservationDao.
     */
    @org.junit.Test
    public void testGetUserResevations() {
        System.out.println("getUserResevations");
        String email = "shane";
        ReservationDao instance = new ReservationDao();
        //List<Reservation> expResult = null;
        List<Reservation> result = instance.getUserResevations(email);
        assertEquals(1, result.size());
        
    }
    
}
