/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinarySearchTree;

/**
 *
 * @author Leona
 * @param <T>
 */
public class AVLNode<T> {

    protected T element;
    protected AVLNode<T> left, right;
    protected int height;

    public AVLNode(T element) {
        this.element = element;
        this.height = 1;
    }
}

