package com.meli.ipcontextinfo.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author valer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IpServiceIT {
    
    @Autowired
    private IpService instance;
    
    public IpServiceIT() {
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
     * Test of getCountryCodeByIp method, of class IpService.
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
