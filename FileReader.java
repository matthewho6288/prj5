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
     * FileReader Constructor
     * 
     */
    public FileReader() {
    }


    /**
     * Helper method to read the file
     * 
     * @param file
     *            is the file to read
     * @throws FileNotFoundException
     */
    public State[] readFile(String fileName) throws FileNotFoundException {
        State[] states = new State[6];
        Scanner file = new Scanner(new File(fileName));
        String line = file.nextLine();
        int i = 0;
        while (file.hasNextLine() && i < 6) {
            line = file.nextLine();
            String[] strArr = line.split(" *");
            String state = strArr[0];
            int whiteCases = Integer.valueOf(strArr[1]);
            int blackCases = Integer.valueOf(strArr[2]);
            int latinoCases = Integer.valueOf(strArr[3]);
            int asianCases = Integer.valueOf(strArr[4]);
            int otherCases = Integer.valueOf(strArr[5]);
            int whiteDeaths = Integer.valueOf(strArr[6]);
            int blackDeaths = Integer.valueOf(strArr[7]);
            int latinoDeaths = Integer.valueOf(strArr[8]);
            int asianDeaths = Integer.valueOf(strArr[9]);
            int otherDeaths = Integer.valueOf(strArr[10]);

            Demographic white = new Demographic("White", state, whiteCases,
                whiteDeaths);
            Demographic black = new Demographic("black", state, blackCases,
                blackDeaths);
            Demographic latino = new Demographic("latino", state, latinoCases,
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
        }
        return states;
    }
}
