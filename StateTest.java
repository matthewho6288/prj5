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
     * Tests the States getPopulation() method
     */
    public void testGetPopultation() {
        Demographic demo = new Demographic("asian", "Virginia", 12, 13);
        demoList.add(demo);
        assertEquals("asian", state.getPopulation().getEntry(0).getRace());
    }
}
