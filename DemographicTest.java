package prj5;

import student.TestCase;

/**
 * This class contains methods that test methods in the Demographic class.
 * 
 * @author Matthew Ho (matthew00) & Baylor Lin (baylorl)
 * @version (11.21.2020)
 *
 */
public class DemographicTest extends TestCase {
    private Demographic asians;

    /**
     * This method sets up a Demographic Object
     */
    public void setUp() {
        asians = new Demographic("Asian", "Virginia", "50000", "20000");
    }


    /**
     * This method tests the getRace() getter method.
     */
    public void testGetRace() {
        assertEquals("Asian", asians.getRace());
    }


    /**
     * This method tests the getState() getter method.
     */
    public void testGetState() {

        assertEquals("Virginia", asians.getState());
    }


    /**
     * This method tests the getConfirmedCases() getter method.
     */
    public void testGetConfirmedCases() {
        assertEquals("50000", asians.getConfirmedCases());
    }


    /**
     * This method tests the getDeathToll getter method.
     */
    public void testGetDeathToll() {
        assertEquals("20000", asians.getDeathToll());
    }


    /**
     * This method tests the cfr() method.
     */
    public void testCFR() {
        assertEquals(40.0, asians.cfr(), 0);
        Demographic asian2 = new Demographic("Asian", "Virginia", "-1", "-1");
        assertEquals(-1.0, asian2.cfr(), 0);
        Demographic asian3 = new Demographic("Asian", "Virginia", "-1", "999");
        assertEquals(-1.0, asian3.cfr(), 0);
        Demographic asian4 = new Demographic("Asian", "Virginia", "999", "-1");
        assertEquals(-1.0, asian4.cfr(), 0);
    }


    /**
     * This method tests the equals() method
     */
    public void testEquals() {
        Demographic asians2 = new Demographic("Asian", "Virginia", "50000",
            "20000");
        Demographic asians3 = new Demographic("Asian", "DC", "50000", "20000");
        Demographic asians4 = new Demographic("Asian", "Virginia", "80000",
            "20000");
        Demographic asians5 = new Demographic("Asian", "Virginia", "50000",
            "20200");
        Demographic whites = new Demographic("White", "Virginia", "50000",
            "20000");
        Demographic nullDem = null;
        Object obj = new Object();
        assertTrue(asians.equals(asians2));
        assertFalse(asians.equals(asians3));
        assertFalse(asians.equals(asians4));
        assertFalse(asians.equals(asians5));
        assertFalse(asians.equals(whites));
        assertFalse(asians.equals(nullDem));
        assertFalse(asians.equals(obj));
    }


    /**
     * This method tests the toString() method
     */
    public void testToString() {
        assertEquals("Asian: 50000 cases, 40% CFR", asians.toString());
    }
}
