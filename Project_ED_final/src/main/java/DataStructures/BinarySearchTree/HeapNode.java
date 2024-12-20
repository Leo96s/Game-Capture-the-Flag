/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.BinarySearchTree;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a node in a heap data structure.
 * @param <T> The type of data held by the heap node.
 */
public class HeapNode<T> extends BinaryTreeNode<T> {

    protected HeapNode<T> parent; // Reference to the parent node in the heap tree.

    /**
     * Creates a new heap node with the specified data.
     * @param obj the data to be contained within the new heap node.
     */
    public HeapNode(T obj) {
        super(obj); // Calls the constructor of the superclass (BinaryTreeNode) to initialize the data.
        parent = null; // Initializes the parent reference to null.
    }
}
