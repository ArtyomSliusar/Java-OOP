package lesson1.task2;

/**
 * Created by artem on 18.01.17.
 */

public class Square extends Figure{

    public Square() {
    }

    public Square(double a, double b, double c, double d) {
        super(a, b, c, d);
    }

    @Override
    public double area() {
        return Math.pow(getA(), 2);
    }
}
