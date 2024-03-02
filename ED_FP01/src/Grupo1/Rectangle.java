package Grupo1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leona
 */
public class Rectangle  extends Shape{
    
    double height, width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return height * width;
    }

    public double getPerimeter() {
        return height * 2  + width * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "area=" + this.getArea()+ "perimeter= " + this.getPerimeter() + '}';
    }
    
    
}
