/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Leona
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Point> a = new ArrayList<Point>();
        ArrayList<Object> b;
        b = a;  // tipos diferentes por isso acontece este erro
        b.add(new Point(10, 20));
    }

}
