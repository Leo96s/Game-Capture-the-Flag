/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

import Grupo1.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    /**
     * @param args the command line arguments
     * @throws Grupo1.EmptyCollectionException
     */
    public static void main(String[] args) throws EmptyCollectionException {
        PostFixCalculatorwithArrayStack postfix = new PostFixCalculatorwithArrayStack();
        String expressao = "7.23 4 -3 * 1 5  + / *";
        
        System.out.println(postfix.PostFixExpression(expressao));
    }
    
}
