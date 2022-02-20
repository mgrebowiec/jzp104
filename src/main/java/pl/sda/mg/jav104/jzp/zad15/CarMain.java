package pl.sda.mg.jav104.jzp.zad15;

public class CarMain {
    public static void main(String[] args) {
        System.out.println("Ferrari czy jest szybsze niz OPEL: " + Car.FERRARI.isFasterThan(Car.OPEL));
        System.out.println("Toyota czy jest premium: " + Car.TOYOTA.isPremium());
    }
}
