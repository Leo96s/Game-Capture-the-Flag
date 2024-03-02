/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

import Grupo1.ElementNotFoundException;
import Grupo1.EmptyCollectionException;
import Grupo1.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leona
 */
public class DoublyLinkedList4_0<T> {

    private Node<T> front;

    private Node<T> rear;

    public DoublyLinkedList4_0() {
        front = rear = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.setNext((front != null) ? front : rear); // Configura 'next' usando o operador condicional ternário
        newNode.setPrev((front != null) ? null : rear); // Configura 'prev' usando o operador condicional ternário

        if (front != null) {
            front.setPrev(newNode);
        }

        front = newNode;

        if (rear == null) {
            rear = newNode;
        }
    }

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (front == null) {
            throw new EmptyCollectionException("A lista está vazia.");
        }
        Node<T> current = front;

        while (current != null) {
            if (element.equals(current.getData())) {
                Node<T> nextNode = current.getNext();
                Node<T> previous = current.getPrev();

                if (current == front) {
                    front = nextNode;
                    if (front != null) {
                        front.setPrev(null);
                    }
                } else {
                    previous.setNext(nextNode);
                    if (current == rear) {
                        rear = previous;
                    } else {
                        nextNode.setPrev(previous);
                    }
                }

                return current.getData();
            }
            current = current.getNext();
        }
        throw new ElementNotFoundException("Element not found");
    }

    public List<T> toArray() {
        if (front == null) {
            return null;
        }

        List<T> list = new ArrayList<>();
        Node<T> current = front;

        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    public List<T> toArrayUntilPosition(int position) {
        if (front == null || position < 0) {
            return null;
        }

        List<T> list = new ArrayList<>();
        Node<T> current = front;
        int index = 0;

        while (current != null && index <= position) {
            list.add(current.getData());
            current = current.getNext();
            index++;
        }

        return list;
    }

    public List<T> toArrayAfterPosition(int position) {
        if (front == null || position < 0) {
            return null;
        }

        List<T> list = new ArrayList<>();
        Node<T> current = front;
        int index = 0;

        while (current != null) {
            if (index >= position) {
                list.add(current.getData());
            }
            current = current.getNext();
            index++;
        }
        return list;

    }

    public List<T> toArrayBetweenPositions(int start, int end) {
        if (front == null || start < 0 || end < start) {
            return null;
        }

        List<T> list = new ArrayList<>();
        Node<T> current = front;
        int index = 0;

        while (current != null && index <= end) {
            if (index >= start) {
                list.add(current.getData());
            }
            current = current.getNext();
            index++;
        }
        return list;
    }

    public DoublyLinkedList4_0<T> getEvenElements() {
        DoublyLinkedList4_0 evenList = new DoublyLinkedList4_0<>();
        Node<T> current = front;

        while (current != null) {
            if (current.getData() instanceof Integer) {
                Integer data = (Integer) current.getData();
                if (data % 2 == 0) {
                    evenList.add((T) data);
                }
            }
            current = current.getNext();
        }

        return evenList;
    }

    public int verifyEqualElements(T element) throws EmptyCollectionException, ElementNotFoundException {
        Node<T> current = front;
        int equalCount = -1;
        while (current != null) {
            if (current.getData().equals(element)) {
                equalCount++;
                if (equalCount > 0) {
                    this.remove(element);
                }
            }
            current = current.getNext();
        }
        return equalCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;

        sb.append("DoublyLinkedList{");
        while (current != null) {
            sb.append(current.toString());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }

        sb.append("}");
        return sb.toString();
    }

}
