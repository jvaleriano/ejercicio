package com.meli.ipcontextinfo.service.impl;

import com.meli.ipcontextinfo.model.Country;
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
public class CountryServiceImplTest {
    
    @Autowired
    private CountryServiceImpl instance;
    
    public CountryServiceImplTest() {
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
     * Test of getCountryByIsoCode method, of class CountryServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIsoCode_Ok() {
        System.out.println("getCountryCodeByIsoCode");
        String isoCode = "ARG";
        
        Country result = instance.getCountryByIsoCode(isoCode);
        assertNotNull(result);
        assertEquals(result.getIsoCode(), "ARG");
    }
    
    @Test
    public void testGetCountryCodeByIsoCode_InvalidIsoCode() {
        System.out.println("getCountryCodeByIsoCode");
        String isoCode = "XXX";
        Country result = instance.getCountryByIsoCode(isoCode);
        assertNull(result);
    }
    
}
