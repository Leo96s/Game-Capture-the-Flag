/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1;

import BinarySearchTree.ArrayBinarySearchTree;
import Throws.ElementNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a binary search tree
        ArrayBinarySearchTree<Integer> bst = new ArrayBinarySearchTree<>(10);

        // Add elements to the tree
        bst.addElement(50);
        bst.addElement(30);
        bst.addElement(70);
        bst.addElement(20);
        bst.addElement(40);
        bst.addElement(60);
        bst.addElement(80);
        bst.addElement(11);
        bst.addElement(11);
        // Print the inorder traversal of the tree
        System.out.println("Inorder Traversal:");
        printTree(bst.iteratorInOrder());
        
        System.out.println("Contains: " + bst.contains(50));

        try {
            System.out.println("Removed element: " + bst.removeElement(50));
            bst.removeAllOccurrences(11);
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("FIndMin: " + bst.findMin());
        System.out.println("FIndMax:" + bst.findMax());

        // Print the inorder traversal after removal
        System.out.println("\nInorder Traversal after removal:");
        printTree(bst.iteratorInOrder());
    }

    // Helper method to print the elements of the tree using an iterator
    private static void printTree(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
 
  
