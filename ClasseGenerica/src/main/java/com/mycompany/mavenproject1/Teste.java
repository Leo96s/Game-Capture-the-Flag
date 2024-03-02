/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author Leonardo Silva
 */
public class Teste {

    public static void main(String[] args) {
        Pair<String> secretPair
                = new Pair<String>("Happy", "Day");
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Enter two words:");
        String word1 = Keyboard.next();
        String word2 = Keyboard.next();
        Pair<String> inputPair
                = new Pair<String>(word1, word2);
        if (inputPair.equals(secretPair)) {
            System.out.println("You guesses the secret words");
            System.out.println("in the correct order!");
        } else {
            System.out.println("You guesses incorrectly.");
            System.out.println("You guessed");
            System.out.println(inputPair);
            System.out.println("The secret words are");
            System.out.println(secretPair);
        }
    }
}
