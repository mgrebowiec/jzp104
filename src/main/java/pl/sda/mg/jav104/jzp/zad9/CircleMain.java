package pl.sda.mg.jav104.jzp.zad9;

public class CircleMain {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point2D(0,0), new Point2D(5, 0));
        System.out.println(circle);

        System.out.println("Po przesunieciu");
        circle.move(new MoveDirection(1, 0));
        System.out.println(circle);

        System.out.println("Po zmianie rozmiaru");
        circle.resize(2);
        System.out.println(circle);
    }
}
