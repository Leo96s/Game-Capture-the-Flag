/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.List;


import DataStructures.Node.DoubleNode;
import Exceptions.NonComparableElementException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * OrderedLinkedList represents a linked implementation of an ordered list.
 *
 * @param <T> the type of elements stored in the list
 */
public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T> {

    public OrderedLinkedList() {
        super();
    }

    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("Element is not comparable");
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);

        DoubleNode<T> current = front;
        DoubleNode<T> previous = null;

        while (current != null && ((Comparable<T>) element).compareTo(current.getElement()) > 0) {
            previous = current;
            current = current.getNext();
        }

        newNode.setNext(current);
        newNode.setPrev(previous);

        if (previous == null) {
            // Add at the beginning
            front = newNode;
        } else {
            previous.setNext(newNode);
        }

        if (current == null) {
            // Add at the end
            rear = newNode;
        } else {
            current.setPrev(newNode);
        }

        count++;
        modCount++;
    }

    /**
     * Método para inverter a lista
     */
    public void reverse() {
        DoubleNode<T> current = front;
        DoubleNode<T> temp = null;

        while (current != null) {
            // Troca os ponteiros prev e next
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);

            // Move para o próximo nó
            current = current.getPrev();
        }

        // Troca as referências do front e rear
        temp = front;
        front = rear;
        rear = temp;
    }


}
