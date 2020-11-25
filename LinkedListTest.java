package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * This class tests the methods in the LinkedList class.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.20.2020)
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> llist;

    /**
     * This sets up a LinkedList of Strings
     */
    public void setUp() {
        llist = new LinkedList<String>();
    }


    /**
     * This tests the size() method.
     */
    public void testSize() {
        assertEquals(0, llist.size());
        assertTrue(llist.isEmpty());
        llist.add("entry");
        assertEquals(1, llist.size());
        assertFalse(llist.isEmpty());
    }


    /**
     * This method test both add() methods.
     */
    public void testAdd() {
        assertEquals("{}", llist.toString());
        llist.add(0, "egn");
        llist.remove(0);
        llist.add("entry1");
        assertEquals(1, llist.size());
        assertEquals("entry1", llist.getEntry(0));
        assertEquals("\n" + "entry1\n" + "=====", llist.toString());
        llist.add("entry2");
        assertEquals(2, llist.size());
        assertEquals("entry2", llist.getEntry(1));
        assertEquals("\n" + "entry1\n" + "entry2\n" + "=====", llist.toString());
        llist.add(0, "entry3");
        assertEquals(3, llist.size());
        assertEquals("\n" + "entry3\n" + "entry1\n" + "entry2\n" + "=====", llist
            .toString());
        llist.add(1, "entry3");
        assertEquals("\n" + "entry3\n" + "entry3\n" + "entry1\n" + "entry2\n"
            + "=====", llist.toString());
        llist.add("newEntry");
        assertEquals(5, llist.size());
        assertEquals("\n" + "entry3\n" + "entry3\n" + "entry1\n" + "entry2\n"
            + "newEntry\n" + "=====", llist.toString());
        llist.add(4, "entry4");
        assertEquals("\n" + "entry3\n" + "entry3\n" + "entry1\n" + "entry2\n"
            + "entry4\n" + "newEntry\n" + "=====", llist.toString());
        llist.clear();
        assertTrue(llist.isEmpty());
    }


    /**
     * This method tests the firstIndexOf() method.
     */
    public void testFirstIndexOf() {
        llist.add("entry1");
        assertEquals(0, llist.firstIndexOf("entry1"));
        assertEquals(-1, llist.firstIndexOf("entry2"));
    }


    /**
     * This tests the add() methods for their exceptions.
     */
    public void testAddExceptions() {
        //
        String strNull = null;
        Exception exception = null;
        try {
            llist.add(strNull);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        //
        exception = null;
        try {
            llist.add(0, strNull);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
        //
        exception = null;
        try {
            llist.add(-1, "entry1");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * This tests the remove() method.
     */
    public void testRemove() {
        llist.add("entry1");
        llist.add("entry2");
        llist.add(1, "entry3");
        assertEquals(3, llist.size());
        llist.remove(2);
        assertEquals(2, llist.size());
        llist.remove(1);
        assertEquals(1, llist.size());
    }


    /**
     * This tests the remove() method for its exceptions.
     */
    public void testRemoveExceptions() {
        Exception exception = null;
        try {
            llist.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        llist.add("entry");
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        try {
            llist.remove(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * This tests the getEntry() method for its exceptions.
     */
    public void testGetEntryException() {
        Exception exception = null;
        try {
            llist.getEntry(0);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * This tests the iterator methods hasNext() and next().
     */
    public void testIterator() {
        llist.add("entry1");
        llist.add("entry2");
        llist.add("entry3");
        llist.add("entry4");
        Iterator<String> it = llist.iterator();
        assertTrue(it.hasNext());
        assertEquals("entry1", it.next());
        assertEquals("entry2", it.next());
        assertEquals("entry3", it.next());
        assertEquals("entry4", it.next());
        assertFalse(it.hasNext());
    }


    /**
     * This tests the remove() method of the iterator.
     */
    public void testIteratorRemove() {
        llist.add("entry1");
        llist.add("entry2");
        llist.add("entry3");
        llist.add("entry4");
        assertEquals(4, llist.size());
        Iterator<String> it = llist.iterator();
        assertEquals("entry1", it.next());
        assertEquals(0, llist.firstIndexOf("entry1"));
        it.remove();
        assertEquals(3, llist.size());
        assertEquals("\n" + "entry2\n" + "entry3\n" + "entry4\n" + "=====", llist
            .toString());
        assertEquals("entry2", it.next());
        it.remove();
        assertEquals("\n" + "entry3\n" + "entry4\n" + "=====", llist.toString());
        assertEquals("entry3", it.next());
        it.remove();
        assertEquals("\n" + "entry4\n" + "=====", llist.toString());
    }


    /**
     * This tests the Iterator methods for exceptions.
     */
    public void testIteratorException() {
        llist.add("entry1");
        Iterator<String> it = llist.iterator();
        Exception exception = null;
        assertEquals("entry1", it.next());
        try {
            it.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);
        Iterator<String> it2 = llist.iterator();
        exception = null;
        try {
            it2.remove();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }


    /**
     * This tests the sort methods and the reverse() method.
     */
    public void testSort() {
        llist.cfrSort();
        llist.alphaSort();
        assertEquals("{}", llist.toString());
        llist.add("q");
        llist.add("3");
        assertEquals("\n" + "q\n" + "3\n" + "=====", llist.toString());
        llist.cfrSort();
        assertEquals("\n" + "q\n" + "3\n" + "=====", llist.toString());
        llist.alphaSort();
        assertEquals("\n" + "q\n" + "3\n" + "=====", llist.toString());
        LinkedList<Demographic> llist2 = new LinkedList<Demographic>();
        Demographic white = new Demographic("White", "Virginia", "40000",
            "10000");
        Demographic asian = new Demographic("Asian", "Virginia", "40000",
            "20000");
        Demographic black = new Demographic("Black", "Virginia", "40000",
            "30000");
        Demographic black2 = new Demographic("Black2", "Virginia", "40000",
            "40000");
        Demographic asian2 = new Demographic("Asian", "Virginia", "40000",
            "10000");
        llist2.add(black2);
        llist2.add(white);
        llist2.add(asian);
        llist2.add(black);
        llist2.add(asian2);
        llist2.cfrSort();
        assertEquals("\n" + "Black2: 40000 cases, 100% CFR\n"
            + "Black: 40000 cases, 75% CFR\n" + "Asian: 40000 cases, 50% CFR\n"
            + "Asian: 40000 cases, 25% CFR\n" + "White: 40000 cases, 25% CFR\n"
            + "=====", llist2.toString());
        llist2.remove(0);
        llist2.remove(2);
        llist2.alphaSort();
        assertEquals("\n" + "Asian: 40000 cases, 50% CFR\n"
            + "Black: 40000 cases, 75% CFR\n" + "White: 40000 cases, 25% CFR\n"
            + "=====", llist2.toString());
        Demographic asian3 = new Demographic("Asian", "Virginia", "40000",
            "10000");
        Demographic black3 = new Demographic("Black", "Virginia", "40000",
            "10000");
        Demographic latino = new Demographic("Latino", "Virginia", "40000",
            "10000");
        llist2.clear();
        llist2.add(white);
        llist2.add(latino);
        llist2.add(black3);
        llist2.add(asian3);
        llist2.cfrSort();
        assertEquals("\n" + "Asian: 40000 cases, 25% CFR\n"
            + "Black: 40000 cases, 25% CFR\n" + "Latino: 40000 cases, 25% CFR\n"
            + "White: 40000 cases, 25% CFR\n" + "=====", llist2.toString());
        llist2.clear();
        llist2.add(asian3);
        llist2.add(black3);
        llist2.add(latino);
        llist2.add(white);
        llist2.cfrSort();
        assertEquals("\n" + "Asian: 40000 cases, 25% CFR\n"
            + "Black: 40000 cases, 25% CFR\n" + "Latino: 40000 cases, 25% CFR\n"
            + "White: 40000 cases, 25% CFR\n" + "=====", llist2.toString());
        llist2.clear();
        Demographic asian4 = new Demographic("Asian", "Virginia", "40000",
            "1000");
        llist2.add(asian4);
        llist2.add(black3);
        llist2.add(latino);
        llist2.add(white);
        llist2.cfrSort();
        assertEquals("\n" + "Black: 40000 cases, 25% CFR\n"
            + "Latino: 40000 cases, 25% CFR\n" + "White: 40000 cases, 25% CFR\n"
            + "Asian: 40000 cases, 2.5% CFR\n" + "=====", llist2.toString());
    }
}
