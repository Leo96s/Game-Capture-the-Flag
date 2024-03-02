package Grupo1;


import Grupo1.Circle;
import Grupo1.Canvas;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Leona
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Canvas<Shape> canvas = new Canvas<>();

        Circle circle = new Circle(5); // Suponha que você tenha uma classe Circle que estende Shape
        Rectangle rectangle = new Rectangle(4, 6); // Suponha que você tenha uma classe Rectangle que estende Shape

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        canvas.drawAll(shapes);
          }
    }
    
