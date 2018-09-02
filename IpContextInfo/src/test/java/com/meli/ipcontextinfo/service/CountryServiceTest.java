package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.service.impl.CountryServiceImpl;
import com.meli.ipcontextinfo.service.impl.CurrencyRateServiceImpl;
import java.math.BigDecimal;
import org.apache.commons.lang3.reflect.MethodUtils;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author VAL13448
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@RestClientTest({CountryServiceImpl.class, CurrencyRateServiceImpl.class})
@ActiveProfiles("test")
public class CountryServiceTest {

    @Autowired
    private CountryServiceImpl countryService;

    private MockRestServiceServer serverCountryService;

    @Autowired()
    private CurrencyRateServiceImpl currencyRateService;

    private MockRestServiceServer serverCurrencyRateService;

    public CountryServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        //  find a better way to get the Rest Template 
        serverCurrencyRateService = MockRestServiceServer.createServer((RestTemplate) MethodUtils.invokeMethod(currencyRateService, true, "getRestTemplate"));
        serverCountryService = MockRestServiceServer.createServer((RestTemplate) MethodUtils.invokeMethod(countryService, true, "getRestTemplate"));

        String response = "{\"success\":true,\"timestamp\":1535843050,"
                + "\"base\":\"ARS\",\"date\":\"2018-09-01\","
                + "\"rates\":{\"USD\":0.0271}}";

        this.serverCurrencyRateService.expect(requestTo(containsString("&base=ARS&symbols=USD")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCountryByIsoCode method, of class CountryServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIsoCode_Ok() {
        System.out.println("testGetCountryCodeByIsoCode_Ok");
        String response = "{\"name\":\"Argentina\",\"topLevelDomain\":[\".ar\"],"
                + "\"alpha2Code\":\"AR\",\"alpha3Code\":\"ARG\","
                + "\"callingCodes\":[\"54\"],\"capital\":\"Buenos Aires\","
                + "\"altSpellings\":[\"AR\",\"Argentine Republic\","
                + "\"República Argentina\"],\"region\":\"Americas\","
                + "\"subregion\":\"South America\",\"population\":43590400,"
                + "\"latlng\":[-34.0,-64.0],\"demonym\":\"Argentinean\","
                + "\"area\":2780400.0,\"gini\":44.5,"
                + "\"timezones\":[\"UTC-03:00\"],"
                + "\"borders\":[\"BOL\",\"BRA\",\"CHL\",\"PRY\",\"URY\"],"
                + "\"nativeName\":\"Argentina\",\"numericCode\":\"032\","
                + "\"currencies\":[{\"code\":\"ARS\","
                + "\"name\":\"Argentine peso\",\"symbol\":\"$\"}],"
                + "\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\","
                + "\"name\":\"Spanish\",\"nativeName\":\"Español\"},"
                + "{\"iso639_1\":\"gn\",\"iso639_2\":\"grn\","
                + "\"name\":\"Guaraní\",\"nativeName\":\"Avañe'ẽ\"}],"
                + "\"translations\":{\"de\":\"Argentinien\","
                + "\"es\":\"Argentina\",\"fr\":\"Argentine\","
                + "\"ja\":\"アルゼンチン\",\"it\":\"Argentina\","
                + "\"br\":\"Argentina\",\"pt\":\"Argentina\","
                + "\"nl\":\"Argentinië\",\"hr\":\"Argentina\","
                + "\"fa\":\"آرژانتین\"},"
                + "\"flag\":\"https://restcountries.eu/data/arg.svg\","
                + "\"regionalBlocs\":[{\"acronym\":\"USAN\","
                + "\"name\":\"Union of South American Nations\","
                + "\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],"
                + "\"otherNames\":[\"Unión de Naciones Suramericanas\","
                + "\"União de Nações Sul-Americanas\","
                + "\"Unie van Zuid-Amerikaanse Naties\","
                + "\"South American Union\"]}],\"cioc\":\"ARG\"}";

        this.serverCountryService.expect(requestTo(endsWith("/alpha/ARG")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));
        String isoCode = "ARG";

        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNotNull(result);
        assertEquals(result.getIsoCode(), "ARG");
        assertEquals(result.getCurrency().getRate(), BigDecimal.valueOf(0.0271));

    }

    @Test
    public void testGetCountryCodeByIsoCode_InvalidIsoCode() {
        System.out.println("testGetCountryCodeByIsoCode_InvalidIsoCode");
        this.serverCountryService.expect(requestTo(endsWith("/alpha/XXX")))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));
        String isoCode = "XXX";
        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNull(result);
    }

