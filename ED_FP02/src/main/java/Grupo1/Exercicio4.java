/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        System.out.println(linkedList);

        try {
            System.out.println("Elemento Removido: " + linkedList.remove(4));
            System.out.println(linkedList);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(linkedList.toString());
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
