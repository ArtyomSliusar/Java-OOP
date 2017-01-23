package lesson2.task1;


/**
 * Created by artem on 23.01.17.
 */

public class Main {
    public static void main(String[] args) {
        Square squareOne = new Square(new Point(1.0, 2.0), new Point(2.0, 2.0), new Point(2.0, 1.0), new Point(1.0, 1.0));
        Square squareTwo = new Square(new Point(1.0, 3.0), new Point(3.0, 3.0), new Point(3.0, 1.0), new Point(1.0, 1.0));

        Triangle triangleOne = new Triangle(new Point(1.0, 2.0), new Point(2.0, 2.0), new Point(2.0, 1.0));
        Triangle triangleTwo = new Triangle(new Point(2.0, 4.0), new Point(3.0, 2.0), new Point(2.0, 1.0));

        Rectangle rectangleOne = new Rectangle(new Point(1.0, 2.0), new Point(3.0, 2.0), new Point(3.0, 1.0), new Point(1.0, 1.0));

        Board boardOne = new Board();
        boardOne.addFigure(triangleOne);
        boardOne.addFigure(rectangleOne);
        boardOne.addFigure(squareOne);
        boardOne.addFigure(squareTwo);
        boardOne.showInfo();

        boardOne.addFigure(triangleTwo);
        boardOne.removeFigure(triangleOne);
        boardOne.addFigure(triangleTwo);
        boardOne.showInfo();
    }
}
