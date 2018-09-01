package com.meli.ipcontextinfo.command;

import com.meli.ipcontextinfo.model.Coordinate;
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
public class CalculateDistanceCommandTest {

    public CalculateDistanceCommandTest() {
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
     * Test of execute method, of class CalculateDistanceCommand.
     */
    @Test
    public void testExecuteInMeters() {
        System.out.println("calculateDistanceInKm");
        Coordinate a = new Coordinate(-34.606555, -58.370941);
        Coordinate b = new Coordinate(-34.606469, -58.369852);
        Double expResult = 0.1;
        Double result = new CalculateDistanceCommand(a, b).execute();
        assertEquals(expResult, result);
    }

    @Test
    public void testExecuteWithNullsValues() {
        System.out.println("calculateDistanceInKm");
        Coordinate a = null;
        Coordinate b = null;
        Double expResult = 0d;
        Double result = new CalculateDistanceCommand(a, b).execute();
        assertEquals(expResult, result);
    }
    
     @Test
    public void testExecuteWithZeroValues() {
        System.out.println("calculateDistanceInKm");
        Coordinate a = new Coordinate(0d, 0d);
        Coordinate b = new Coordinate(0d, 0d);
        Double expResult = 0d;
        Double result = new CalculateDistanceCommand(a, b).execute();
        assertEquals(expResult, result);
    }

}
