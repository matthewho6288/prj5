package prj5;

/**
 * This class creates state objects and methods.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.20.2020)
 */
public class State {
    private String homeState;
    private LinkedList<Demographic> ethnicity;

    /**
     * This constructor creates a State object
     *
     * @param str
     *            The States name
     *
     * @param list
     *            A linkedList of Demographic
     */
    public State(String str, LinkedList<Demographic> list) {
        homeState = str;
        ethnicity = list;
    }


    /**
     * This method obtains the States name
     *
     * @return the States name as a string
     */
    public String getName() {
        return homeState;
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
