/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2.Ex3;

import Throws.EmptyCollectionException;
import Grupo1.Ex1.LinkedQueue;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        LinkedQueue<Integer> queue2 = new LinkedQueue<>();
        // Preencha as filas com elementos ordenados
        queue1.enqueue(1);
        queue1.enqueue(3);
        queue1.enqueue(5);

        queue2.enqueue(2);
        queue2.enqueue(4);
        queue2.enqueue(6);
        
        System.out.println(queue1.toString());
        System.out.println(queue2);
        MergeSortedQueue mergedQueue = new MergeSortedQueue(new LinkedQueue<>());
        try{
        mergedQueue.mergeSortedQueues(queue1, queue2);
        // Imprime a fila mesclada
        System.out.println("Fila Mesclada: " + mergedQueue.getMergedQueue());
        }catch(EmptyCollectionException ex){
            ex.toString();
        }
    }
    
}
