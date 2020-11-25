package prj5;

import student.TestCase;

/**
 * This class contains methods that test methods in the State class.
 * 
 * @author Matthew Ho (matthew00) & Baylor Lin (baylorl)
 * @version (11.21.2020)
 *
 */
public class StateTest extends TestCase {
    private State state;
    private LinkedList<Demographic> demoList;

    /**
     * This method sets up a State Object
     */
    public void setUp() {
        demoList = new LinkedList<Demographic>();
        state = new State("Virginia", demoList);
    }


    /**
     * Tests the States getName() method
     */
    public void testGetName() {
        assertEquals(state.getName(), "Virginia");
    }


    /**
     * Tests the State's getPopulation() method
     */
    public void testGetPopultation() {
        Demographic demo = new Demographic("asian", "Virginia", "12", "13");
        demoList.add(demo);
        assertEquals("asian", state.getPopulation().getEntry(0).getRace());
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        Demographic white = new Demographic("White", "Virginia", "40000",
            "10000");
        Demographic asian = new Demographic("Asian", "Virginia", "40000",
            "20000");
        Demographic black = new Demographic("Black", "Virginia", "40000",
            "30000");
        demoList.add(white);
        demoList.add(asian);
        demoList.add(black);
        assertEquals("Virginia\n" + "Asian: 40000 cases, 50% CFR\n"
            + "Black: 40000 cases, 75% CFR\n" + "White: 40000 cases, 25% CFR\n"
            + "=====\n" + "Black: 40000 cases, 75% CFR\n"
            + "Asian: 40000 cases, 50% CFR\n" + "White: 40000 cases, 25% CFR\n"
            + "=====", state.toString());
    }
}
