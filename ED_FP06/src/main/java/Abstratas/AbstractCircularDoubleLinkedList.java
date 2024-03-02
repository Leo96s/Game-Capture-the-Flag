/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abstratas;

import Grupo1.Ex4.LinearNode;
import Grupo1.Ex5.DoubleNode;
import Interfaces.ListADT;
import Throws.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Uma classe abstrata que representa uma lista circular duplamente ligada.
 * @param <T> O tipo dos elementos armazenados na lista.
 * @version 1.0
 * @author Leona
 */
public abstract class AbstractCircularDoubleLinkedList<T> implements ListADT<T> {

    protected AbstractCircularDoubleLinkedList<T> list;  // Referência para a própria lista
    protected DoubleNode<T> front;  // Referência para o primeiro nó da lista
    protected DoubleNode<T> rear;   // Referência para o último nó da lista
    protected int modCount;         // Contador de modificações na lista
    protected int count;            // Contador de elementos na lista

    /**
     * Construtor que inicializa uma lista circular duplamente ligada vazia.
     */
    public AbstractCircularDoubleLinkedList() {
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
            front.setPrev(rear);
            rear.setNext(front);
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
            rear = rear.getPrev();
            rear.setNext(front);
            front.setPrev(rear);
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

    do {

        if (current.getElement().equals(element)) {
            DoubleNode<T> prevNode = current.getPrev();
            DoubleNode<T> nextNode = current.getNext();

            if (prevNode != rear) {
                prevNode.setNext(nextNode);
            } else {

                // If the removed node is the front, update front
                front = nextNode;
            }

            if (nextNode != front) {
                nextNode.setPrev(prevNode);
                
            } else {
                // If the removed node is the rear, update rear
                rear = prevNode;
            }
            if (front != null && rear != null) {

                // Update circular links
                rear.setNext(front);
                front.setPrev(rear);
            }
            modCount++;
            count--;

            removed = current.getElement();
            break; // exit the loop once the element is found and removed

        }
        current = current.getNext();

    } while (current != front);

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

        do{
            if (current.getElement().equals(target)) {
                return current.getElement();
            }
            current = current.getNext();
        }while(current != front);
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

    public AbstractCircularDoubleLinkedList<T> getList() {
        return list;
    }

    public void setList(AbstractCircularDoubleLinkedList<T> list) {
        this.list = list;
    }

    public DoubleNode<T> getFront() {
        return front;
    }

    public void setFront(DoubleNode<T> front) {
        this.front = front;
    }

    public DoubleNode<T> getRear() {
        return rear;
    }

    public void setRear(DoubleNode<T> rear) {
        this.rear = rear;
    }


@Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        DoubleNode<T> current = front;

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
