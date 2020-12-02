package prj5;

import java.io.FileNotFoundException;

/**
 * This class runs the Covid Visualizer project
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.20.2020)
 */
public class Input {
    /**
     * This methods runs methods for the COVID Visualizer and prints lines of
     * information to the console.
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        State[] states;
        if (args.length == 1) {
            FileReader reader = new FileReader();
            states = reader.readFile(args[0]);
        }
        else {
            FileReader reader = new FileReader();
            states = reader.readFile(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(states[i].toString());
        }  
        new GUICovidWindow(states);
    }
}
