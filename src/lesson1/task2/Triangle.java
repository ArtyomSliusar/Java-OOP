package lesson1.task2;

/**
 * Created by artem on 18.01.17.
 */

public class Triangle extends Figure {

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double area() {
        double halfPerimeter = (getA() + getB() + getC()) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter-getA()) * (halfPerimeter-getB()) * (halfPerimeter-getC()));
    }
}
