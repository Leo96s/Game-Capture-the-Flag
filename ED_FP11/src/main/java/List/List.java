/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;

import Throws.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Leona
 * @param <T>
 */
public abstract class List<T> implements ListADT<T>, Iterable<T> {

    protected T[] list;

    protected int rear;
    protected int modCount;

    protected static final int INITIAL_SIZE = 10;
    protected static final int EXPAND_BY = 2;
    protected static final int NOT_FOUND = -1;

    public List(int initialSize) {
        this.list = (T[]) (new Object[initialSize]);
    }

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
            throw new NoSuchElementException("List");
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
                throw new ConcurrentModificationException("List");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("List");
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
