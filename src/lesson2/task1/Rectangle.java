package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public class Rectangle extends Shape {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Rectangle() {}

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if(isRectangle()) {
            System.out.println("Rectangle created.");
        }
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        System.out.println("Point A was set.");
        isRectangle();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        System.out.println("Point B was set.");
        isRectangle();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        System.out.println("Point C was set.");
        isRectangle();
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        System.out.println("Point D was set.");
        isRectangle();
    }

    private boolean isRectangle() {
        /** Method supposes that points are in order: a,b,c,d */
        boolean rectangle = false;
        if(getA() != null && getB() != null && getC() != null && getD() != null) {
            double ab = getSideLen(getA(), getB());
            double bc = getSideLen(getB(), getC());
            double cd = getSideLen(getC(), getD());
            double ad = getSideLen(getA(), getD());
            if(Double.compare(ab, cd) == 0 && Double.compare(bc, ad) == 0 && Double.compare(ab, bc) != 0) {
                rectangle = true;
            } else {
                System.out.println("Rectangle has different length of sides.");
            }
        } else {
            System.out.println("Please, specify all 4 points!");
        }
        return rectangle;
    }

    @Override
    public double getPerimeter() {
        if(!isRectangle()) {
            System.out.println("Can't calculate perimeter. Not a rectangle.");
            System.exit(1);
        }
        return getSideLen(getA(), getB()) * 2 + getSideLen(getB(), getC()) * 2;
    }

    @Override
    public double getArea() {
        if(!isRectangle()) {
            System.out.println("Can't calculate area. Not a rectangle.");
            System.exit(1);
        }
        return getSideLen(getA(), getB()) * getSideLen(getB(), getC());
    }

    @Override
    public String toString() {
        return String.format("Rectangle: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
