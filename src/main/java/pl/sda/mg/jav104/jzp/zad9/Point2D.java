package pl.sda.mg.jav104.jzp.zad9;

public class Point2D implements Movable {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public void move(MoveDirection moveDirection) {
        x = x + moveDirection.getX();
        // x += moveDirection.getX(); -- rownoznaczny zapis
        y = y + moveDirection.getY();
    }
}
