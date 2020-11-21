package prj5;

public class LinkedList<T> implements List<T>{
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
        // empty list case
        if (isEmpty()) {
            firstNode = new Node<T>(newEntry);
        }
        // other cases
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
        if (!inBounds(newPosition)) {
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
                Node<T> nextNode = null;
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
     * This method removes an object at a given position.
     * 
     * @param givenPosition
     *            an integer representing the position of the object to be
     *            removed
     */
    @Override
    public boolean remove(int givenPosition) {
        if (!inBounds(givenPosition) || firstNode == null) {
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
            return true;
        }
    }


    private boolean inBounds(int index) {
        return !(isEmpty() || index < 0 || index >= size());
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
        remove(givenPosition - 1);
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
            throw new IndexOutOfBoundsException("newPosition exceeds the size.");
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

    public class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            next = null;
        }


        public Node(E data, Node<E> node) {
            this.data = data;
            next = node;
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
