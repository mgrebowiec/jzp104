package pl.sda.mg.jav104.jzp.zad9;

public class Circle {
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public double getRadius() {
        return Math.sqrt(
                Math.pow(center.getX() - point.getX(), 2) +
                        Math.pow(center.getY() - point.getY(), 2)
        );
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public String toString() {
        return "Center " + center.toString() + "\nPoint " + point.toString()
                + "\n Radius " + getRadius() + "\n Perimeter " + getPerimeter()
                + "\n Area " + getArea();
    }
}
