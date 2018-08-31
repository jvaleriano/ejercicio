//package com.meli.ipContextInfo.service.impl;
//
//import com.meli.ipcontextinfo.model.Coordinate;
//import com.meli.ipcontextinfo.service.CoordinateService;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// *
// * @author VAL13448
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CoordinateServiceTest {
//
//    @Autowired
//    private CoordinateService instance;
//
//    public CoordinateServiceTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of calculateDistanceInKm method, of class CoordinateServiceImpl.
//     *
//     */
//    @Test
//    public void testCalculateDistanceInKm100Mtrs() {
//        System.out.println("calculateDistanceInKm");
//        Coordinate a = new Coordinate(-34.606555, -58.370941);
//        Coordinate b = new Coordinate(-34.606469, -58.369852);
//        Double expResult = 0.01;
//        Double result = instance.calculateDistanceInKm(a, b);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testCalculateDistanceInKmLess100Mtrs() {
//        System.out.println("calculateDistanceInKm");
//        Coordinate a = new Coordinate(-34.606555, -58.370941);
//        Coordinate b = new Coordinate(-34.606532, -58.370687);
//        Double expResult = 0.003;
//        Double result = instance.calculateDistanceInKm(a, b);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testCalculateDistanceInKmSameRadianValue() {
//        System.out.println("calculateDistanceInKm");
//        Coordinate a = new Coordinate(0d, 0d);
//        Coordinate b = new Coordinate(0d, 360d);
//        Double expResult = 0.0;
//        Double result = instance.calculateDistanceInKm(a, b);
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testCalculateDistanceInKmMaxValue() {
//        System.out.println("calculateDistanceInKm");
//        Coordinate a = new Coordinate(0d, 0d);
//        Coordinate b = new Coordinate(0d, 180d);
//        Double expResult = 20015.087;
//        Double result = instance.calculateDistanceInKm(a, b);
//        assertEquals(expResult, result);
//    }
//    
// }
