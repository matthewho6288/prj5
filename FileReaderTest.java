package prj5;

import java.io.FileNotFoundException;
import student.TestCase;

/**
 * This class tests the constructor and methods in the FileReader class.
 * 
 * @author Matthew Ho (matthew00)
 * @version (12.3.2020)
 *
 */
public class FileReaderTest extends TestCase {
    private FileReader reader;

    /**
     * This method sets up a FileReader object.
     */
    public void setUp() {
        reader = new FileReader();
    }


    /**
     * This method tests the readFile() method and the private helper method,
     * stateBuilder().
     * 
     * @throws FileNotFoundException
     */
    public void testReadFile() throws FileNotFoundException {
        State[] states = reader.readFile(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        assertNotNull(states);
        assertEquals("DC\n" + "asian: 5407 cases, 4.7% CFR\n"
            + "black: 179563 cases, 7.4% CFR\n"
            + "latinx: 97118 cases, 2.3% CFR\n"
            + "other: 108784 cases, 0.2% CFR\n"
            + "white: 70678 cases, 2.7% CFR\n" + "=====\n"
            + "black: 179563 cases, 7.4% CFR\n"
            + "asian: 5407 cases, 4.7% CFR\n" + "white: 70678 cases, 2.7% CFR\n"
            + "latinx: 97118 cases, 2.3% CFR\n"
            + "other: 108784 cases, 0.2% CFR\n" + "=====", states[0]
                .toString());
    }


    /**
     * This method tests the readFile() method when the file does not exist.
     */
    public void testException() {
        Exception exception = null;
        try {
            reader.readFile("file");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof FileNotFoundException);
    }
}
