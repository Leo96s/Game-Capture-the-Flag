/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Grupo1.Ex1;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    public static void main(String[] args) {
        Car c1 = new Car("Civic", "X1", "AB-04-ED", 2020);
        Car c2 = new Car("Accord", "Y2", "WE-04-ED", 2019);
        Car c3 = new Car("Camry", "Z4", "QW-45-SD", 2021);
        Car c4 = new Car("Corolla", "W4", "QS-34-FR", 2018);

        Car[] cars = {c1, c2, c3, c4};

            System.out.println("Pesquisa Linear: " + Car.pesquisaLinear(cars, c4));

            System.out.println("Pesquisa Binária: " + Car.pesquisaBinaria(cars, c4));

    }   
}
