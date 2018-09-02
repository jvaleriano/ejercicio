package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.service.impl.IpServiceImpl;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import static org.hamcrest.Matchers.endsWith;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author VAL13448
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest(IpServiceImpl.class)
@ActiveProfiles("test")
public class IpServiceTest {

    @Autowired
    private IpService instance = null;

    @Autowired
    private MockRestServiceServer server;

    public IpServiceTest() {
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
    public void testGetCountryCodeByIpOk() {
        System.out.println("testGetCountryCodeByIpOk");
        this.server.reset();
        String response = "{\"countryCode\": \"DE\",\"countryCode3\": \"DEU\","
                + "\"countryName\": \"Germany\",\"countryEmoji\": \"🇩🇪\"}";
        
        this.server.expect(requestTo(endsWith("/ip?5.6.7.8")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        String ip = "5.6.7.8";
        String expResult = "DEU";
        String result = instance.getCountryCodeByIp(ip);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountryCodeByIp method, of class IpServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIp_400() {
        System.out.println("testGetCountryCodeByIp_400");
        this.server.reset();
        this.server.expect(requestTo(endsWith("/ip?5.6.7.8")))
                .andRespond(withBadRequest());
        String ip = "5.6.7.8";
        String result = instance.getCountryCodeByIp(ip);
        assertNull(result);
    }
    
    
       /**
     * Test of getCountryCodeByIp method, of class IpServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIp_serverError() {
        System.out.println("testGetCountryCodeByIp_serverError");
        this.server.reset();
        this.server.expect( requestTo(endsWith("/ip?5.6.7.8")))
                .andRespond(withServerError());
        String ip = "5.6.7.8";
        String result = instance.getCountryCodeByIp(ip);
        assertNull(result);
    } 
}
