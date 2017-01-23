package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public class Triangle extends Shape {
    private Point a;
    private Point b;
    private Point c;

    public Triangle() {}

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println("Triangle created.");
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        System.out.println("Point A was set.");
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        System.out.println("Point B was set.");
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        System.out.println("Point C was set.");
    }

    @Override
    public double getPerimeter() {
        if(a == null || b == null || c == null) {
            System.out.println("Please, specify all 3 points!");
            System.exit(1);
        }
        return getSideLen(a, b) + getSideLen(b, c) + getSideLen(a, c);
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter-getSideLen(a, b)) * (halfPerimeter-getSideLen(b, c)) * (halfPerimeter-getSideLen(a, c)));
    }

    @Override
    public String toString() {
        return String.format("Triangle: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
