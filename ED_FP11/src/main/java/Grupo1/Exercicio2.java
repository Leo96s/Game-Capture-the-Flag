/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1;

import Heaps.PriorityQueue;
import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Create a PriorityQueue of integers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements with priorities
        priorityQueue.addElement(10, 3);
        priorityQueue.addElement(20, 1);
        priorityQueue.addElement(30, 2);

        try {
            // Remove and print elements in priority order
            System.out.println("Removed element: " + priorityQueue.removeNext());
            System.out.println("Removed element: " + priorityQueue.removeNext());
            System.out.println("Removed element: " + priorityQueue.removeNext());
        } catch (EmptyCollectionException e) {
            System.out.println("The priority queue is empty.");
        }
    }
}
