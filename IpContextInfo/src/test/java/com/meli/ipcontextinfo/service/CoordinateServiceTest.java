package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Coordinate;
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
 * @author valer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoordinateServiceTest {
    
    @Autowired
    private CoordinateService instance;
    
    public CoordinateServiceTest() {
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
     * Test of calculateDistanceInKm method, of class CoordinateService.
     */
    @Test
    public void testCalculateDistanceInKm100Mtrs() {
        System.out.println("testCalculateDistanceInKm100Mtrs");
        Coordinate a = new Coordinate(-34.606555, -58.370941);
        Coordinate b = new Coordinate(-34.606469, -58.369852);
        Double expResult = 0.1;
        Double result = instance.calculateDistanceInKm(a, b);
        assertEquals(expResult, result);
    }
    /**
     * Test of calculateDistanceInKm method, of class CoordinateService.
     */
    @Test
    public void testCalculateDistanceKmLess100Mtrs() {
        System.out.println("testCalculateDistanceKmLess100Mtrs");
        Coordinate a = new Coordinate(-34.606555, -58.370941);
        Coordinate b = new Coordinate(-34.606532, -58.370687);
        Double expResult = 0.023;
        Double result = instance.calculateDistanceInKm(a, b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalculateDistanceInKmSameRadianValue() {
        System.out.println("testCalculateDistanceInKmSameRadianValue");
        Coordinate a = new Coordinate(0d, 0d);
        Coordinate b = new Coordinate(0d, 360d);
        Double expResult = 0.0;
        Double result = instance.calculateDistanceInKm(a, b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalculateDistanceInKmMaxValue() {
        System.out.println("testCalculateDistanceInKmMaxValue");
        Coordinate a = new Coordinate(0d, 0d);
        Coordinate b = new Coordinate(0d, 180d);
        Double expResult = 20015.087;
        Double result = instance.calculateDistanceInKm(a, b);
        assertEquals(expResult, result);
    }    
    /**
     * Test of calculateDistanceToOriginInKm method, of class CoordinateService.
     */
    @Test
    public void testCalculateDistanceToOriginInKm() {
        System.out.println("testCalculateDistanceToOriginInKm");
        Coordinate a = new Coordinate(0d, 0d);
        Double expResult = 7164.158;
        Double result = instance.calculateDistanceToOriginInKm(a);
        assertEquals(expResult, result);

    }

    
}
