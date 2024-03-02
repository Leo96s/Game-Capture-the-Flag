package Grupo1;


import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Leona
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        void printCollection
        (Collection<Object> c
        
            ) {
for (Object e : c) {
                System.out.println(e);
            }
        }
        String myString;
        Object myObject;
        List<?> c = new ArrayList<String>();
// c.add("hello world"); // compile error
// c.add(new Object()); // compile error
        ((List<String>) c).add("hello world");
        ((List<Object>) c).add(new Object()); // no compile error!
// String myString = c.get(0); // compile error
        myString = (String) c.get(0);
        myObject = c.get(0);
        myString = (String) c.get(1); // run-time error!
    }

}
