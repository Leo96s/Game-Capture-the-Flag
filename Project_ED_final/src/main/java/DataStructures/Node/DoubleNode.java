/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Node;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a node in a doubly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class DoubleNode<T> {

    private T element; // the data stored in the node
    private DoubleNode<T> next; // reference to the next node
    private DoubleNode<T> prev; // reference to the previous node

    /**
     * Constructs an empty node.
     */
    public DoubleNode() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    /**
     * Constructs a node with the specified data and null next and prev pointers.
     *
     * @param data the data to be stored in the node
     */
    public DoubleNode(T data) {
        this.element = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Returns the data stored in the node.
     *
     * @return the data stored in the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the data stored in the node.
     *
     * @param element the data to be stored in the node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the reference to the next node.
     *
     * @return the reference to the next node
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node.
     *
     * @param next the reference to the next node
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the reference to the previous node.
     *
     * @return the reference to the previous node
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Sets the reference to the previous node.
     *
     * @param prev the reference to the previous node
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns a string representation of the node.
     *
     * @return a string representation of the node
     */
    @Override
    public String toString() {
        return String.format("DoubleNode{data=%s, next=%s, prev=%s}", element, (next != null ? next.element : "null"), (prev != null ? prev.element : "null"));
    }
}