    /**
     * Test of getCountryCodeByIp method, of class IpServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIsoCode_400() {
        System.out.println("testGetCountryCodeByIsoCode_400");
        this.serverCountryService.expect(requestTo(endsWith("/alpha/ITA")))
                .andRespond(withBadRequest());
        String isoCode = "ITA";
        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNull(result);
    }

    /**
     * Test of getCountryCodeByIp method, of class IpServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIp_serverError() {
        System.out.println("testGetCountryCodeByIp_serverError");
        this.serverCountryService.expect(requestTo(endsWith("/alpha/FRA")))
                .andRespond(withServerError());
        String isoCode = "FRA";
        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNull(result);
    }

    /**
     * Test of getCountryByIsoCode method, of class CountryServiceImpl.
     */
    @Test
    public void testGetCountryCodeByIsoCode_witouthRate() {
        System.out.println("testGetCountryCodeByIsoCode_Ok");
        this.serverCurrencyRateService.reset();
        this.serverCurrencyRateService.expect(requestTo(containsString("&base=EUR")))
                .andRespond(withStatus(HttpStatus.NOT_MODIFIED));
        String response = "{\"name\":\"Netherlands\",\"topLevelDomain\":[\".nl\"],"
                + "\"alpha2Code\":\"NL\",\"alpha3Code\":\"NLD\","
                + "\"callingCodes\":[\"31\"],\"capital\":\"Amsterdam\","
                + "\"altSpellings\":[\"NL\",\"Holland\",\"Nederland\"],"
                + "\"region\":\"Europe\",\"subregion\":\"Western Europe\","
                + "\"population\":17019800,\"latlng\":[52.5,5.75],"
                + "\"demonym\":\"Dutch\",\"area\":41850.0,\"gini\":30.9,"
                + "\"timezones\":[\"UTC-04:00\",\"UTC+01:00\"],"
                + "\"borders\":[\"BEL\",\"DEU\"],\"nativeName\":\"Nederland\","
                + "\"numericCode\":\"528\",\"currencies\":[{\"code\":\"EUR\","
                + "\"name\":\"Euro\",\"symbol\":\"€\"}],"
                + "\"languages\":[{\"iso639_1\":\"nl\","
                + "\"iso639_2\":\"nld\",\"name\":\"Dutch\","
                + "\"nativeName\":\"Nederlands\"}],"
                + "\"translations\":{\"de\":\"Niederlande\","
                + "\"es\":\"Países Bajos\","
                + "\"fr\":\"Pays-Bas\",\"ja\":\"オランダ\",\"it\":\"Paesi Bassi\","
                + "\"br\":\"Holanda\",\"pt\":\"Países Baixos\",\"nl\":\"Nederland\","
                + "\"hr\":\"Nizozemska\",\"fa\":\"پادشاهی هلند\"},"
                + "\"flag\":\"https://restcountries.eu/data/nld.svg\","
                + "\"regionalBlocs\":[{\"acronym\":\"EU\",\"name\":\"European Union\","
                + "\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"NED\"}";

        this.serverCountryService.expect(requestTo(endsWith("/alpha/NLD")))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));
        String isoCode = "NLD";

        Country result = countryService.getCountryByIsoCode(isoCode);
        assertNotNull(result);
        assertEquals(result.getIsoCode(), "NLD");
        assertNull(result.getCurrency().getRate());
    }
}
