/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2.Ex4;

import Externos.LinkedStack;
import Externos.StackADT;
import Throws.EmptyCollectionException;
import Interfaces.QueueADT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação de uma fila utilizando duas pilhas.
 *
 * @author Leona
 * @param <T> Tipo dos elementos na fila.
 *
 */
public class QueueWithTwoStacks<T> implements QueueADT<T> {

    private StackADT<T> enqueueStack; // Para operações enqueue
    private StackADT<T> dequeueStack; // Para operações dequeue

    /**
     * Construtor da classe QueueWithTwoStacks.
     */
    public QueueWithTwoStacks() {
        enqueueStack = new LinkedStack<>();
        dequeueStack = new LinkedStack<>();
    }

    /**
     * Adiciona um elemento à fila.
     *
     * @param element O elemento a ser adicionado.
     */
    @Override
    public void enqueue(T element) {
        enqueueStack.push(element);
    }

    /**
     * Remove e retorna o elemento do início da fila.
     *
     * @return O elemento removido.
     * @throws EmptyCollectionException Exceção lançada se a fila estiver vazia.
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("A fila está vazia.");
        }

        if (dequeueStack.isEmpty()) {
            transferElements();
        }

        return dequeueStack.pop();
    }

    /**
     * Retorna o elemento do início da fila sem removê-lo.
     *
     * @return O elemento no início da fila.
     */
    @Override
    public T first() {
        if (isEmpty()) {
            System.out.println("A fila esta vazia");
            return null;
        }

        if (dequeueStack.isEmpty()) {
            transferElements();
        }
        T temp = null;
        try {
            temp = dequeueStack.peek();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(QueueWithTwoStacks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    /**
     * Verifica se a fila está vazia.
     *
     * @return true se a fila estiver vazia, false caso contrário.
     */
    @Override
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    /**
     * Retorna o tamanho atual da fila.
     *
     * @return O tamanho atual da fila.
     */
    @Override
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    /**
     * Retorna uma representação de string da fila.
     *
     * @return Uma string representando a fila.
     */
    @Override
    public String toString() {
        return "Enqueue Stack: " + enqueueStack + " | Dequeue Stack: " + dequeueStack;
    }

    /**
     * Transfere elementos da pilha de enqueue para a pilha de dequeue.
     */
    private void transferElements() {
        while (!enqueueStack.isEmpty()) {
            try {
                dequeueStack.push(enqueueStack.pop());
            } catch (EmptyCollectionException ex) {
                ex.toString();
            }
        }
    }
}
