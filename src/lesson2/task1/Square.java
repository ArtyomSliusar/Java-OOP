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
        if(getA() != null && getB() != null && getC() != null && getD() != null) {
            double ab = getSideLen(getA(), getB());
            double bc = getSideLen(getB(), getC());
            double cd = getSideLen(getC(), getD());
            double ad = getSideLen(getA(), getD());
            if(Double.compare(ab, bc) == 0 && Double.compare(bc, cd) == 0 && Double.compare(cd, ad) == 0) {
                square = true;
            } else {
                System.out.println("Square has different length of sides.");
            }
        } else {
            System.out.println("Please, specify all 4 points!");
        }
        return square;
    }

    @Override
    public double getPerimeter() {
        if(!isSquare()) {
            System.out.println("Can't calculate perimeter. Not a square.");
            System.exit(1);
        }
        return getSideLen(getA(), getB()) * 4;
    }

    @Override
    public double getArea() {
        if(!isSquare()) {
            System.out.println("Can't calculate area. Not a square.");
            System.exit(1);
        }
        return Math.pow(getSideLen(getA(), getB()), 2);
    }

    @Override
    public String toString() {
        return String.format("Square: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
