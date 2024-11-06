package com.sachkomaxim.lab6.collections;

import com.sachkomaxim.lab6.tariff.Tariff;

import java.lang.reflect.Array;
import java.util.*;

/**
 * TariffList is a custom implementation of the List interface
 * specifically for Tariff objects using a doubly linked list structure.
 * It supports standard list operations such as add, remove, and sort.
 *
 * @param <T> The type of elements held in this list, must extend Tariff.
 */
public class TariffList<T extends Tariff> implements List<T> {

    /**
     * Underlying doubly linked list.
     */
    private final DoubleLinkedList<T> list;

    /**
     * Constructs an empty TariffList.
     */
    public TariffList() {
        this.list = new DoubleLinkedList<>();
    }

    /**
     * Constructs a TariffList with a single element.
     *
     * @param t The initial element to add to the list.
     */
    public TariffList(T t) {
        this();
        add(t);
    }

    /**
     * Constructs a TariffList and adds all elements from a given collection.
     *
     * @param c The collection containing elements to be added to this list.
     */
    public TariffList(Collection<T> c) {
        this();
        this.addAll(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size(); // Returns the size of the list
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty(); // Checks if the list is empty
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        return list.contains(o); // Checks if the list contains a specific object
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return index < size(); // Checks if there are more elements
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements");
                return list.get(index++); // Returns the next element
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = list.get(i); // Fills the array with elements from the list
        }
        return array; // Returns filled array
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size()) {
            return (T1[]) Array.newInstance(a.getClass().getComponentType(), size()); // Creates a new array if the provided one is too small
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = (T1) list.get(i); // Fills the provided array with elements from the list
        }
        if (a.length > size()) {
            a[size()] = null; // Null-terminate the array if it's larger than the list
        }
        return a; // Returns filled array
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(T t) {
        list.add(t); // Adds an element to the end of the list
        return true; // Always returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) {
                list.remove(i); // Removes the element if it is present
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) return false; // Checks if the list contains all elements in the specified collection
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true; // Returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T t : c) {
            add(index++, t);
        }
        return true; // Returns true as per List contract
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c) {
            if (remove(o)) changed = true; // Marks the list as changed if any elements were removed
        }
        return changed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            if (!c.contains(list.get(i))) {
                remove(i--); // Removes elements not in the specified collection
                changed = true; // Marks the list as changed
            }
        }
        return changed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sort(Comparator<? super T> c) {
       list.sort(c); // Sorts this list according to the order induced by the specified comparator
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            list.remove(0); // Clears the list, removing all elements
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        return list.get(index); // Gets and returns the element at the specified index
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T t) {
        T old = list.get(index);
        list.remove(index);
        list.add(t, index); // Replaces the element at the specified index
        return old; // Returns the element previously at the specified position
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, T t) {
        this.list.add(t, index); // Inserts the specified element at the specified position in the list
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        return list.remove(index); // Removes the element at the specified index and returns it
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (list.get(i).equals(o)) return i;
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (list.get(i).equals(o)) return i;
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<>() {
            private int currentIndex = 0; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Checks if there are more elements
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements");
                return list.get(currentIndex++); // Returns the next element
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0; // Checks if there is a previous element
            }

            @Override
            public T previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No more elements");
                return list.get(--currentIndex); // Returns the previous element
            }

            @Override
            public int nextIndex() {
                return currentIndex; // Returns the index of the next element
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1; // Returns the index of the previous element
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove elements from an empty list");
                list.remove(--currentIndex); // Removes the last returned element
            }

            @Override
            public void set(T t) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set elements from an empty list");
                list.set(t, currentIndex - 1); // Replaces the last returned element
            }

            @Override
            public void add(T t) {
                list.add(t, currentIndex++); // Inserts the specified element into the list
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return new ListIterator<>() {
            private int currentIndex = index; // Tracks the current index during iteration

            @Override
            public boolean hasNext() {
                return currentIndex < size(); // Checks if there are more elements
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException("No more elements");
                return list.get(currentIndex++); // Returns the next element
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0; // Checks if there is a previous element
            }

            @Override
            public T previous() {
                if (!hasPrevious()) throw new NoSuchElementException("No more elements");
                return list.get(--currentIndex); // Returns the previous element
            }

            @Override
            public int nextIndex() {
                return currentIndex; // Returns the index of the next element
            }

            @Override
            public int previousIndex() {
                return currentIndex - 1; // Returns the index of the previous element
            }

            @Override
            public void remove() {
                if (currentIndex == 0) throw new IllegalStateException("Cannot remove elements from an empty list");
                list.remove(--currentIndex); // Removes the last returned element
            }

            @Override
            public void set(T t) {
                if (currentIndex == 0) throw new IllegalStateException("Cannot set elements from an empty list");
                list.set(t, currentIndex - 1); // Replaces the last returned element
            }

            @Override
            public void add(T t) {
                list.add(t, currentIndex++); // Inserts the specified element into the list
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) throw new IndexOutOfBoundsException("Invalid fromIndex (bigger than toIndex): " + fromIndex);
        if (fromIndex < 0) throw new IndexOutOfBoundsException("Invalid fromIndex (negative): " + fromIndex);
        if (toIndex > size()) throw new IndexOutOfBoundsException("Invalid toIndex (bigger than size): " + toIndex);
        TariffList<T> subList = new TariffList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(list.get(i)); // Creates a sublist from the specified range
        }
        return subList;
    }
}
