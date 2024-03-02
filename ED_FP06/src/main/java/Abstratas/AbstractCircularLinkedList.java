/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstratas;

import Grupo1.Ex4.LinearNode;
import Interfaces.ListADT;
import Throws.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Uma classe abstrata que representa uma lista circular ligada.
 * @param <T> O tipo dos elementos armazenados na lista.
 * @version 1.0
 * @author Leona
 */
public abstract class AbstractCircularLinkedList<T> implements ListADT<T> {

    protected AbstractCircularLinkedList<T> list;  // Referência para a própria lista
    protected LinearNode<T> front;                  // Referência para o primeiro nó da lista
    protected LinearNode<T> rear;                   // Referência para o último nó da lista
    protected int modCount;                         // Contador de modificações na lista
    protected int count;                            // Contador de elementos na lista

    /**
     * Construtor que inicializa uma lista circular ligada vazia.
     */
    public AbstractCircularLinkedList() {
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
        if (front == rear) {
            // If there is only one element, set front and rear to null
            front = rear = null;
        } else {
            // If there is more than one element, adjust the circular reference
            front = front.getNext();
            rear.setNext(front); // Adjust the circular reference
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
        if (front == rear) {
            // If there is only one element, set front and rear to null
            front = rear = null;
        } else {
            // If there is more than one element, adjust the circular reference
            LinearNode<T> current = front;
            while (current.getNext() != rear) {
                current = current.getNext();
            }
            rear = current;
            rear.setNext(front); // Adjust the circular reference
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
        LinearNode<T> current = front;
        LinearNode<T> prev = null;

        while (current != null && !current.getElement().equals(element)) {
            prev = current;
            current = current.getNext();
        }

        if (current != null) {
            LinearNode<T> nextNode = current.getNext();

            if (prev != null) {
                prev.setNext(nextNode);
            } else {
                front = nextNode;
            }

            if (nextNode == null) {
                rear = prev;
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
        LinearNode<T> current = front;

        do{ 
            if (current.getElement().equals(target)) {
                return current.getElement();
            }
            current = current.getNext();
        }while(current != null);
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

    public AbstractCircularLinkedList<T> getList() {
        return list;
    }

    public void setList(AbstractCircularLinkedList<T> list) {
        this.list = list;
    }

    public LinearNode<T> getFront() {
        return front;
    }

    public void setFront(LinearNode<T> front) {
        this.front = front;
    }

    public LinearNode<T> getRear() {
        return rear;
    }

    public void setRear(LinearNode<T> rear) {
        this.rear = rear;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        LinearNode<T> current = front;

        do {
            sb.append(current.getElement()).append(", ");
            current = current.getNext();
        } while (current != front);

        sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
