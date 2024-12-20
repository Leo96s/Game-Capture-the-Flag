/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Stack;

import Exceptions.EmptyCollectionException;

/**
 * @author Leonardo Henrique Barbosa da Silva nº8220183
 * @author Joaquim Fontes Matos nº8220216
 * Represents a stack implemented using linked nodes.
 *
 * @param <T> the type of elements stored in the stack
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count; // the number of elements in the stack
    private LinearNode<T> top; // the top node of the stack

    /**
     * Constructs an empty linked stack.
     */
    public LinkedStack() {
        count = 0;
        top = null;
    }

    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);

        newNode.setNext(top);
        top = newNode;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack Empty");
        }

        T returnValue = top.getElement();

        top = top.getNext();
        count--;

        return returnValue;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("Stack Empty");
        }
        
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<T> current = top;

        sb.append("ListedStack{");
        while (current != null) {
            sb.append(current.toString());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }

        sb.append("}");
        
        return sb.toString();
    }
}
