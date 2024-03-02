/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

import List.OrderedListADT;
import Throws.ElementNotFoundException;
import Throws.EmptyCollectionException;
import Throws.NonComparableElementException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 * @param <T>
 */
public class OrderedLinkedBinarySearchTree<T> extends LinkedBinarySearchTree<T> implements OrderedListADT<T> {

    public OrderedLinkedBinarySearchTree() {
        super();
    }

    @Override
    public void add(T element) throws NonComparableElementException {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("Element is not comparable");
        }

        addElement(element);
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        try {
            return super.removeMin();
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        try {
            return super.removeMax();
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public T remove(T element) {
        try {
            return super.removeElement(element);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(OrderedLinkedBinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public T first() throws EmptyCollectionException {
        return super.findMin();
    }

    @Override
    public T last() throws EmptyCollectionException {
        return super.findMax();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        toStringHelper(root, result);
        return result.toString();
    }

    private void toStringHelper(BinaryTreeNode<T> node, StringBuilder result) {
        if (node != null) {
            toStringHelper(node.left, result);
            result.append(node.element).append(" ");
            toStringHelper(node.right, result);
        }
    }
    
}

