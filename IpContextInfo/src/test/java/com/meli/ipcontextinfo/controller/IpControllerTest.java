package com.meli.ipcontextinfo.controller;

import com.meli.ipcontextinfo.model.Coordinate;
import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.model.CountryName;
import com.meli.ipcontextinfo.model.Currency;
import com.meli.ipcontextinfo.model.Language;
import com.meli.ipcontextinfo.model.TimeZone;
import com.meli.ipcontextinfo.service.impl.CoordinateServiceImpl;
import com.meli.ipcontextinfo.service.impl.CountryServiceImpl;
import com.meli.ipcontextinfo.service.impl.CurrencyRateServiceImpl;
import com.meli.ipcontextinfo.service.impl.IpServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.hamcrest.Matchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author jvaleriano
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(IpController.class)
public class IpControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryServiceImpl countryService;

    @MockBean
    private CurrencyRateServiceImpl currencyRateService;

    @MockBean
    private IpServiceImpl ipService;
    
    @MockBean
    private CoordinateServiceImpl coordinateService;


    public IpControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {



    }

    @After
    public void tearDown() {
    }

    /**
     * Test of trace method, of class IpController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testTrace_ok() throws Exception {
        Coordinate co = new Coordinate(51.0, 9.0);
      when(coordinateService.calculateDistanceToOriginInKm(co)).thenReturn(10d);
        
      when(currencyRateService.getCurrencyDolarRate("EUR")).thenReturn(BigDecimal.valueOf(1.162149));

      when(ipService.getCountryCodeByIp("5.6.7.8")).thenReturn("DEU");

       
        Country c = new Country(new CountryName("Germany", "Alemania"),
                "DEU", new ArrayList<Language>(), new Currency("EUR", "€"),new ArrayList<TimeZone>()
                , co);
        
        when(countryService.getCountryByIsoCode("DEU")).thenReturn(c);
        
        this.mockMvc.perform(get("/ip/trace?ip=5.6.7.8")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.ip").value(containsString("5.6.7.8")));
    }

    /**
     * Test of trace method, of class IpController.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testTrace_ko() throws Exception {
        when(ipService.getCountryCodeByIp("lala")).thenReturn(null);
        this.mockMvc.perform(get("/ip/trace?ip=lala")).andDo(print()).andExpect(status().isNotFound());
    }

}
