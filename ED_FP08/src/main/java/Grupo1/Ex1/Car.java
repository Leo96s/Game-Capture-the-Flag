/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo1.Ex1;

import Grupo1.Ex2.DoubleLinkedList;
import Search.SortingAndSearching;
import Search.SortingAndSearchingLinkedList;

/**
 * Classe que representa um carro.
 *
 * @param brand Marca do carro.
 * @param model Modelo do carro.
 * @param plate Placa do carro.
 * @param year Ano do carro.
 */
public class Car implements Comparable<Car> {

    private String brand; // Marca do carro
    private String model; // Modelo do carro
    private String plate; // Placa do carro
    private int year;     // Ano do carro

    /**
     * Construtor da classe Carro.
     *
     * @param brand Marca do carro.
     * @param model Modelo do carro.
     * @param plate Placa do carro.
     * @param year Ano do carro.
     */
    public Car(String brand, String model, String plate, int year) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.year = year;
    }

    /**
     * Obtém a placa do carro.
     *
     * @return Placa do carro.
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Obtém a marca do carro.
     *
     * @return Marca do carro.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Obtém o modelo do carro.
     *
     * @return Modelo do carro.
     */
    public String getModel() {
        return model;
    }

    /**
     * Obtém o ano do carro.
     *
     * @return Ano do carro.
     */
    public int getYear() {
        return year;
    }

    /**
     * Compara dois carros com base na placa.
     *
     * @param outroCarro Carro a ser comparado.
     * @return Valor negativo se o carro atual for menor, valor positivo se for
     * maior, 0 se forem iguais.
     */
    @Override
    public int compareTo(Car outroCarro) {
        return this.plate.compareTo(outroCarro.plate);
    }

    /**
     * Retorna uma representação em string do objeto Carro.
     *
     * @return Representação em string do objeto Carro.
     */
    @Override
    public String toString() {
        return "Car{" + brand + ", " + model + ", " + plate + ", " + year + '}';
    }

    // Pesquisa Linear usando SortingAndSearching.linearSearch
    public static Car pesquisaLinear(Car[] cars, Car car) {
        boolean catche = SortingAndSearching.linearSearch(cars, 0, cars.length - 1, car);
        return (catche) ? car : null;
    }

    // Pesquisa Binária usando SortingAndSearching.binarySearch
    public static Car pesquisaBinaria(Car[] cars, Car car) {
        boolean catche = SortingAndSearching.binarySearch(cars, 0, cars.length - 1, car);
        return (catche) ? car : null;
    }

    // Pesquisa Linear usando SortingAndSearching.linearSearch
    public static Car pesquisaLinearList(DoubleLinkedList cars, Car car) {
        boolean catche = SortingAndSearchingLinkedList.linearSearchList(cars, car);
        return (catche) ? car : null;
    }

    // Pesquisa Binária usando SortingAndSearching.binarySearch
    public static Car pesquisaBinariaList(DoubleLinkedList cars, Car car) {
        boolean catche = SortingAndSearchingLinkedList.binarySearchList(cars, 0, cars.size() - 1, car);
        return (catche) ? car : null;
    }

}
