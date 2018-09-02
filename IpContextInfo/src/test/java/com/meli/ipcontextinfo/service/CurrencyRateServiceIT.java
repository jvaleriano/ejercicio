package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.RateResponseCurrencyCode;
import java.math.BigDecimal;
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
public class CurrencyRateServiceIT {
    
    @Autowired
    private CurrencyRateService instance;
    
    public CurrencyRateServiceIT() {
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
     * Test of getCurrencyRate method, of class CurrencyRateService.
     */
    @Test
    public void testGetCurrencyRate() {
        System.out.println("getCurrencyRate");
        String currency = "EUR";
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.USD);
        assertNotNull(result);

    }

    /**
     * Test of getCurrencyDolarRate method, of class CurrencyRateService.
     */
    @Test
    public void testGetCurrencyDolarRate() {
        System.out.println("getCurrencyDolarRate");
        String currency = "EUR";
        BigDecimal result = instance.getCurrencyDolarRate(currency);
        assertNotNull(result);
    }
    
}
