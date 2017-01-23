package lesson2.task1;

/**
 * Created by artem on 22.01.17.
 */

public abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();

    public double getSideLen(Point start, Point end) {
        return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow((end.getY() - start.getY()), 2));
    }
}
