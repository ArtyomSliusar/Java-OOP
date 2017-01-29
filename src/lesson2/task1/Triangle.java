package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public class Triangle extends Shape {

    public Triangle() {}

    public Triangle(Point a, Point b, Point c) {
        super(a, b, c);
        System.out.println("Triangle created.");
    }

    @Override
    public double getPerimeter() {
        if(getA() == null || getB() == null || getC() == null) {
            System.out.println("Please, specify all 3 points!");
            System.exit(1);
        }
        return getSideLen(getA(), getB()) + getSideLen(getB(), getC()) + getSideLen(getA(), getC());
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter-getSideLen(getA(), getB())) * (halfPerimeter-getSideLen(getB(), getC())) * (halfPerimeter-getSideLen(getA(), getC())));
    }

    @Override
    public String toString() {
        return String.format("Triangle: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
