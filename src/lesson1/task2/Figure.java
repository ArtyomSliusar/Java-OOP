package lesson1.task2;

/**
 * Created by artem on 18.01.17.
 */

public abstract class Figure {
    private double a;
    private double b;
    private double c;
    private double d;

    public Figure() {}

    public Figure(double a, double b) {
        setA(a);
        setB(b);
    }

    public Figure(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }

    public Figure(double a, double b, double c, double d) {
        setA(a);
        setB(b);
        setC(c);
        setD(d);
    }

    abstract double area();

    public double getA() {
        return a;
    }

    public void setA(double a) { if(a > 0) { this.a = a; } }

    public double getB() {
        return b;
    }

    public void setB(double b) { if(b > 0) { this.b = b; } }

    public double getC() {
        return c;
    }

    public void setC(double c) { if(c > 0) { this.c = c; } }

    public double getD() {
        return d;
    }

    public void setD(double d) { if(d > 0) { this.d = d; } }

    @Override
    public String toString() {
        String fullName = this.getClass().getName();
        String className = fullName.substring(fullName.lastIndexOf('.') + 1);
        String compoundString = String.format("Figure: %s\n", className);
        if(this.a > 0) { compoundString += String.format("a=%s\n", this.a); }
        if(this.b > 0) { compoundString += String.format("b=%s\n", this.b); }
        if(this.c > 0) { compoundString += String.format("c=%s\n", this.c); }
        if(this.d > 0) { compoundString += String.format("d=%s\n", this.d); }

        return compoundString + String.format("area=%s\n", area());
    }
}
