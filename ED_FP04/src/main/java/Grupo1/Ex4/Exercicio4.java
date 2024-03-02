/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo1.Ex4;

import Grupo1.Ex1.LinkedQueue;
import java.util.Scanner;
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
        //CircularArrayQueue<Character> queue = new CircularArrayQueue<>();
        LinkedQueue<Character> linkedqueue = new LinkedQueue<>();
        Scanner scanner1 = new Scanner(System.in);
        
        System.out.print("Digite uma key: ");
        String key = scanner1.nextLine();
        
         MessagerEncoder message = new MessagerEncoder(key, linkedqueue);
         
         Scanner scanner2 = new Scanner(System.in);
        
        System.out.print("Digite a sua mensagem: ");
        String messager = scanner2.nextLine();
        message.encodeMessage(messager);
        String encodedMessage = "";
        System.out.println("Menssagem Codificada: " + (encodedMessage = message.toString()));

        message.decodeMessage(encodedMessage);

        System.out.println("Messagem Descodificada: " + message);

    }
}
