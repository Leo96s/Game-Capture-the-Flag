/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1;

import BinarySearchTree.LinkedHeap;
import Heaps.PriorityQueue;
import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Test LinkedHeap
        LinkedHeap<Integer> linkedHeap = new LinkedHeap<>();

        // Add elements to LinkedHeap
        linkedHeap.addElement(10);
        linkedHeap.addElement(5);
        linkedHeap.addElement(15);

        try {
            // Find and print the minimum element without removing it
            System.out.println("Min element in LinkedHeap: " + linkedHeap.findMin());

            // Remove and print elements in ascending order
            System.out.println("Removed element from LinkedHeap: " + linkedHeap.removeMin());
            System.out.println("Removed element from LinkedHeap: " + linkedHeap.removeMin());
            System.out.println("Removed element from LinkedHeap: " + linkedHeap.removeMin());
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }

        // Test PriorityQueue
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        // Add elements to PriorityQueue with priorities
        priorityQueue.addElement("Task A", 3);
        priorityQueue.addElement("Task B", 1);
        priorityQueue.addElement("Task C", 2);

        try {
            // Remove and print elements in priority order
            System.out.println("Removed element from PriorityQueue: " + priorityQueue.removeNext());
            System.out.println("Removed element from PriorityQueue: " + priorityQueue.removeNext());
            System.out.println("Removed element from PriorityQueue: " + priorityQueue.removeNext());
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
    }
}
