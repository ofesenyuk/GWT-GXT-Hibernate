/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gwthibernate.server;

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
public class LocalNamesTest {
    
    public LocalNamesTest() {
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
     * Test of getId method, of class LocalNames.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        LocalNames instance = new LocalNames();
        Integer expResult = 123;
        instance.setId(expResult);
        Integer result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class LocalNames.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = 654;
        LocalNames instance = new LocalNames();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getName method, of class LocalNames.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        LocalNames instance = new LocalNames();
        String expResult = "testGetName";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class LocalNames.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "testSetName";
        LocalNames instance = new LocalNames();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getLocale method, of class LocalNames.
     */
    @Test
    public void testGetLocale() {
        System.out.println("getLocale");
        LocalNames instance = new LocalNames();
        String expResult = "getLocale";
        instance.setLocale(expResult);
        String result = instance.getLocale();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocale method, of class LocalNames.
     */
    @Test
    public void testSetLocale() {
        System.out.println("setLocale");
        String locale = "testSetLocale";
        LocalNames instance = new LocalNames();
        instance.setLocale(locale);
        assertEquals(locale, instance.getLocale());
    }

    /**
     * Test of getUId method, of class LocalNames.
     */
    @Test
    public void testGetUId() {
        System.out.println("getUId");
        LocalNames instance = new LocalNames();
        UserData expResult = new UserData(123);
        instance.setUId(expResult);
        UserData result = instance.getUId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUId method, of class LocalNames.
     */
    @Test
    public void testSetUId() {
        System.out.println("setUId");
        UserData uId = new UserData(321);
        LocalNames instance = new LocalNames();
        instance.setUId(uId);
        assertEquals(uId, instance.getUId());
    }

    /**
     * Test of hashCode method, of class LocalNames.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LocalNames instance = new LocalNames();
        int expResult = -1;
        instance.setId(expResult);
        int result = instance.hashCode();
        assertEquals(expResult, result);
        LocalNames instance2 = new LocalNames(expResult);
        assertEquals(instance.hashCode(), instance2.hashCode());
    }

    /**
     * Test of equals method, of class LocalNames.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        int id = 123;
        Object object = new LocalNames(id);
        LocalNames instance = new LocalNames(321);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        object = new LocalNames(id);
        expResult = true;
        assertEquals(expResult, object.equals(object));
        assertEquals(instance.equals(object), object.equals(instance));
        LocalNames instance2 = new LocalNames(id);
        assertEquals(expResult, object.equals(instance2));
        assertEquals(expResult, object.hashCode() == instance2.hashCode());
    }

    /**
     * Test of toString method, of class LocalNames.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        int id = 123;
        LocalNames instance = new LocalNames(id);
        String expResult = "com.mycompany.gwthibernate.server.LocalNames[ id=" 
                + id + " ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
