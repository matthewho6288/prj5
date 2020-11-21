package prj5;

public interface List<T> {
    /**
     * This obtains the amount of elements in the list.
     * 
     * @return the number of objects in the list.
     */
    public int size();


    /**
     * This method adds an object to the end of the list.
     * 
     * @param newEntry
     *            an object to be added
     */
    public void add(T newEntry);


    /**
     * This method adds an object a specific position.
     * 
     * @param newPosition
     *            an integer representing a specified position of where to add
     *            the object
     * @param newEntry
     *            the object that will be added to the list
     */
    public void add(int newPosition, T newEntry);


    /**
     * This method removes an object at a given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the object to be
     *            removed
     */
    public boolean remove(int givenPosition);


    /**
     * Replaces an object at a specified position with another object.
     * 
     * @param givenPosition
     *            an integer representing the position of the object that will
     *            be replaced
     * @param newEntry
     *            a new object that will replace the original object at the
     *            given position
     */
    public void replace(int givenPosition, T newEntry);


    /**
     * This method obtains the object at the given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the entry that will be
     *            obtained
     */
    public T getEntry(int givenPosition);


    /**
     * The method determines if the list is empty.
     * 
     * @return true if the list has no elements, false otherwise
     */
    public boolean isEmpty();


    /**
     * This method removes all the objects from the list.
     */
    public void clear();


    /**
     * This method converts the list into a string representation of the list.
     * 
     * @return the list in string form
     */
    public String toString();
}
