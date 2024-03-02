package Grupo1;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TwoTypePair<Integer, Integer> secretPair = new TwoTypePair<Integer, Integer>(42, 24);
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int n1 = Keyboard.nextInt();
        int n2 = Keyboard.nextInt();
        TwoTypePair<Integer, Integer> inputPair = new TwoTypePair<Integer, Integer>(n1, n2);
        if (inputPair.equals(secretPair)) {
            System.out.println("You guesses the secret numbers");
            System.out.println("in the correct two order!");
        } else {
            System.out.println("You guesses incorrectly.");
            System.out.println("You guessed");
            System.out.println(inputPair);
            System.out.println("The secret numbers are");
            System.out.println(secretPair);
        }
    }
    }
    
