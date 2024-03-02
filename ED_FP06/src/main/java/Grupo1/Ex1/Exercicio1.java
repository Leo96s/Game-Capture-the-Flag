 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Grupo1.Ex1;

import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class Exercicio1 {

    public static void main(String[] args) {
        SmackStack<Integer> smackStack = new SmackStack<>();

        // Adicionando elementos à pilha
        smackStack.push(1);
        smackStack.push(2);
        smackStack.push(3);

        // Imprimindo o tamanho da pilha antes do "smack"
        System.out.println("Tamanho da pilha: " + smackStack.size());
        System.out.println(smackStack.toString());

        // Smack: remove e devolve o último elemento da pilha
        int smackedElement;
        try {
            smackedElement = smackStack.Smack();
            System.out.println("Elemento Smacked: " + smackedElement);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(Exercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Imprimindo o tamanho da pilha após o "smack"
        System.out.println("Tamanho da pilha após o Smack: " + smackStack.size());
        System.out.println(smackStack.toString());
    }
}
