/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2.Ex3;

import Throws.EmptyCollectionException;
import Interfaces.QueueADT;

/**
 *
 * Classe que representa a fusão de duas filas ordenadas.
 *
 * @author Leona
 * @param <Q> Tipo da fila que implementa QueueADT.
 * @param <T> Tipo dos elementos comparáveis na fila.
 *
 */
public class MergeSortedQueue<Q extends QueueADT<T>, T extends Comparable> {

    private Q mergedqueue;

    /**
     * Construtor da classe MergeSortedQueue.
     *
     * @param queue A fila a ser utilizada para a fusão.
     */
    public MergeSortedQueue(Q queue) {
        this.mergedqueue = queue;
    }

    /**
     * Realiza a fusão de duas filas ordenadas e retorna a fila resultante.
     *
     * @param queue1 A primeira fila ordenada.
     * @param queue2 A segunda fila ordenada.
     * @return A fila resultante da fusão.
     * @throws EmptyCollectionException Exceção lançada se uma fila estiver
     * vazia durante a fusão.
     */
    public Q mergeSortedQueues(Q queue1, Q queue2) throws EmptyCollectionException {
        // Fusão enquanto ambas as filas não estiverem vazias
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Compara os elementos no topo das filas e enfileira o menor na fila resultante
            if (queue2.first().compareTo(queue1.first()) <= 0) {
                mergedqueue.enqueue(queue2.dequeue());
            } else {
                mergedqueue.enqueue(queue1.dequeue());
            }
        }

        // Adiciona os elementos restantes, se houver, de ambas as filas
        while (!queue1.isEmpty()) {
            mergedqueue.enqueue(queue1.dequeue());
        }

        while (!queue2.isEmpty()) {
            mergedqueue.enqueue(queue2.dequeue());
        }

        return mergedqueue;
    }

    /**
     * Obtém a fila resultante da fusão.
     * @return A fila resultante.
     */
    public Q getMergedQueue() {
        return mergedqueue;
    }
}
