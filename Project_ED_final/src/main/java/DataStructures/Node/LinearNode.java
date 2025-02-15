/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Node;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * LinearNode represents a node in a linked data structure.
 *
 * @param <T> the type of elements stored in the node
 */
public class LinearNode<T> {

    /**
     * reference to next node in list
     */
    private LinearNode<T> next;
    /**
     * element stored at this node
     */
    private T element;

    /**
     * Creates an empty node.
     */
    public LinearNode() {
        next = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param elem element to be stored
     */
    public LinearNode(T elem) {
        next = null;
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return LinearNode<T> reference to next node
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node) {
        next = node;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return T element stored at this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param elem element to be stored at this node
     */
    public void setElement(T elem) {
        element = elem;
    }

    /**
     * Returns a string representation of the node.
     *
     * @return a string representation of the node
     */
    @Override
    public String toString() {
        return String.format("Node{data=%s, next=%s}", element, ((next != null) ? next.element : "null"));
}
    
    

}
