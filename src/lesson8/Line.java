package lesson8;


/**
 * Created by artem on 08.02.17.
 */

public class Line implements Cloneable {
    private Point start;
    private Point end;

    public Line() {}

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        return new Line(this.start.clone(), this.end.clone());
    }
}
