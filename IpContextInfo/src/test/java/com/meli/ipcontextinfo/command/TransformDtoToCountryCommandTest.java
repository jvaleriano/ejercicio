package com.meli.ipcontextinfo.command;

import com.google.gson.Gson;
import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.service.model.CountryDto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author valer
 */
public class TransformDtoToCountryCommandTest {
    
    public TransformDtoToCountryCommandTest() {
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
     * Test of execute method, of class TransformDtoToCountryCommand.
     */
    @Test
    public void testWithNullValues() {
        System.out.println("execute");
        Country expResult = new Country();
        Country result = new  TransformDtoToCountryCommand(null,null).execute();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testWithNullValuesInDtoAndRate() {
        System.out.println("execute");
        Country expResult = new Country();
        Country result = new  TransformDtoToCountryCommand(new CountryDto(),null).execute();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOK() {
        System.out.println("execute");
        Gson g = new Gson();
        CountryDto dto = g.fromJson("{\"name\":\"Argentina\",\"topLevelDomain\":[\".ar\"],\"alpha2Code\":\"AR\",\"alpha3Code\":\"ARG\",\"callingCodes\":[\"54\"],\"capital\":\"Buenos Aires\",\"altSpellings\":[\"AR\",\"Argentine Republic\",\"República Argentina\"],\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":43590400,\"latlng\":[-34.0,-64.0],\"demonym\":\"Argentinean\",\"area\":2780400.0,\"gini\":44.5,\"timezones\":[\"UTC-03:00\"],\"borders\":[\"BOL\",\"BRA\",\"CHL\",\"PRY\",\"URY\"],\"nativeName\":\"Argentina\",\"numericCode\":\"032\",\"currencies\":[{\"code\":\"ARS\",\"name\":\"Argentine peso\",\"symbol\":\"$\"}],\"languages\":[{\"iso639_1\":\"es\",\"iso639_2\":\"spa\",\"name\":\"Spanish\",\"nativeName\":\"Español\"},{\"iso639_1\":\"gn\",\"iso639_2\":\"grn\",\"name\":\"Guaraní\",\"nativeName\":\"Avañe'ẽ\"}],\"translations\":{\"de\":\"Argentinien\",\"es\":\"Argentina\",\"fr\":\"Argentine\",\"ja\":\"アルゼンチン\",\"it\":\"Argentina\",\"br\":\"Argentina\",\"pt\":\"Argentina\",\"nl\":\"Argentinië\",\"hr\":\"Argentina\",\"fa\":\"آرژانتین\"},\"flag\":\"https://restcountries.eu/data/arg.svg\",\"regionalBlocs\":[{\"acronym\":\"USAN\",\"name\":\"Union of South American Nations\",\"otherAcronyms\":[\"UNASUR\",\"UNASUL\",\"UZAN\"],\"otherNames\":[\"Unión de Naciones Suramericanas\",\"União de Nações Sul-Americanas\",\"Unie van Zuid-Amerikaanse Naties\",\"South American Union\"]}],\"cioc\":\"ARG\"}", CountryDto.class);
        Country result = new  TransformDtoToCountryCommand(dto,null).execute();
        assertEquals(dto.getAlpha3Code(), result.getIsoCode());
    }
}
