/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.BinarySearchTree;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a node in an AVL tree.
 * @param <T> The type of element stored in the node.
 */
public class AVLNode<T> {

    /** The element stored in the node. */
    T element;

    /** Reference to the left child of the node. */
    AVLNode<T> left;

    /** Reference to the right child of the node. */
    AVLNode<T> right;

    /** The height of the node in the AVL tree. */
    int height;

    /**
     * Constructs a new AVLNode with the specified element.
     * @param element The element to be stored in the node.
     */
    public AVLNode(T element) {
        this.element = element;
        this.height = 1;
    }
}

