package exercise;

// BEGIN
public class Circle {
    private Point centre;
    private int radius;

    public Circle(Point centre, int radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("");
        }

        return Math.PI * Math.pow(radius, 2);
    }
}
// END
