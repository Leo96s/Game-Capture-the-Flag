/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1;

/**
 *
 * @author Leona
 */
public class DoublyLinkedList<T> {

    private Node<T> front;

    private Node<T> rear;

    public DoublyLinkedList() {
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
