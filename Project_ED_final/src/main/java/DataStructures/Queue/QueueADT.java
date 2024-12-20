/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataStructures.Queue;

import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * QueueADT defines the interface to a queue data structure.
 *
 * @param <T> the type of elements stored in the queue
 */
public interface QueueADT<T> {

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
   public void enqueue(T element);

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws Exceptions.EmptyCollectionException
     */
    public T dequeue() throws EmptyCollectionException;

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    public T first();

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size();

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString();

}
