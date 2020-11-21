package prj5;

/**
 * 
 * @author matthewho
 *
 */
public class Demographic {
    private String race;
    private String state;
    private int confirmedCases;
    private int deathToll;

    /**
     * This constructor creates a Demographic object.
     * 
     * @param ethinicity
     *            The demographic's race
     * @param location
     *            The demographic's state
     * @param cases
     *            The demographic's number of COVID cases
     * @param deaths
     *            The demographic's number of COVID related deaths
     */
    public Demographic(
        String ethinicity,
        String location,
        int cases,
        int deaths) {
        race = ethinicity;
        state = location;
        confirmedCases = cases;
        deathToll = deaths;
    }


    /**
     * This method obtains the race of a demographic.
     * 
     * @return The demographic's race as a string
     */
    public String getRace() {
        return race;
    }


    /**
     * This method obtains the state where the demographic resides
     * 
     * @return The demographic's state
     */
    public String getState() {
        return state;
    }


    /**
     * This method obtains the number of confirmed COVID cases.
     * 
     * @return The demographic's amount of COVID cases
     */
    public int getConfirmedCases() {
        return confirmedCases;
    }


    /**
     * This method obtains the number of deaths caused by COVID.
     * 
     * @return Number of COVID deaths
     */
    public int getDeathToll() {
        return deathToll;
    }


    /**
     * This method calculates the ratio between the number of deaths caused by
     * COVID
     * and the number of confirmed COVID cases.
     * 
     * @return CFR ratio as percentage
     */
    public double cfr() {
        return (Double.valueOf(deathToll) / Double.valueOf(confirmedCases))
            * 100;
    }


    /**
     * This method compares "this" Demographic to another object
     * 
     * @param obj
     *            object that "this" is being compared to
     * 
     * @return true if all traits of both Demographic objects are the same
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        else {
            Demographic group = (Demographic)obj;
            return (this.race == group.race && this.state == group.state
                && this.confirmedCases == group.confirmedCases
                && this.deathToll == group.deathToll);
        }
    }
}
