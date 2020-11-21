package prj5;

import student.TestCase;

/**
 * 
 * @author matthewho
 *
 *
 */
public class DemographicTest extends TestCase {
    private Demographic asians;

    /**
     * This method sets up a Demographic Object
     */
    public void setUp() {
        asians = new Demographic("Asian", "Virginia", 50000, 20000);
    }


    public void testGetRace() {
        assertEquals("Asian", asians.getRace());
    }


    public void testGetState() {

        assertEquals("Virginia", asians.getState());
    }


    public void testGetConfirmedCases() {
        assertEquals(50000, asians.getConfirmedCases());
    }


    public void testGetDeathToll() {
        assertEquals(20000, asians.getDeathToll());
    }


    public void testCFR() {
        assertEquals(40.0, asians.cfr(), 0.001);
    }

}
