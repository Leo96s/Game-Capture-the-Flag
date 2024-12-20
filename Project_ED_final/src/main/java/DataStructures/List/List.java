/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.List;

import Exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * List is an abstract class that provides a basic structure for list implementations.
 *
 * @param <T> the type of elements stored in the list
 */
public abstract class List<T> implements ListADT<T>, Iterable<T> {

    /**
     * The array storing the elements of the list.
     */
    protected T[] list;

    /**
     * The index of the last element in the list.
     */
    protected int rear;

    /**
     * The number of modifications made to the list.
     */
    protected int modCount;

    /**
     * The initial size of the list array.
     */
    protected static final int INITIAL_SIZE = 10;

    /**
     * The factor by which the list array should be expanded when it becomes full.
     */
    protected static final int EXPAND_BY = 2;

    /**
     * Represents that an element or index was not found in the list.
     */
    protected static final int NOT_FOUND = -1;

    /**
     * Constructs a list with the specified initial size.
     *
     * @param initialSize the initial size of the list
     */
    public List(int initialSize) {
        this.list = (T[]) (new Object[initialSize]);
    }

    /**
     * Constructs a list with the default initial size.
     */
    public List() {
        this(INITIAL_SIZE);
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        T result = list[0];

        for (int i = 0; i < rear - 1; i++) {
            list[i] = list[i + 1];
        }

        list[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        T result = list[rear - 1];
        list[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public T remove(T element) {
         int index = find(element);

        if (index == NOT_FOUND) {
            throw new NoSuchElementException("DataStructures/List");
        }

        T result = list[index];

        for (int i = index; i < rear - 1; i++) {
            list[i] = list[i + 1];
        }

        list[rear - 1] = null;
        rear--;
        modCount++;

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        return list[0];
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        return list[rear - 1];
    }

    protected int find(T target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                return i; // Elemento encontrado, retorna o índice
            }
        }
        return NOT_FOUND;
    }

    protected void expandCapacity() {
        T[] newArray = (T[]) (new Object[EXPAND_BY * rear]);

        System.arraycopy(list, 0, newArray, 0, rear);

        list = newArray;
    }

    @Override
    public boolean contains(T target) {
        return find(target) != NOT_FOUND;
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T data : this) {
            sb.append(data).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(modCount);
    }

    private class MyIterator<T> implements Iterator<T> {

        private int expectedModCount;
        private boolean okToRemove;
        private int current;

        public MyIterator(int expectedModcount) {
            this.expectedModCount = modCount;
            this.okToRemove = false;
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return (current != size());
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("DataStructures/List");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("DataStructures/List");
            }

            okToRemove = true;

            return (T) list[current++];
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("List has been modified");
            }

            if (!okToRemove) {
                throw new IllegalStateException("Call next() before remove()");
            }

            int targetIndex = current - 1;// Store the previous node

            // Shift elements to the left to remove the target element
            for (int i = targetIndex; i < rear - 1; i++) {
                list[i] = list[i + 1];
            }

            // Null out the last element
            list[rear - 1] = null;

            rear--;

            expectedModCount++;
            okToRemove = false; // Reset the flag
        }

    }
}
