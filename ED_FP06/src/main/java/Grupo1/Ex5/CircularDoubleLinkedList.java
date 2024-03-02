/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex5;

import Abstratas.AbstractCircularDoubleLinkedList;
import Interfaces.OrderedListADT;
import Throws.NonComparableElementException;
import java.util.Iterator;

/**
 * Implementação de uma lista duplamente encadeada e circular que estende a classe
 * AbstractCircularDoubleLinkedList e implementa a interface OrderedListADT.
 * @param <T> Tipo dos elementos armazenados na lista.
 * @version 1.0
 * @author Leona
 */
public class CircularDoubleLinkedList<T> extends AbstractCircularDoubleLinkedList<T> implements OrderedListADT<T> {

    /**
     * Construtor padrão que cria uma CircularDoubleLinkedList vazia.
     */
    public CircularDoubleLinkedList() {
        super();
    }

    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("NonComparableElementException");
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (isEmpty()) {
            front = rear = newNode;
            front.setNext(front);
            front.setPrev(rear);
        } else if (((Comparable<T>) element).compareTo(front.getElement()) < 0) {
            newNode.setNext(front);
            front.setPrev(newNode); // Adjust the previous reference for the current front
            front = newNode;
            rear.setNext(front);
        } else {
            DoubleNode<T> current = front.getNext();
            DoubleNode<T> previous = front;

            while (current != front && ((Comparable<T>) element).compareTo(current.getElement()) > 0) {
                previous = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            newNode.setPrev(previous);
            previous.setNext(newNode);
            current.setPrev(newNode);

            if (current == front) {
                rear = newNode;
            }
        }

        count++;
        modCount++;
    }

    // Método para inverter a lista
    public void reverse() {
        if (isEmpty()) {
            return; // Nothing to reverse
        }

        DoubleNode<T> current = front;
        DoubleNode<T> nextNode;
        DoubleNode<T> temp = null;

        do {
            nextNode = current.getNext();
            current.setNext(temp);
            current.setPrev(nextNode); // Adjust the previous reference
            temp = current;
            current = nextNode;
        } while (current != front);

        // Update front and rear
        rear = front;
        front = temp;
    }

    
}
