package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class constructs FileReader objects methods that obtain their field
 * data and compares objects to eachother.
 * 
 * @author Matthew Ho (matthew00) & Baylor Lin (baylorl)
 * @version (11.21.2020)
 */
public class FileReader {

    /**
     * This method scans a file and creates Demographic objects, a LinkedList of
     * Demographic objects, and a list of states.
     * 
     * @param fileName
     *            the file to read
     * @throws FileNotFoundException
     */
    public State[] readFile(String fileName) throws FileNotFoundException {
        State[] states = new State[6];
        Scanner file = new Scanner(new File(fileName));
        String line = file.nextLine();
        int i = 0;
        while (file.hasNextLine() && i < 6) {
            line = file.nextLine();
            String[] strArr = line.split(",");
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals("NA")) {
                    strArr[j] = "-1";
                }
            }
            String state = strArr[0];
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
            Demographic white = new Demographic("white", state, whiteCases,
                whiteDeaths);
            Demographic black = new Demographic("black", state, blackCases,
                blackDeaths);
            Demographic latino = new Demographic("latinx", state, latinoCases,
                latinoDeaths);
            Demographic asian = new Demographic("asian", state, asianCases,
                asianDeaths);
            Demographic other = new Demographic("other", state, otherCases,
                otherDeaths);
            LinkedList<Demographic> demographics =
                new LinkedList<Demographic>();
            demographics.add(white);
            demographics.add(black);
            demographics.add(latino);
            demographics.add(asian);
            demographics.add(other);
            State homeState = new State(state, demographics);
            states[i] = homeState;
            i++;
        }
        file.close();
        return states;
    }
}
