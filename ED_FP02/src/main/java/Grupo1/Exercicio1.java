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

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("Ola");
        linkedList.add("qwer");
        linkedList.add(3);
        linkedList.add(4);

        System.out.println(linkedList);

        try {
            System.out.println("Elemento Removido: " + linkedList.remove("heheh"));
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(linkedList.toString());
        } catch (ElementNotFoundException ex) {
            Logger.getLogger(LinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
