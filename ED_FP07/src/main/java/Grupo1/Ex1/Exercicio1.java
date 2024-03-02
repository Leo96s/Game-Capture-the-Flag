/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex1;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        list.add(2);
        list.add(4);
        list.add(5);
        
         list.printList();
         
         list.reverse();

        // Imprime a lista após a inversão
        System.out.println("\nLista após a inversão:");
        list.printList();

    }
    
}
