package prj5;

/**
 * 
 * @author matthewho
 *
 */
public class State {
    private String state;
    private LinkedList<Demographic> ethnicity;

    /**
     * This constructor creates a State object
     *
     * @param str
     *            The States name
     *
     * @param list
     *            The States Demographics list
     */
    public State(String str, LinkedList<Demographic> list) {
        state = str;
        ethnicity = list;
    }


    /**
     * This method obtains the States name
     *
     * @return the States name as a string
     */
    public String getName() {
        return state;
    }


    /**
     * This method obtains the States demographics
     *
     * @return the States demographics as a list
     */
    public LinkedList<Demographic> getPopulation() {
        return ethnicity;
    }
}
