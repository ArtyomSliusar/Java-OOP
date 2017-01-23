package lesson2.task1;


/**
 * Created by artem on 22.01.17.
 */

public class Square extends Shape {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Square() {}

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if(isSquare()) {
            System.out.println("Square created.");
        }
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        System.out.println("Point A was set.");
        isSquare();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        System.out.println("Point B was set.");
        isSquare();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        System.out.println("Point C was set.");
        isSquare();
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        System.out.println("Point D was set.");
        isSquare();
    }

    private boolean isSquare() {
        /** Method supposes that points are in order: a,b,c,d */
        boolean square = false;
        if(a != null && b != null && c != null && d != null) {
            double ab = getSideLen(a, b);
            double bc = getSideLen(b, c);
            double cd = getSideLen(c, d);
            double ad = getSideLen(a, d);
            if(Double.compare(ab, bc) != 0 || Double.compare(bc, cd) != 0 || Double.compare(cd, ad) != 0) {
                System.out.println("Can't create square from current points. Different length of sides.");
            }
            square = true;
        } else {
            System.out.println("Please, specify all 4 points!");
        }
        return square;
    }

    @Override
    public double getPerimeter() {
        if(!isSquare()) { System.exit(1); }
        return getSideLen(a, b) * 4;
    }

    @Override
    public double getArea() {
        if(!isSquare()) { System.exit(1); }
        return Math.pow(getSideLen(a, b), 2);
    }

    @Override
    public String toString() {
        return String.format("Square: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
