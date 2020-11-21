package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private LinkedList<T> currList = this;
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * 
     */
    public LinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * This obtains the amount of elements in the list.
     * 
     * @return the number of newEntryects in the list.
     */
    @Override
    public int size() {
        return numberOfEntries;
    }


    /**
     * This method adds an object to the end of the list.
     * 
     * @param newEntry
     *            an object to be added
     */
    @Override
    public void add(T newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException("newEntry is null");
        }
        Node<T> current = firstNode;
        if (isEmpty()) {
            firstNode = new Node<T>(newEntry);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNextNode(new Node<T>(newEntry));
        } 
        numberOfEntries++;
    }


    /**
     * This method adds an object a specific position.
     * 
     * @param newPosition
     *            an integer representing a specified position of where to add
     *            the object
     * @param newEntry
     *            the object that will be added to the list
     */
    @Override
    public void add(int newPosition, T newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException("newEntry is null");
        }
        if (newPosition != 0 && !inBounds(newPosition)) {
            throw new IndexOutOfBoundsException("newPosition is out of bounds");
        }
        if (isEmpty()) {
            add(newEntry);
        }
        else {
            if (newPosition == 0) {
                Node<T> newNode = new Node<T>(newEntry);
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else {
                Node<T> newNode = new Node<T>(newEntry);
                Node<T> prevNode = firstNode;
                Node<T> nextNode = prevNode.next;
                for (int i = 0; i < newPosition - 1; i++) {
                    prevNode = prevNode.next;
                    nextNode = prevNode.next;
                }
                newNode.setNextNode(nextNode);
                prevNode.setNextNode(newNode);
            }
            numberOfEntries++;
        }
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int firstIndexOf(T listEntry) {
        Node<T> current = firstNode;
        for (int i = 0; i < size(); i++) {
            if (current.getData().equals(listEntry)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }


    /**
     * This method removes an object at a given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the object to be
     *            removed
     */
    @Override
    public boolean remove(int givenPosition) {
        if (!inBounds(givenPosition)) {
            throw new IndexOutOfBoundsException(
                "givenPosition is out of bounds");
        }
        if (givenPosition == 0) {
            Node<T> current = firstNode;
            firstNode = current.getNextNode();
            numberOfEntries--;
            return true;
        }
        else {
            Node<T> prevNode = firstNode;
            Node<T> nextNode = null;
            for (int i = 0; i < givenPosition - 1; i++) {
                prevNode = prevNode.next;
                nextNode = prevNode.next;
                nextNode = nextNode.next;
            }
            prevNode.setNextNode(nextNode);
            numberOfEntries--;
            return true;
        }
    }


    /**
     * This method determines if index is within the bounds of the list.
     * 
     * @param index
     *            an integer representing the index
     * @return true if the list is not empty and the index is greater than 0 and
     *         less than the size of the list
     */
    private boolean inBounds(int index) {
        return !(index < 0 || index >= size());
    }


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
    @Override
    public void replace(int givenPosition, T newEntry) {
        add(givenPosition, newEntry);
        remove(givenPosition + 1);
    }


    /**
     * This method obtains the object at the given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the entry that will be
     *            obtained
     */
    @Override
    public T getEntry(int givenPosition) {
        Node<T> current = firstNode;
        int currentnewPosition = 0;
        T data = null;
        while (current != null) {
            if (currentnewPosition == givenPosition) {
                data = current.data;
            }
            currentnewPosition++;
            current = current.next;
        }
        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException(
                "newPosition exceeds the size.");
        }
        return data;
    }


    /**
     * The method determines if the list is empty.
     * 
     * @return true if the list has no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * This method removes all the objects from the list.
     */
    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * This method converts the list into a string representation of the list.
     * 
     * @return the list in string form
     */
    @Override
    public String toString() {
        String str = "{";
        Node<T> current = firstNode;
        while (current != null) {
            str += "" + current.data;
            current = current.next;
            if (current != null) {
                str += ", ";
            }
        }
        str += "}";
        return str;
    }


    @SuppressWarnings("unchecked")
    public void cfrSort() {
        if (firstNode.getData().getClass() == Demographic.class) {
            Iterator<Demographic> it = (Iterator<Demographic>)this.iterator();
            Demographic first = it.next();
            it.remove();
            for (int i = 1; i < size(); i++) {
                for (int k = 0; k < size() - 1; k++) {
                    Demographic nex = it.next();
                    it.remove();
                    if (first.cfr() < nex.cfr()) {
                        Demographic temp = first;
                        this.add((T)nex);
                        this.add((T)temp);
                    }
                }
            }
        }

    }
    /**
     * This method creates a LinkedListIterator object
     * 
     * @return a LinkedListIterator object
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }

    private class LinkedListIterator<A> implements Iterator<T> {
        private Node<T> head = firstNode;
        private Node<T> nextNode = null;
        private Node<T> deletedNode = null;
        private boolean wasNextCalled = false;

        public LinkedListIterator() {
            nextNode = head;
        }


        @Override
        public boolean hasNext() {
            return nextNode != null;
        }


        @Override
        public T next() {
            if (hasNext()) {
                wasNextCalled = true;
                Node<T> returnNode = nextNode;
                deletedNode = returnNode;
                nextNode = nextNode.next;
                return returnNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call to next()");
            }
        }


        public void remove() {
            if (wasNextCalled) {
                currList.remove(currList.firstIndexOf(deletedNode.data));
                wasNextCalled = false;
                deletedNode = null;
            }
            else {
                throw new IllegalStateException(
                    "Illegal call to remove() next() was not call.");
            }
        }
    }


    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }


        public Node<E> getNextNode() {
            return next;
        }


        public E getData() {
            return data;
        }


        public void setNextNode(Node<E> node) {
            next = node;
        }
    }
}
