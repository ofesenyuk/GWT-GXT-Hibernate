/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OFesenyuk
 */
public class UserDataTest {
    
    public UserDataTest() {
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
     * Test of getId method, of class UserData.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        UserData instance = new UserData();
        Integer expResult = null;
        Integer result = instance.getId();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class UserData.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        UserData instance = new UserData();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class UserData.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.getName();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class UserData.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserData instance = new UserData();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class UserData.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        UserData instance = new UserData();
        byte[] expResult = null;
        byte[] result = instance.getUserName();
//        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class UserData.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        byte[] userName = null;
        UserData instance = new UserData();
//        instance.setUserName(userName);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UserData.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserData instance = new UserData();
        byte[] expResult = null;
        byte[] result = instance.getPassword();
//        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class UserData.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        byte[] password = null;
        UserData instance = new UserData();
//        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocalNamesCollection method, of class UserData.
     */
    @Test
    public void testGetLocalNamesCollection() {
        System.out.println("getLocalNamesCollection");
        UserData instance = new UserData();
        Collection<LocalNames> expResult = null;
        Collection<LocalNames> result = instance.getLocalNamesCollection();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocalNamesCollection method, of class UserData.
     */
    @Test
    public void testSetLocalNamesCollection() {
        System.out.println("setLocalNamesCollection");
        Collection<LocalNames> localNamesCollection = null;
        UserData instance = new UserData();
//        instance.setLocalNamesCollection(localNamesCollection);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserData.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserData instance = new UserData();
        int expResult = 0;
        int result = instance.hashCode();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserData.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserData instance = new UserData();
        boolean expResult = false;
        boolean result = instance.equals(object);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserData.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserData instance = new UserData();
        String expResult = "";
        String result = instance.toString();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
