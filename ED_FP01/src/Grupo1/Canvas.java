package Grupo1;


import java.util.ArrayList;

/**
 *
 * @author Leona
 */
public class Canvas<T extends Shape> {

    public void draw(T shape) {
        System.out.println(shape.toString());
    }

    public void drawAll(ArrayList<T> shapes) {
        for (T shape : shapes) {
            draw(shape);
        }
    }
}
