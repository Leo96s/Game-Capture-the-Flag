/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex1;

import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 * @param <T>
 */
public class LinkedQueue<T> implements QueueADT<T>{
    
    private int count;
    private LinearNode<T> front;
    private LinearNode<T> rear;
    
    public LinkedQueue(){
        front = rear = null;
        count = 0;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        count++;
    }
    
    @Override
    public T dequeue() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException("Vazio");
        }
        T returnvalue = front.getElement();

        front = front.getNext();
        count--;

        return returnvalue;
    }

    @Override
    public T first() {
        if(isEmpty()){
        }
        return front.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
    
     /**
     * Metodo toString para imprimir os elementos da queue
     * @return 
     */
    @Override
public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<T> current = front;
        
        sb.append("LinkedQueue{");
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(" <-> ");
            }
            current = current.getNext();
        }

        sb.append("}");

        return sb.toString();
    }
    
}
