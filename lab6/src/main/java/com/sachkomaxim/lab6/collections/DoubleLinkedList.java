package com.sachkomaxim.lab6.collections;

import com.sachkomaxim.lab6.tariff.Tariff;

import java.util.Comparator;

/**
 * A doubly linked list implementation for storing Tariff objects.
 * This list supports basic operations such as adding, removing,
 * getting elements by index, and sorting.
 *
 * @param <T> The type of elements in the list, must extend Tariff.
 */
public class DoubleLinkedList<T extends Tariff> {

    /**
     * Private class representing a node in the doubly linked list.
     * Each node contains a value and pointers to the next and previous nodes.
     */
    private class Node {
        T value; // The value stored in the node
        Node next; // Pointer to the next node in the list
        Node prev; // Pointer to the previous node in the list

        public Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Pointer to the first node in the list.
     */
    private Node head;

    /**
     * Pointer to the last node in the list.
     */
    private Node tail;

    /**
     * The size of the list (number of elements).
     */
    private int size;

    /**
     * Default constructor to create an empty list.
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return True if the list is empty;
     *         false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param value The value to be added to the list.
     */
    public void add(T value) {
        Node newNode = new Node(value);

        // If the list is empty, the new node becomes both the head and the tail
        if (isEmpty()) {
            head = newNode;
        } else {
            // Otherwise, append the new node at the end
            tail.next = newNode;
            newNode.prev = tail;
        }

        // Update the tail pointer to the new node
        tail = newNode;
        size++;
    }

    /**
     * Adds a new element at the specified index in the list.
     *
     * @param value The value to be added.
     * @param index The position at which to add the value.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void add(T value, int index) {
        isIndexOutOfBounds(index); // Validate index

        Node newNode = new Node(value);

        // Insert at the beginning of the list
        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
        // Insert at the end of the list
        else if (index == size) {
            add(value);
        }
        // Insert at any other position in the list
        else {
            Node currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }

            newNode.prev = currentNode.prev;
            newNode.next = currentNode.next;
            currentNode.next.prev = newNode;
            currentNode.prev = newNode;
        }

        size++;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public T get(int index) {
        isIndexOutOfBounds(index); // Validate index

        Node currentNode = head;

        // Traverse the list to find the element at the given index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index The index of the element to remove.
     * @return The removed element.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public T remove(int index) {
        isIndexOutOfBounds(index); // Validate index

        Node currentNode = head;

        // Traverse the list to find the element at the given index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // Re-link the previous node to the next node, or update head if the first node is removed
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        // Re-link the next node to the previous node, or update tail if the last node is removed
        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;
        }

        size--;

        return currentNode.value;
    }

    /**
     * Checks whether the list contains the specified value.
     *
     * @param value The value to check for.
     * @return True if the value is in the list;
     *         false otherwise.
     */
    public boolean contains(Object value) {
        Node currentNode = head;

        // Traverse the list and compare each element with the specified value
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Sets the element at the specified index to the given value.
     *
     * @param value The new value to set.
     * @param index The index of the element to update.
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void set(T value, int index) {
        isIndexOutOfBounds(index); // Validate index

        Node currentNode = head;

        // Traverse the list to find the element at the given index
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // Update the value at the specified index
        currentNode.value = value;
    }

    /**
     * Sorts the elements in the list using the specified comparator. The
     * list is sorted in place using the insertion sort algorithm.
     *
     * @param comparator The comparator to use for sorting.
     */
    public void sort(Comparator<? super T> comparator) {
        if (size <= 1) return; // No need to sort if there is one or zero elements

        Node currentNode = head.next;

        // Perform insertion sort on the linked list
        while (currentNode != null) {
            T key = currentNode.value;
            Node prevNode = currentNode.prev;

            // Move elements that are greater than the key to one position ahead
            while (prevNode != null && comparator.compare(prevNode.value, key) > 0) {
                prevNode.next.value = prevNode.value;
                prevNode = prevNode.prev;
            }

            // Insert the key into its correct position
            if (prevNode == null) {
                head.value = key;
            } else {
                prevNode.next.value = key;
            }

            currentNode = currentNode.next;
        }
    }

    /**
     * Validates whether the given index is within the valid range. Throws
     * an IndexOutOfBoundsException if the index is invalid.
     *
     * @param index The index to validate.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    private void isIndexOutOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
