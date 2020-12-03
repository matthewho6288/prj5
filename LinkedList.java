package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates LinkedList objects and methods for those objects. There
 * are also inner classes for iterator objects and node objects.
 * 
 * @author Matthew Ho (matthew00)
 * @version (11.20.2020)
 * @param <T>
 */
public class LinkedList<T> implements List<T> {
    private LinkedList<T> currList = this;
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * This method creates a LinkedList object and sets its initial fields.
     */
    public LinkedList() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * This method obtains the amount of elements in the list.
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
            for (int i = 0; i < size() - 1; i++) {
                current = current.next;
            }
            current.setNextNode(new Node<T>(newEntry));
        }
        numberOfEntries++;
    }


    /**
     * This method adds an object at a specific position.
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
     * This method gets the first time the given object is in the list.
     *
     * @param listEntry
     *            the object to look for
     * @return the first position of it. -1 If it is not in the list
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
     * This method determines if an index is within the bounds of the list.
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
     * This method obtains the object at the given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the entry that will be
     *            obtained
     */
    @Override
    public T getEntry(int givenPosition) {
        if (!inBounds(givenPosition)) {
            throw new IndexOutOfBoundsException(
                "newPosition exceeds the size.");
        }
        Node<T> current = firstNode;
        for (int i = 0; i < givenPosition; i++) {
            current = current.next;
        }
        return current.data;
    }


    /**
     * The method determines if the list is empty.
     * 
     * @return true if the list has no elements, false if it is not
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
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder str = new StringBuilder();
        Node<T> current = firstNode;
        str.append("\n");
        while (current != null) {
            str.append(current.data);
            if (current.next == null) {
                str.append("\n=====");
            }
            else {
                str.append("\n");
            }
            current = current.next;
        }
        return String.valueOf(str);
    }


    /**
     * This method sorts the LinkedList of Demographic objects by largest CFR
     * ratio to lowest CFR ratio.
     */
    @SuppressWarnings({ "unchecked" })
    public void cfrSort() {
        if (!isEmpty() && firstNode.getData().getClass() == Demographic.class) {
            Iterator<Demographic> it = (Iterator<Demographic>)this.iterator();
            Iterator<Demographic> it2;
            LinkedList<Demographic> copy = new LinkedList<Demographic>();
            while (it.hasNext()) {
                copy.add(it.next());
            }
            copy.alphaSort();
            copy.reverse();
            this.clear();
            it = copy.iterator();
            this.add((T)it.next());
            it.remove();
            while (!copy.isEmpty()) {
                it = copy.iterator();
                it2 = (Iterator<Demographic>)this.iterator();
                Demographic insert = it.next();
                it.remove();
                int i = 0;
                while (it2.hasNext()) {
                    Demographic sort = it2.next();
                    if (insert.cfr() > sort.cfr()) {
                        this.add(i, (T)insert);
                        break;
                    }
                    else if (insert.cfr() == sort.cfr()) {
                        this.add(i, (T)insert);
                        break;
                    }
                    else if (i == size() - 1) {
                        this.add((T)insert);
                    }
                    i++;
                }
            }
        }
    }


    /**
     * This method reverses the order of a LinkedList.
     */
    private void reverse() {
        Node<T> current = firstNode;
        Node<T> previous = null;
        while (current != null) {
            Node<T> tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        firstNode = previous;
    }


    /**
     * This method sorts the LinkedList of Demographic objects alphabetically.
     */
    @SuppressWarnings({ "unchecked" })
    public void alphaSort() {
        if (!isEmpty() && firstNode.getData().getClass() == Demographic.class) {
            Iterator<Demographic> it = (Iterator<Demographic>)this.iterator();
            Iterator<Demographic> it2;
            LinkedList<Demographic> copy = new LinkedList<Demographic>();
            while (it.hasNext()) {
                copy.add(it.next());
            }
            this.clear();
            it = copy.iterator();
            this.add((T)it.next());
            it.remove();
            while (!copy.isEmpty()) {
                it = copy.iterator();
                it2 = (Iterator<Demographic>)this.iterator();
                Demographic insert = it.next();
                it.remove();
                int i = 0;
                while (it2.hasNext()) {
                    Demographic sort = it2.next();
                    if (insert.getRace().compareTo(sort.getRace()) < 0) {
                        this.add(i, (T)insert);
                        break;
                    }
                    else if (i == this.size() - 1) {
                        this.add((T)insert);
                    }
                    i++;
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

    /**
     * This inner class provides the constructor and methods for an Iterator
     * object.
     * 
     * @author Matthew Ho (matthew00)
     * @version (11.20.2020)
     * @param <A>
     *            the type of the LinkedList
     */
    private class LinkedListIterator<A> implements Iterator<T> {
        private Node<T> head = firstNode;
        private Node<T> nextNode = null;
        private Node<T> deletedNode = null;
        private boolean wasNextCalled = false;

        /**
         * This constructor creates a LinkedListIterator object and sets the
         * head field.
         */
        public LinkedListIterator() {
            nextNode = head;
        }


        /**
         * This method makes sure that the iterator has another object to call.
         * next.
         * 
         * @return true if the iterator has more items to iterate through.
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }


        /**
         * This method iterates to the next object.
         * 
         * @return the object the iterate traverses to
         */
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


        /**
         * This method removes an item from the LinkedList.
         * 
         * @throws IllegalStateException
         */
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


    /**
     * This inner class provides the constructor and methods for Node objects.
     * 
     * @author Matthew Ho (matthew00)
     * @version (11.20.2020)
     *
     * @param <E>
     *            This is the type of the data contained in the node
     */
    private class Node<E> {
        private E data;
        private Node<E> next;

        /**
         * This constructor creates a node and sets up its initial fields
         * 
         * @param data
         *            the node's data field
         */
        public Node(E data) {
            this.data = data;
            next = null;
        }


        /**
         * This method obtains the next node of "this" node.
         * 
         * @return the next node
         */
        public Node<E> getNextNode() {
            return next;
        }


        /**
         * This method obtains the data contained within the node.
         * 
         * @return the node's data
         */
        public E getData() {
            return data;
        }


        /**
         * This method sets the next node of "this" node.
         * 
         * @param node
         *            the next node
         */
        public void setNextNode(Node<E> node) {
            next = node;
        }
    }
}
