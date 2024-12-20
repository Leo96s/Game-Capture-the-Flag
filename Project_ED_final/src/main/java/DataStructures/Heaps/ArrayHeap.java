/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Heaps;

import DataStructures.BinarySearchTree.ArrayBinaryTree;
import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * ArrayHeap provides an array implementation of a minheap.
 * @param <T>
 */
public class ArrayHeap<T> extends ArrayBinaryTree<T>
        implements HeapADT<T> {

    public ArrayHeap() {
         super();
    }

    /**
     * Adds the specified element to this heap in the appropriate position
     * according to its key value. Note that equal elements are added to the
     * right.
     *
     * @param element the element to be added to this heap
     */
    @Override
    public void addElement(T element) {
        if (count == tree.length) {
            expandCapacity();
        }
        tree[count] = element;
        count++;
        if (count > 1) {
            heapifyAdd();
        }
    }

    /**
     * Reorders this heap to maintain the ordering property after adding a node.
     */
    private void heapifyAdd() {
        T temp;
        int next = count - 1;

        temp = tree[next];

        while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {
            tree[next] = tree[(next - 1) / 2];
            next = (next - 1) / 2;
        }
        tree[next] = temp;
    }

    /**
     * Remove the element with the lowest value in this heap and returns a
     * reference to it. Throws an EmptyCollectionException if the heap is empty.
     *
     * @return a reference to the element with the lowest value in this head
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        T minElement = tree[0];
        tree[0] = tree[count - 1];
        heapifyRemove();
        count--;

        return minElement;
    }

    /**
     * Reorders this heap to maintain the ordering property.
     */
    private void heapifyRemove() {
        T temp;
        int node = 0;
        int left = 1;
        int right = 2;
        int next;

        if ((left < count) && (right < count)) { // check if both children are within the heap
            if (((Comparable) tree[left]).compareTo(tree[right]) < 0) { // find the smaller child
                next = left;
            } else {
                next = right;
            }
        } else if (left < count) { // check if only the left child is within the heap
            next = left;
        } else { // no children are within the heap
            next = count;
        }

        temp = tree[node];

        while ((next < count) && (((Comparable) tree[next]).compareTo(temp) < 0)) { // check if the smaller child is less than the current node
            tree[node] = tree[next]; // swap the current node with the smaller child
            node = next; // update the current node index
            left = 2 * node + 1; // update the left child index
            right = 2 * (node + 1); // update the right child index

            if ((left < count) && (right < count)) { // repeat the same process as above
                if (((Comparable) tree[left]).compareTo(tree[right]) < 0) {
                    next = left;
                } else {
                    next = right;
                }
            } else if (left < count) {
                next = left;
            } else {
                next = count;
            }
        }
        tree[node] = temp; // place the original node in its final position
    }
    
    /**
     * Returns a reference to the element with the lowest value in this heap.
     *
     * @return a reference to the element with the lowest value in this heap
     */
    @Override
    public T findMin() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty Heap");
        }
        return tree[0];
    }
    
     @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(tree[i]).append(" ");
        }
        return result.toString();
    }

}
