/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

import Grupo1.ElementNotFoundException;
import Grupo1.EmptyCollectionException;
import Grupo1.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     * @throws Grupo1.EmptyCollectionException
     * @throws Grupo1.ElementNotFoundException
     */
    public static void main(String[] args) throws EmptyCollectionException, ElementNotFoundException {
        DoublyLinkedList3_0 linkedList = new DoublyLinkedList3_0();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);
        linkedList.add("ola");

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
        
        System.out.println(linkedList.toArray());
        System.out.println(linkedList.toArrayUntilPosition(1));
        System.out.println(linkedList.toArrayAfterPosition(1));
        System.out.println(linkedList.toArrayBetweenPositions(1, 1));
        
        System.out.println(linkedList.getEvenElements());

    }
    
}

