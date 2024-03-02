/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Grupo1;

import Heaps.ArrayHeap;
import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    public static void main(String[] args) {
        ArrayHeap<String> personHeap = new ArrayHeap<>();

        // Adding elements to the heap
        personHeap.addElement("Alice");
        personHeap.addElement("Bob");
        personHeap.addElement("Charlie");

        // Displaying the heap
        System.out.println("Heap elements: " + personHeap);

        try{
        // Finding the minimum element
        System.out.println("Min element: " + personHeap.findMin());

        // Removing the minimum element
            System.out.println("Removed min element: " + personHeap.removeMin());
        } catch (EmptyCollectionException e) {
            System.out.println("Heap is empty. Cannot remove minimum element.");
        }

        // Displaying the updated heap
        System.out.println("Updated heap elements: " + personHeap);
    }
}
