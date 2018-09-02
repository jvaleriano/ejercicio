package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.RateResponseCurrencyCode;
import com.meli.ipcontextinfo.service.impl.CurrencyRateServiceImpl;
import java.math.BigDecimal;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

/**
 *
 * @author valer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest(CurrencyRateServiceImpl.class)
public class CurrencyRateServiceTest {

    @Autowired
    private CurrencyRateService instance;

    @Autowired
    private MockRestServiceServer server;

    public CurrencyRateServiceTest() {
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
     *
     *
     */
    @Test
    public void testGetCurrencyRate_Ok() {
        System.out.println("testGetCurrencyRate");
        String response = "{\"success\":true,\"timestamp\":1535843050,"
                + "\"base\":\"EUR\",\"date\":\"2018-09-01\","
                + "\"rates\":{\"USD\":1.162149}}";

        this.server.expect(requestTo(containsString("&base=EUR&symbols=USD")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        String currency = "EUR";
        BigDecimal expResult = BigDecimal.valueOf(1.162149);
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.USD);
        assertEquals(expResult, result);

    }

    /**
     * Test of getCurrencyRate method, of class CurrencyRateService.
     *
     *
     */
    @Test
    public void testGetCurrencyRate_InvalidBase() {
        System.out.println("testGetCurrencyRate");
        String response = "{\"success\":false,\"error\":{\"code\":105,"
                + "\"type\":\"base_currency_access_restricted\"}}";

        this.server.expect(requestTo(containsString("&base=USD&symbols=EUR")))
                .andRespond(withStatus(HttpStatus.NOT_MODIFIED));

        String currency = "USD";
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.EUR);
        assertNull(result);
    }

    /**
     * Test of getCurrencyRate method, of class CurrencyRateService.
     *
     *
     */
    @Test
    public void testGetCurrencyRate_AccesRestinged() {
        System.out.println("testGetCurrencyRate");
        String response = "{\"success\":false,\"error\":{\"code\":105,"
                + "\"type\":\"https_access_restricted\","
                + "\"info\":\"Access Restricted - "
                + "Your current Subscription Plan does not "
                + "support HTTPS Encryption.\"}}";

        this.server.expect(requestTo(containsString("&base=USD&symbols=EUR")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        String currency = "USD";
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.EUR);
        assertNull(result);
    }

    /**
     * Test of testGetCurrencyRate_400 method, of class CurrencyRateService.
     */
    @Test
    public void testGetCurrencyRate_400() {
        System.out.println("testGetCurrencyRate_400");
        this.server.expect(requestTo(containsString("&base=USD&symbols=EUR")))
                .andRespond(withBadRequest());
        String ip = "5.6.7.8";
        String currency = "USD";
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.EUR);
        assertNull(result);
    }

    /**
     * Test of testGetCurrencyRate_400 method, of class CurrencyRateService.
     */
    @Test
    public void testGetCurrencyRate_serverError() {
        System.out.println("testGetCurrencyRate_400");
        this.server.expect(requestTo(containsString("&base=USD&symbols=EUR")))
                .andRespond(withServerError());
        String ip = "5.6.7.8";
        String currency = "USD";
        BigDecimal result = instance.getCurrencyRate(currency, RateResponseCurrencyCode.EUR);
        assertNull(result);
    }

    /**
     * Test of getCurrencyDolarRate method, of class CurrencyRateService.
     */
    @Test
    public void testGetCurrencyDolarRate_ok() {
        System.out.println("getCurrencyDolarRate");

        String response = "{\"success\":true,\"timestamp\":1535843050,"
                + "\"base\":\"EUR\",\"date\":\"2018-09-01\","
                + "\"rates\":{\"USD\":1.162149}}";

        this.server.expect(requestTo(containsString("&base=EUR&symbols=USD")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));
        String currency = "EUR";
        BigDecimal expResult = BigDecimal.valueOf(1.162149);

        BigDecimal result = instance.getCurrencyDolarRate(currency);
        assertEquals(expResult, result);

    }

}
