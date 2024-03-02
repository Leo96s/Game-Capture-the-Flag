/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2.Ex5;

import Grupo1.Ex1.LinkedQueue;
import Interfaces.QueueADT;
import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que representa a fusão de várias filas de strings.
 * 
 * @author Leona
 */
public class StringQueueMerger implements QueueADT<LinkedQueue<String>> {

    private LinkedQueue<LinkedQueue<String>> queueOfQueues;
    
    /**
     * Construtor que inicializa as filas com strings fornecidas.
     * @param strings Um array de strings para inicializar as filas.
     */
    public StringQueueMerger(String[] strings) {
        initializeQueues(strings);
    }
    
    /**
     * Inicializa as filas com base em um array de strings.
     * Cria uma fila para cada string e a adiciona à fila de filas.
     * @param strings O array de strings para inicializar as filas.
     */
    private void initializeQueues(String[] strings) {
        // Criar N Queues
        queueOfQueues = new LinkedQueue<>();
        for (String str : strings) {
            LinkedQueue<String> singleQueue = new LinkedQueue<>();
            singleQueue.enqueue(str);
            queueOfQueues.enqueue(singleQueue);
        }
    }

    /**
     * Realiza a fusão repetida de filas até que haja apenas uma fila restante.
     */
    public void performMerge() {
        // Repetidamente aplicar a operação de junção ordenada
        while (queueOfQueues.size() > 1) {
            
            LinkedQueue<String> firstQueue = null;
            LinkedQueue<String> secondQueue = null;
            try {
                firstQueue = queueOfQueues.dequeue();
                secondQueue = queueOfQueues.dequeue();
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(StringQueueMerger.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            LinkedQueue<String> mergedQueue = mergeOrderedQueues(firstQueue, secondQueue);

            queueOfQueues.enqueue(mergedQueue);
        }
    }
    
    /**
     * Realiza a fusão ordenada de duas filas de strings.
     * @param queue1 A primeira fila a ser mesclada.
     * @param queue2 A segunda fila a ser mesclada.
     * @return A fila resultante da fusão ordenada.
     */
    private LinkedQueue<String> mergeOrderedQueues(LinkedQueue<String> queue1, LinkedQueue<String> queue2) {
        LinkedQueue<String> mergedQueue = new LinkedQueue<>();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.first().compareTo(queue2.first()) < 0) {
                try {
                    mergedQueue.enqueue(queue1.dequeue());
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(StringQueueMerger.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    mergedQueue.enqueue(queue2.dequeue());
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(StringQueueMerger.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // Adicionar os elementos restantes de ambas as Queues (se houver)
        while (!queue1.isEmpty()) {
            try {
                mergedQueue.enqueue(queue1.dequeue());
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(StringQueueMerger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (!queue2.isEmpty()) {
            try {
                mergedQueue.enqueue(queue2.dequeue());
            } catch (EmptyCollectionException ex) {
                Logger.getLogger(StringQueueMerger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return mergedQueue;
    }
    
    // Métodos da interface QueueADT

    @Override
    public void enqueue(LinkedQueue<String> element) {
        queueOfQueues.enqueue(element);
    }
    
    @Override
    public LinkedQueue<String> dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue is empty");
        }
        return queueOfQueues.dequeue();
    }

    @Override
    public LinkedQueue<String> first()  {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queueOfQueues.first();
    }

    @Override
    public boolean isEmpty() {
        return queueOfQueues.isEmpty();
    }

    @Override
    public int size() {
        return queueOfQueues.size();
    }

    @Override
    public String toString() {
        return queueOfQueues.toString();
    }
}
