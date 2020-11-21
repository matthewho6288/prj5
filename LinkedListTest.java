package prj5;

import student.TestCase;

public class LinkedListTest extends TestCase {
    private LinkedList<String> llist;
    public void setUp() {
        llist = new LinkedList<String>();
    }


    public void testSize() {
        assertEquals(0, llist.size());
        assertTrue(llist.isEmpty());
        llist.add("entry");
        assertEquals(1, llist.size());
        assertFalse(llist.isEmpty());
    }
    
    public void testAdd() {
        llist.add("entry1");
        assertEquals(1, llist.size());
        assertEquals("entry1", llist.getEntry(0));
        llist.add("entry2");
        assertEquals(2, llist.size());
        assertEquals("entry2", llist.getEntry(1));
        llist.add(1, "entry3");
        assertEquals(3, llist.size());
        
        System.out.println(llist.toString());
        llist.clear();
        assertTrue(llist.isEmpty());
        System.out.println(llist.toString());
    }
    
    public void testRemove() {
        llist.add("entry1");
        assertEquals(1, llist.size());
        llist.add("entry2");
        assertEquals(2, llist.size());
        llist.add(1, "entry3");
        assertEquals(3, llist.size());
        llist.remove(0);
        assertEquals(2, llist.size());
        llist.remove(1);
        System.out.println(llist.toString());
    }

}
