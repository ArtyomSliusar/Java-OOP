package lesson2.task1;


/**
 * Created by artem on 22.01.17.
 */

public class Board {
    private Shape[] boardParts = new Shape[4];

    public Board() {}

    public Board(Shape[] boardParts) {
        this.boardParts = boardParts;
    }

    public void addFigure(Shape figure) {
        for(int i=0; i<boardParts.length; i++) {
            if(boardParts[i] == null) {
                boardParts[i] = figure;
                return;
            }
        }
        System.out.println("Can't add figure. Board is full!");
    }

    public void removeFigure(Shape figure) {
        for(int i=0; i<boardParts.length; i++) {
            if(boardParts[i] == figure) {
                boardParts[i] = null;
                return;
            }
        }
        System.out.println("Can't remove figure. Figure not found!");
    }

    public void showInfo() {
        double occupiedSquare=0;
        System.out.println("Board has such figures:");
        for(Shape figure : boardParts) {
            occupiedSquare += figure.getArea();
            System.out.println(figure);
        }
        System.out.println(String.format("Occupied square is: %s", occupiedSquare));
    }
}
