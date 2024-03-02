/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex4;

import Abstratas.AbstractCircularLinkedList;
import Interfaces.OrderedListADT;
import Throws.NonComparableElementException;
import java.util.Iterator;

/**
 * Implementação de uma lista circular que estende a classe AbstractCircularLinkedList
 * e implementa a interface OrderedListADT.
 * @param <T> Tipo dos elementos armazenados na lista.
 * @version 1.0
 * @author Leona
 */
public class CircularLinkedList<T> extends AbstractCircularLinkedList<T> implements OrderedListADT<T> {

    /**
     * Construtor padrão que cria uma CircularLinkedList vazia.
     */
    public CircularLinkedList() {
        super();
    }

    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("NonComparableElementException");
        }

        LinearNode<T> newNode = new LinearNode<>(element);

        if (isEmpty()) {
            front = rear = newNode;
            front.setNext(front);
        } else if (((Comparable<T>) element).compareTo(front.getElement()) < 0) {
            newNode.setNext(front);
            front = newNode;
            rear.setNext(front);
        } else {
            LinearNode<T> current = front.getNext();
            LinearNode<T> previous = front;

            while (current != front && ((Comparable<T>) element).compareTo(current.getElement()) > 0) {
                previous = current;
                current = current.getNext();
            }

            newNode.setNext(current);
            previous.setNext(newNode);

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

        LinearNode<T> current = front;
        LinearNode<T> nextNode;
        LinearNode<T> temp = null;

        do {
            nextNode = current.getNext();
            current.setNext(temp); // Reverse the next pointer
            temp = current;
            current = nextNode;
        } while (current != front);

        // Update front and rear
        rear = front;
        front = temp;
    }

    
}
