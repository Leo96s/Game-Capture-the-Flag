/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;


import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int EXPAND_VALUE = 2;
    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 2;

    /**
     * int that represents both the number of elements and the next available
     * position in the array
     */
    private int front;

    /**
     *
     */
    private int rear;

    /**
     * array of generic elements to represent the stack
     */
    private T[] queue;

    private int count;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        front = rear = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
        count = 0;
    }

    @Override
    public void enqueue(T element) {
        if (count == queue.length) {
        expandCapacity();
    }
    queue[rear] = element;
    rear = (rear + 1) % queue.length;
    count++;

}

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        T element = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;

        return element;
    }

    /**
     * Metodo para expandir o tamanho da queue se for necessario
     */
    private void expandCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * EXPAND_VALUE];

        for (int i = 0; i < count; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }

        front = 0;
        rear = count;
        queue = newQueue;
    }

    @Override
    public T first() {
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = front;
        for (int i = 0; i < count; i++) {
            sb.append(queue[index]);
            if (i < count - 1) {
                sb.append(", ");
            }
            index = (index + 1) % queue.length;
        }
        return sb.toString();
    }
    
    public String Message(){
        StringBuilder sb = new StringBuilder();
        int index = front;
        for (int i = 0; i < count; i++) {
            sb.append(queue[index]);
            if (i < count - 1) {
                sb.append("");
            }
            index = (index + 1) % queue.length;
        }
        return sb.toString();
    }
}
