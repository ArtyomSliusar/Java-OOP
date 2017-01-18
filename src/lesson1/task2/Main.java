package lesson1.task2;

/**
 * Created by artem on 18.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Figure figure;
        Triangle triangleOne = new Triangle(3.6,2,3);
        Triangle triangleTwo = new Triangle(4,3,2);
        Square squareOne = new Square(2,2,2,2);
        Square squareTwo = new Square(5,5,5,5);

        figure = triangleOne;
        System.out.println(figure);
        figure = triangleTwo;
        System.out.println(figure);

        figure = squareOne;
        System.out.println(figure);
        figure = squareTwo;
        System.out.println(figure);

    }
}
