/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1;

/**
 *
 * @author Leona
 * @param <T>
 */
public class List<T> {

    private Node<T> front, rear;

    public List() {
        front = new  Node();
        rear = new Node();
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        
        newNode.setNext((front == null) ? rear : front);

        front = newNode;

    }

    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (front == null) {
            throw new EmptyCollectionException("A lista está vazia.");
        }
        boolean found = false;
        Node<T> previous = null;
        Node<T> current = front;

        while (current != null && !found) {
            if (element.equals(current.getData())) {
                found = true;

            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (!found) {
            throw new ElementNotFoundException("Element not found");
        }

        // O elemento a ser removido está em algum lugar no meio ou no final da lista
        previous.setNext(current.getNext());

        return current.getData(); // Retorna o elemento removido
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList{");
        if (front == null) {
            System.out.println("List is empty!");
        } else {
            sb.append(front);
        }

        return sb.toString();
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
