/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2.Ex5;

import Grupo1.Ex1.LinkedQueue;
import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String[] strings = {"Dada1", "Dada2", "Dada3", "Dada4", "Dada5"};

        StringQueueMerger merger = new StringQueueMerger(strings);
        System.out.println("Inicial Queue: " + merger);

        merger.performMerge();

        LinkedQueue<String> finalQueue = null;
        try {
            finalQueue = merger.dequeue();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio5.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Final Queue: " + finalQueue);
    
    }
    
}
