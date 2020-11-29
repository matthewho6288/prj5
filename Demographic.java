package prj5;

import java.text.DecimalFormat;

/**
 * This class constructs Demographic objects and methods that obtain their field
 * data, compares objects to each other, and creates string representations of
 * the objects.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.21.2020)
 */
public class Demographic {
    private String race;
    private String state;
    private String confirmedCases;
    private String deathToll;

    /**
     * This constructor creates a Demographic object and sets its initial
     * values.
     * 
     * @param ethinicity
     *            A string representing the demographic's race
     * @param location
     *            A string representing the demographic's state
     * @param cases
     *            A string representing the demographic's number of confirmed
     *            cases
     * @param deaths
     *            A string representing the demographic's number of COVID
     *            related deaths
     */
    public Demographic(
        String ethinicity,
        String location,
        String cases,
        String deaths) {
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
     * This method obtains the state where the demographic resides.
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
    public String getConfirmedCases() {
        return confirmedCases;
    }


    /**
     * This method obtains the number of deaths caused by COVID.
     * 
     * @return The demographic's amount of COVID deaths
     */
    public String getDeathToll() {
        return deathToll;
    }


    /**
     * This method calculates the ratio between the number of deaths caused by
     * COVID and the number of confirmed COVID cases. The CFR is only calculated
     * if the string representing the number of confirmed COVID cases or the
     * number of COVID deaths is not -1".
     * 
     * @return CFR ratio as percentage, -1 if the confirmedCases or deathToll is
     *         "-1"
     */
    public double cfr() {
        if (confirmedCases.equals("-1") || deathToll.equals("-1")) {
            return -1;
        }
        return 100 * Double.valueOf(deathToll) / Double.valueOf(confirmedCases);
    }


    /**
     * This method compares "this" Demographic to another object.
     * 
     * @param obj
     *            object that "this" is being compared to
     * 
     * @return true if all traits of both Demographic objects are the same
     */
    @Override
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


    /**
     * This method creates a string containing the demographic's race, confirmed
     * cases, and CFR. The format of the string is returned as: Ex. "white: 9000
     * cases, 5.4% CFR"
     * 
     * @return a string representing the Demographic object.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        String pattern = "#.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String cfr = decimalFormat.format(cfr());
        str.append(race + ": " + confirmedCases + " cases, " + cfr + "% CFR");
        return String.valueOf(str);
    }
}
