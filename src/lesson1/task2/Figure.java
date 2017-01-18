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
        this.a = a;
        this.b = b;
    }

    public Figure(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Figure(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    abstract double area();

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

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
