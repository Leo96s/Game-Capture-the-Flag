/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex3;

import Grupo1.Ex1.Car;
import Search.SortingAndSearching;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Car c1 = new Car("Civic", "X1", "AB-04-ED", 2020);
        Car c2 = new Car("Accord", "Y2", "WE-04-ED", 2019);
        Car c3 = new Car("Camry", "Z4", "QW-45-SD", 2021);
        Car c4 = new Car("Corolla", "W4", "QS-34-FR", 2018);

        Car[] cars1 = {c1, c2, c3, c4};
        Car[] cars2 = {c1, c2, c3, c4};
        Car[] cars3 = {c1, c2, c3, c4};
        Car[] cars4 = {c1, c2, c3, c4};
        Car[] cars5 = {c1, c2, c3, c4};
        
        SortingAndSearching.selectionSort(cars1);
        SortingAndSearching.insertionSort(cars2);
        SortingAndSearching.bubbleSort(cars3);
        SortingAndSearching.quickSort(cars4, 0, 0);
        SortingAndSearching.mergeSort(cars5, 0, 0);
    }
    
}
