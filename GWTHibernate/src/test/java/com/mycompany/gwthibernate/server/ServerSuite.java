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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author OFesenyuk
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mycompany.gwthibernate.server.GreetingFactoryTest.class, com.mycompany.gwthibernate.server.PasswordHashTest.class, com.mycompany.gwthibernate.server.UserServiceImplTest.class, com.mycompany.gwthibernate.server.UserDataTest.class, com.mycompany.gwthibernate.server.LocalNamesTest.class})
public class ServerSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}