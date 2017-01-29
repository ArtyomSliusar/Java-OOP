package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public class Rectangle extends Shape {

    public Rectangle() {}

    public Rectangle(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        if(isRectangle()) {
            System.out.println("Rectangle created.");
        }
    }

    public void setA(Point a) {
        super.setA(a);
        isRectangle();
    }

    public void setB(Point b) {
        super.setB(b);
        isRectangle();
    }

    public void setC(Point c) {
        super.setC(c);
        isRectangle();
    }

    public void setD(Point d) {
        super.setD(d);
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
                System.out.println("Can't create rectangle from current points. Different length of sides.");
            }
        } else {
            System.out.println("Please, specify all 4 points!");
        }
        return rectangle;
    }

    @Override
    public double getPerimeter() {
        if(!isRectangle()) { System.exit(1); }
        return getSideLen(getA(), getB()) * 2 + getSideLen(getB(), getC()) * 2;
    }

    @Override
    public double getArea() {
        if(!isRectangle()) { System.exit(1); }
        return getSideLen(getA(), getB()) * getSideLen(getB(), getC());
    }

    @Override
    public String toString() {
        return String.format("Rectangle: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
