/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.BinarySearchTree;

import DataStructures.List.OrderedListADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.NonComparableElementException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents an ordered linked binary search tree, which extends the functionality of a linked binary search tree
 * and implements the OrderedListADT interface.
 * @param <T> the type of elements stored in the tree, which must implement the Comparable interface
 */
public class OrderedLinkedBinarySearchTree<T> extends LinkedBinarySearchTree<T> implements OrderedListADT<T> {

    /**
     * Constructs an empty ordered linked binary search tree.
     */
    public OrderedLinkedBinarySearchTree() {
        super();
    }

    /**
     * Adds the specified element to the tree while maintaining the order.
     *
     * @param element the element to be added to the tree
     * @throws NonComparableElementException if the element is not comparable
     */
    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("Element is not comparable");
        }

        addElement(element);
    }

    /**
     * Removes and returns the first element in the tree, which is the smallest element.
     *
     * @return the first element in the tree
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        try {
            return super.removeMin();
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Removes and returns the last element in the tree, which is the largest element.
     *
     * @return the last element in the tree
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        try {
            return super.removeMax();
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Removes the specified element from the tree if it is present.
     *
     * @param element the element to be removed from the tree
     * @return the removed element, or null if the element is not found
     */
    @Override
    public T remove(T element) {
        try {
            return super.removeElement(element);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Returns the first (smallest) element in the tree.
     *
     * @return the first element in the tree
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        return super.findMin();
    }

    /**
     * Returns the last (largest) element in the tree.
     *
     * @return the last element in the tree
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T last() throws EmptyCollectionException {
        return super.findMax();
    }

    /**
     * Returns an iterator over the elements in the tree (not implemented).
     *
     * @return an iterator over the elements in the tree
     * @throws UnsupportedOperationException if the method is not supported
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Returns a string representation of the elements in the tree using an inorder traversal.
     *
     * @return a string representation of the elements in the tree
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        toStringHelper(root, result);
        return result.toString();
    }

    /**
     * Helper method to perform an inorder traversal of the tree and build the string representation.
     *
     * @param node the current node being visited
     * @param result the StringBuilder to build the string representation
     */
    private void toStringHelper(BinaryTreeNode<T> node, StringBuilder result) {
        if (node != null) {
            toStringHelper(node.left, result);
            result.append(node.element).append(" ");
            toStringHelper(node.right, result);
        }
    }
}


