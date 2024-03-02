/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author Leona
 */
public class Teste2 {

    public static void main(String[] args) {
        Pair<Integer> secretPair = new Pair<Integer>(42, 24);
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int n1 = Keyboard.nextInt();
        int n2 = Keyboard.nextInt();
        Pair<Integer> inputPair = new Pair<Integer>(n1, n2);
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
