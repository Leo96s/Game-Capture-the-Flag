package Grupo1;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Leona
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        int n1 = Keyboard.nextInt();
        int n2 = Keyboard.nextInt();
         Pair<Integer> inputPair = new Pair<Integer>();
         inputPair.setFirst(n1);
         inputPair.setSecond(n2);
        
        System.out.println("Enter two numbers:");
        
        System.out.println("O valor maximo e: " + inputPair.max());
    }
}
