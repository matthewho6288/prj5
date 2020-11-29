package prj5;

/**
 * This class creates state objects and methods.
 * 
 * @author Matthew Ho (matthew00) & Baylor Lin (baylorl)
 * @version (11.20.2020)
 */
public class State {
    private String stateName;
    private LinkedList<Demographic> population;

    /**
     * This constructor creates a State object and initiates its fields.
     *
     * @param name
     *            the name of the state
     *
     * @param populus
     *            a LinkedList of Demographic objects in the state.
     */
    public State(String name, LinkedList<Demographic> populus) {
        stateName = name;
        population = populus;
    }


    /**
     * This method obtains the State's name.
     *
     * @return a string representing the state's name
     */
    public String getName() {
        return stateName;
    }


    /**
     * This method obtains all of the demographics belonging to a state.
     *
     * @return a LinkedList containing each of the demographics within the state
     */
    public LinkedList<Demographic> getPopulation() {
        return population;
    }


    /**
     * This method turns each of the states into a string representation.
     * 
     * @return a string of the state name and the demographics sorted in
     *         alphabetical order and by CFR's
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(stateName);
        population.alphaSort();
        str.append(population.toString());
        population.cfrSort();
        str.append(population.toString());
        return String.valueOf(str);
    }
}
