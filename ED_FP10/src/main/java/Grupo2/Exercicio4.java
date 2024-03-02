/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

import BinarySearchTree.AVLTree;

/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        // Inserção
        avlTree.insert(50);
        avlTree.insert(30);
        avlTree.insert(70);
        avlTree.insert(20);
        avlTree.insert(40);
        avlTree.insert(60);
        avlTree.insert(80);

        // Impressão em ordem
        System.out.println("Árvore AVL em ordem: " + avlTree.toString());

        // Remoção
        avlTree.remove(40);

        // Impressão após remoção
        System.out.println("Árvore AVL em ordem após remover 40: " + avlTree.toString());

        // Busca pelo máximo
        System.out.println("Máximo na árvore: " + avlTree.findMax());

        // Remoção do máximo
        avlTree.removeMax();
        System.out.println("Árvore AVL em ordem após remover o máximo: " + avlTree.toString());

        // Busca pelo mínimo
        System.out.println("Mínimo na árvore: " + avlTree.findMin());

        // Remoção do mínimo
        avlTree.removeMin();
        System.out.println("Árvore AVL em ordem após remover o mínimo: " + avlTree.toString());
    }
    
}
