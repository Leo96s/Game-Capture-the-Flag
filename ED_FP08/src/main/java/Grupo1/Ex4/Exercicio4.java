/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex4;

import Grupo1.Ex1.Car;
import Grupo1.Ex2.DoubleLinkedList;
import Search.SortingAndSearchingLinkedList;
import Throws.NonComparableElementException;
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
        try {
            Car c1 = new Car("Civic", "X1", "AB-04-ED", 2020);
            Car c2 = new Car("Accord", "Y2", "WE-04-ED", 2019);
            Car c3 = new Car("Camry", "Z4", "QW-45-SD", 2021);
            Car c4 = new Car("Corolla", "W4", "QS-34-FR", 2018);
            
            DoubleLinkedList list = new DoubleLinkedList();
            
            list.add(c1);
            list.add(c2);
            list.add(c3);
            list.add(c4);
            
            SortingAndSearchingLinkedList.selectionSort(list);
        } catch (NonComparableElementException ex) {
            Logger.getLogger(Exercicio4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
