/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Grupo1;

import BinarySearchTree.LinkedBinarySearchTree;
import Throws.ElementNotFoundException;
import java.util.Iterator;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    public static void main(String[] args) {
        // Test LinkedBinarySearchTree
        LinkedBinarySearchTree<Integer> binarySearchTree = new LinkedBinarySearchTree<>();

        // Add elements to Binary Search Tree
        binarySearchTree.addElement(50);
        binarySearchTree.addElement(30);
        binarySearchTree.addElement(70);
        binarySearchTree.addElement(20);
        binarySearchTree.addElement(40);
        binarySearchTree.addElement(60);
        binarySearchTree.addElement(80);
        binarySearchTree.addElement(80);

        // Display the minimum and maximum elements
        System.out.println("Inorder Traversal:");
        printTree(binarySearchTree.iteratorInOrder());
        System.out.println("Minimum element: " + binarySearchTree.findMin());
        System.out.println("Maximum element: " + binarySearchTree.findMax());

        try {
            // Remove and display the minimum and maximum elements
            System.out.println("Removed minimum element: " + binarySearchTree.removeMin());
            System.out.println("Removed maximum element: " + binarySearchTree.removeMax());

            // Display the new minimum and maximum elements
            System.out.println("New minimum element: " + binarySearchTree.findMin());
            System.out.println("New maximum element: " + binarySearchTree.findMax());
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Inorder Traversal:");
        printTree(binarySearchTree.iteratorInOrder());
    }
    
    // Helper method to print the elements of the tree using an iterator
    private static void printTree(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

 
