package exercise;

// BEGIN
public class Flat implements Home{
    private final double area;
    private final double balconyArea;
    private final int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home anotherHome) {
        if (anotherHome.getArea() != area) {
            return anotherHome.getArea() > area ? 1 : -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return String.format("Квартира площадью %s метров на %s этаже", getArea(), floor);
    }
}
// END
