/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heaps;

import BinarySearchTree.BinaryTreeADT;
import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public interface HeapADT<T> extends BinaryTreeADT<T> {

    /**
     * Adds the specified object to this heap.
     *
     * @param obj the element to added to this head
     */
    public void addElement(T obj);

    /**
     * Removes element with the lowest value from this heap.
     *
     * @return the element with the lowest value from this heap
     * @throws Throws.EmptyCollectionException
     */
    public T removeMin()  throws EmptyCollectionException;

    /**
     * Returns a reference to the element with the lowest value in this heap.
     *
     * @return a reference to the element with the lowest value in this heap
     * @throws Throws.EmptyCollectionException
     */
    public T findMin() throws EmptyCollectionException;
}
