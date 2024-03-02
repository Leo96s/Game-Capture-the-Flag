package Grupo1;


/**
 *
 * @author Leona
 */
public class Circle  extends Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * 3.1416;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.1416 * radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "area=" + this.getArea()+ "perimeter= " + this.getPerimeter() + '}';
    }
}


    
    
    

    

    
    
    
    
}
