package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class creates FileReader objects which extract information from a csv
 * file.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.21.2020)
 */
public class FileReader {
    public static final int MAX_STATES = 6;
    private String[] strArr;
    private LinkedList<Demographic> demographics;
    private String state;
    private Demographic white;
    private Demographic black;
    private Demographic latinX;
    private Demographic asian;
    private Demographic other;

    /**
     * This method scans a file and creates Demographic objects, a LinkedList of
     * Demographic objects, and a list of states.
     * 
     * @param fileName
     *            the file to read
     * @throws FileNotFoundException
     */
    public State[] readFile(String fileName) throws FileNotFoundException {
        State[] states = new State[MAX_STATES];
        Scanner file = new Scanner(new File(fileName));
        String line = file.nextLine();
        int i = 0;
        while (file.hasNextLine()) {
            line = file.nextLine();
            strArr = line.split(",");
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals("NA")) {
                    strArr[j] = "-1";
                }
            }
            stateBuilder();
            demographics = new LinkedList<Demographic>();
            demographics.add(white);
            demographics.add(black);
            demographics.add(asian);
            demographics.add(latinX);
            demographics.add(other);
            State homeState = new State(state, demographics);
            states[i] = homeState;
            i++;
        }
        file.close();
        return states;
    }


    /**
     * This method creates Demographic objects from given information. This
     * method also sets the state field and the Demographic fields of the class.
     */
    private void stateBuilder() {
        state = strArr[0];
        String whiteCases = strArr[1];
        String blackCases = strArr[2];
        String latinoCases = strArr[3];
        String asianCases = strArr[4];
        String otherCases = strArr[5];
        String whiteDeaths = strArr[6];
        String blackDeaths = strArr[7];
        String latinoDeaths = strArr[8];
        String asianDeaths = strArr[9];
        String otherDeaths = strArr[10];
        white = new Demographic("white", state, whiteCases, whiteDeaths);
        black = new Demographic("black", state, blackCases, blackDeaths);
        asian = new Demographic("asian", state, asianCases, asianDeaths);
        latinX = new Demographic("latinx", state, latinoCases, latinoDeaths);
        other = new Demographic("other", state, otherCases, otherDeaths);
    }
}
