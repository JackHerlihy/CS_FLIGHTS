/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.dao;

import dao.UserDao;
import java.util.List;
import model.Admin;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserDaoTest {
    
    public UserDaoTest() {
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
     * Test of getUsers method, of class UserDao.
     */
    @org.junit.Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserDao instance = new UserDao();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        
        assertEquals(9, result.size());
    }

    /**
     * Test of validateUser method, of class UserDao.
     */
    @org.junit.Test
    public void testValidateUser() {
        System.out.println("validateUser");
        User loginUser = new User("shane", "p.word");
        UserDao instance = new UserDao();
        Boolean expResult = true;
        Boolean result = instance.validateUser(loginUser);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addUser method, of class UserDao.
     */
    @org.junit.Test
    public void testAddUser() {
        System.out.println("addUser");
        User newUser = new User("name","email","password","address");
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.addUser(newUser);
        assertEquals(expResult, result);
        
    }

//    /**
//     * Test of getAdmins method, of class UserDao.
//     */
//    @org.junit.Test
//    public void testGetAdmins() {
//        System.out.println("getAdmins");
//        UserDao instance = new UserDao();
//        List<Admin> expResult = null;
//        //List<Admin> result = instance.getAdmins();
//       // assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validateAdmin method, of class UserDao.
//     */
//    @org.junit.Test
//    public void testValidateAdmin() {
//        System.out.println("validateAdmin");
//        Admin adminUser = null;
//        UserDao instance = new UserDao();
//        Boolean expResult = null;
//        //Boolean result = instance.validateAdmin(adminUser);
//        //assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
