package com.meli.ipcontextinfo.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author VAL13448
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IpServiceImplTest {
    
    @Autowired
    private IpServiceImpl instance = null;
    
    public IpServiceImplTest() {
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
     * Test of getCountryCodeByIp method, of class IpServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIp() {
        System.out.println("getCountryCodeByIp");
        String ip = "5.6.7.8";
        String expResult = "DEU";
        String result = instance.getCountryCodeByIp(ip);
        assertEquals(expResult, result);
    }
    
}
