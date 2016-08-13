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
public class PasswordHashTest {
    
    public PasswordHashTest() {
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
     * Test of validatePassword method, of class PasswordHash.
     */
    @Test
    public void testValidatePassword_String_String() throws Exception {
        System.out.println("validatePassword");
        String password = "";
        String correctHash = "";
        PasswordHash instance = new PasswordHash();
        boolean expResult = false;
//        boolean result = instance.validatePassword(password, correctHash);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePassword method, of class PasswordHash.
     */
    @Test
    public void testValidatePassword_charArr_String() throws Exception {
        System.out.println("validatePassword");
        char[] password = null;
        String correctHash = "";
        PasswordHash instance = new PasswordHash();
        boolean expResult = false;
//        boolean result = instance.validatePassword(password, correctHash);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createHash method, of class PasswordHash.
     */
    @Test
    public void testCreateHash_String() throws Exception {
        System.out.println("createHash");
        String password = "";
        PasswordHash instance = new PasswordHash();
        String expResult = "";
//        String result = instance.createHash(password);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createHash method, of class PasswordHash.
     */
    @Test
    public void testCreateHash_charArr() throws Exception {
        System.out.println("createHash");
        char[] password = null;
        PasswordHash instance = new PasswordHash();
        String expResult = "";
//        String result = instance.createHash(password);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class PasswordHash.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
//        PasswordHash.main(args);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
