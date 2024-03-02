/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        List<String> listaDeStrings = new ArrayList<>();

        // Adicione algumas strings à lista
        listaDeStrings.add("Maçã");
        listaDeStrings.add("Banana");
        listaDeStrings.add("Pêra");
        listaDeStrings.add("Laranja");
        listaDeStrings.add("Abacaxi");

        // Chame o método para ordenar a lista com base no tamanho das strings
        ordenarPorTamanho(listaDeStrings);

        // Exiba a lista ordenada
        for (String str : listaDeStrings) {
            System.out.println(str);
        }
    }

    // Método genérico para ordenar a lista de strings por tamanho
    public static void ordenarPorTamanho(List<String> lista) {
        Collections.sort(lista, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
    }
}

    
    
