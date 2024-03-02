/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Grupo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    public static void main(String[] args)  {
        ArrayStack stack = new ArrayStack();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.toString());
        
        try {
            System.out.println(stack.pop());
            System.out.println(stack.peek());
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(stack.size());
 
    }
}
