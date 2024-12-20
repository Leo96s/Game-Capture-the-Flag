/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Heaps;

import DataStructures.BinarySearchTree.BinaryTreeADT;
import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * HeapADT is an interface that extends BinaryTreeADT and defines operations specific to heaps.
 *
 * @param <T> the type of elements stored in the heap
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
     * @throws Exceptions.EmptyCollectionException
     */
    public T removeMin()  throws EmptyCollectionException;

    /**
     * Returns a reference to the element with the lowest value in this heap.
     *
     * @return a reference to the element with the lowest value in this heap
     * @throws Exceptions.EmptyCollectionException
     */
    public T findMin() throws EmptyCollectionException;
}
