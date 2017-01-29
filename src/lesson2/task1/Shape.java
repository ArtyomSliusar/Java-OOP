package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public abstract class Shape {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    Shape() {}

    Shape(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Shape(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        System.out.println("Point D was set.");
    }

    abstract double getPerimeter();

    abstract double getArea();

    public double getSideLen(Point start, Point end) {
        return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow((end.getY() - start.getY()), 2));
    }
}
