package exercise;

// BEGIN
public class Segment {
    private Point begin;
    private Point end;

    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Point getBeginPoint() {
        return begin;
    }

    public Point getEndPoint() {
        return end;
    }

    public Point getMidPoint() {
        int x1 = begin.getX();
        int y1 = end.getX();

        int x2 = begin.getY();
        int y2 = end.getY();

        return new Point((x1 + y1) / 2, (x2 + y2) / 2);
    }
}
// END
