/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex2;

/**
 *
 * @author Leona
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        list.add(3);
        list.add(6);
        list.add(7);
        list.add(9);
        
        // Imprime todos os elementos da lista a partir do primeiro nó
        System.out.println("Elementos da lista do primeiro ao último:");
        list.printFromHead();

        // Imprime todos os elementos da lista a partir do último nó
        System.out.println("\nElementos da lista do último ao primeiro:");
        list.printFromTail();
        
        // Substitui todas as ocorrências de "apple" por "grape"
        list.replace(3, 5);

        // Imprime a lista após a substituição
        System.out.println("\nLista após a substituição:");
        list.printFromHead();
    }
    }
    

