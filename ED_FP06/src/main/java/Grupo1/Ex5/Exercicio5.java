/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex5;

import Throws.EmptyCollectionException;
import Throws.NonComparableElementException;

/**
 *
 * @author Leona
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a CircularLinkedList
        CircularDoubleLinkedList<Integer> circularDoubleList = new CircularDoubleLinkedList<>();

        // Add elements to the list
        try {
            circularDoubleList.add(5);
            circularDoubleList.add(10);
            circularDoubleList.add(2);
            circularDoubleList.add(8);
            circularDoubleList.add(20);
            circularDoubleList.add(1);
        } catch (NonComparableElementException e) {
            System.out.println("Error adding elements: " + e.getMessage());
        }

        // Print the original list
        System.out.println("Original List: " + circularDoubleList);

        // Remove elements from the list
        try {
            System.out.println(circularDoubleList.removeFirst());
            System.out.println(circularDoubleList.removeLast());
        } catch (EmptyCollectionException e) {
            System.out.println("Error removing elements: " + e.getMessage());
        }
        
        System.out.println("Elemento removido: " + circularDoubleList.remove(2));

        // Print the modified list
        System.out.println("Modified List: " + circularDoubleList.toString());
        // Access the first and last elements
        try {
            System.out.println("First Element: " + circularDoubleList.first());
            System.out.println("Last Element: " + circularDoubleList.last());
        } catch (EmptyCollectionException e) {
            System.out.println("Error accessing elements: " + e.getMessage());
        }

        // Print the size of the list
        System.out.println("List Size: " + circularDoubleList.size());
    }
    
}
