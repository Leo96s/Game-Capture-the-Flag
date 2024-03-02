/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2.Ex4;

import Throws.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        // Realiza operações de enqueue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Imprime o estado da fila
        System.out.println("Estado da Fila após Enqueue: " + "\n" + queue);

        try {
            // Realiza operações de dequeue
            int item1 = queue.dequeue();
            int item2 = queue.dequeue();

            // Imprime os itens retirados
            System.out.println("Itens Dequeued: " + item1 + ", " + item2);

            // Imprime o estado da fila após o dequeue
            System.out.println("Estado da Fila após Dequeue: " + queue);

            // Realiza operação de first
            int firstItem = queue.first();

            // Imprime o item no topo da fila
            System.out.println("Item no Topo da Fila: " + firstItem);
        } catch (EmptyCollectionException e) {
            System.out.println("Erro: " + e.getMessage());
        }
 
    }
    
}
