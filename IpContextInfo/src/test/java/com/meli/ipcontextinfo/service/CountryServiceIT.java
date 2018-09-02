package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.service.impl.CountryServiceImpl;
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
public class CountryServiceIT {
    
    @Autowired
    private CountryServiceImpl countryService;
    
    public CountryServiceIT() {
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
     * Test of getCountryByIsoCode method, of class CountryService.
     */
    @Test
    public void testGetCountryByIsoCode() {
        System.out.println("getCountryByIsoCode");
        String isoCode = "NLD";
        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNotNull(result);
        assertEquals(result.getIsoCode(), "NLD");
        assertNotNull(result.getCurrency().getRate());
    }
    
}
