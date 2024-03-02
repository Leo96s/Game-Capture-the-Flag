/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex4;

import Throws.EmptyCollectionException;
import Throws.NonComparableElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularLinkedList<Integer> circularList = new CircularLinkedList<>();

        try {
            circularList.add(10);
            circularList.add(5);
            circularList.add(20);
            circularList.add(15);
            circularList.add(25);
            circularList.add(1);
        } catch (NonComparableElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println(circularList.toString());
        
        try {
            circularList.removeFirst();
            circularList.removeLast();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        circularList.remove(15);
        
        // Displaying the original list
        System.out.println("Original Circular List:");
        System.out.println(circularList.toString());
        try {
            System.out.println("First: " +circularList.first());
            System.out.println("Last: " + circularList.last());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Size: " + circularList.size());
    }  
}
