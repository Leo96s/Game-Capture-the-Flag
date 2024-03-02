/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex2;

import Grupo1.Ex1.Car;
import Throws.NonComparableElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             Car c1 = new Car("Civic", "X1", "AB-04-ED", 2020);
        Car c2 = new Car("Accord", "Y2", "WE-04-ED", 2019);
        Car c3 = new Car("Camry", "Z4", "QW-45-SD", 2021);
        Car c4 = new Car("Corolla", "W4", "QS-34-FR", 2018);

            DoubleLinkedList<Car> cars = new DoubleLinkedList<>();

            cars.add(c1);
            cars.add(c2);
            cars.add(c3);
            cars.add(c4);

            printCars(cars);
            
            System.out.println("Pesquisa linear: " + Car.pesquisaLinearList(cars, c1));
            System.out.println("Pesquisa binaria: " + Car.pesquisaBinariaList(cars, c1));
        } catch (NonComparableElementException ex) {
            Logger.getLogger(Exercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void printCars(DoubleLinkedList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    }
    

