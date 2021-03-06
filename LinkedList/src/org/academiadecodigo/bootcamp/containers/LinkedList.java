package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(T data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {
        int counter = 0;
        Node iterator = head.getNext();

        if (index >= length) {
            return null;
        }

        while (counter != index) {
            iterator = iterator.getNext();
            counter++;
        }
        return iterator.getData();
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {

        int counter = 0;
        Node iterator = head.getNext();

        while (iterator != null) {
            if (iterator.getData() == data) {
                return counter;
            }
            iterator = iterator.getNext();
            counter++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {
        Node iterator = head.getNext();
        Node previousIterator = head;

        while (iterator != null) {
            if (iterator.getData() == data) {
                previousIterator.setNext(iterator.getNext());
                length--;
                return true;
            }
            previousIterator = previousIterator.getNext();
            iterator = iterator.getNext();
        }

        return false;

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class LinkedIterator implements Iterator<T> {

        private Node pointer = head;

        @Override
        public boolean hasNext() {
            return pointer.getNext() != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                pointer = pointer.getNext();
                return pointer.getData();
            }
            throw new NoSuchElementException();
        }

    }
}
