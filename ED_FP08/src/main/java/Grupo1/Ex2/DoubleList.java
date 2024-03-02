/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex2;

import Grupo1.Ex2.DoubleNode;
import Interfaces.ListADT;
import Throws.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Leona
 * @param <T>
 */
public abstract class DoubleList<T> implements ListADT<T>, Iterable<T> {
    
    protected DoubleList<T> list;

    protected DoubleNode<T> front;
    protected DoubleNode<T> rear;
    protected int modCount;
    protected int count;

    public DoubleList() {
         front = rear = null;
         modCount = 0;
         count = 0;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

         T result = front.getElement();
        front = front.getNext();
        if (front != null) {
            front.setPrev(null);
        } else {
            rear = null;
        }
        modCount++;
        count--;

        return result;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        T result = rear.getElement();
        rear = rear.getPrev();
        if (rear != null) {
            rear.setNext(null);
        } else {
            front = null;
        }
        modCount++;
        count--;

        return result;
    }

    @Override
    public T remove(T element) {
         if (!contains(element)) {
        throw new NoSuchElementException("Element not found in the list.");
    }

    T removed = null;
    DoubleNode<T> current = front;

    while (current != null && !current.getElement().equals(element)) {
        current = current.getNext();
    }

    if (current != null) {
        DoubleNode<T> prevNode = current.getPrev();
        DoubleNode<T> nextNode = current.getNext();

        if (prevNode != null) {
            prevNode.setNext(nextNode);
        } else {
            front = nextNode;
        }

        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        } else {
            rear = prevNode;
        }

        modCount++;
        count--;
        removed = current.getElement();
    }

    return removed;
}

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        return front.getElement();
    }

    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty list");
        }

        return rear.getElement();
    }

    private T find(T target) {
        DoubleNode<T> current = front;

         while (current != null) {
             if(current.getElement().equals(target)){
                 return (T) current;
             }
        current = current.getNext();
    }
        return null;
    }

    @Override
    public boolean contains(T target) {
        return find(target) != null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append ("[");
        for (T data : this) {
            sb.append(data).append(" ");
        }
        sb.append("]");
        sb.append(", front=").append(front);
        sb.append(", rear=").append(rear);
        sb.append(", modCount=").append(modCount);
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private int expectedModCount;
        private boolean okToRemove;
        private DoubleNode<T> current;

        public MyIterator() {
            this.expectedModCount = modCount;
            this.okToRemove = false;
            this.current = front;
        }

        @Override
        public boolean hasNext() {
            return current != null;
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

            T element = current.getElement();
            current = current.getNext();
            return element;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("List has been modified");
            }

            if (!okToRemove) {
                throw new IllegalStateException("Call next() before remove()");
            }

            DoubleNode<T> target = current.getPrev();// Store the previous node

            // Update pointers to remove the target node
            if (target.getPrev() != null) {
                target.getPrev().setNext(current);
            } else {
                // Removing the first element
                front = current;
            }
            if (current != null) {
                current.setPrev(target.getPrev());
            } else {
                // Removing the last element
                rear = target.getPrev();
            }

            expectedModCount++;
            okToRemove = false; // Reset the flag
        }
    }
}
