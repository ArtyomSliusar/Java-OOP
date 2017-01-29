package lesson2.task1;


/**
 * Created by artem on 22.01.17.
 */

public class Square extends Shape {

    public Square() {}

    public Square(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
        if(isSquare()) {
            System.out.println("Square created.");
        }
    }

    public void setA(Point a) {
        super.setA(a);
        isSquare();
    }

    public void setB(Point b) {
        super.setB(b);
        isSquare();
    }

    public void setC(Point c) {
        super.setC(c);
        isSquare();
    }

    public void setD(Point d) {
        super.setD(d);
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
        return getSideLen(getA(), getB()) * 4;
    }

    @Override
    public double getArea() {
        if(!isSquare()) { System.exit(1); }
        return Math.pow(getSideLen(getA(), getB()), 2);
    }

    @Override
    public String toString() {
        return String.format("Square: perimeter - %s; area - %s", getPerimeter(), getArea());
    }
}
