/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

import BinarySearchTree.OrderedLinkedBinarySearchTree;
import Throws.NonComparableElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            OrderedLinkedBinarySearchTree<Integer> orderedTree = new OrderedLinkedBinarySearchTree<>();
            
            // Adicione elementos à árvore
            orderedTree.add(50);
            orderedTree.add(30);
            orderedTree.add(70);
            orderedTree.add(20);
            orderedTree.add(40);
            
            // Exemplo de utilização de outros métodos da OrderedListADT
            System.out.println("Min: " + orderedTree.findMin());
            System.out.println("Max: " + orderedTree.findMax());
            System.out.println(orderedTree.toString());
        } catch (NonComparableElementException ex) {
            Logger.getLogger(Exercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
