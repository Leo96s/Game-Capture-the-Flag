/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex1;

import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue queue =new LinkedQueue();

        queue.enqueue("1st");
        queue.enqueue("2nd");
        queue.enqueue("3rd");
        queue.enqueue("4th");

        System.out.println(queue);
        System.out.println(queue.first());
        try {
            queue.dequeue();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(queue);
    }
    
}
