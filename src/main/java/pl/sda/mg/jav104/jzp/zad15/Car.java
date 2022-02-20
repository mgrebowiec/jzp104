package pl.sda.mg.jav104.jzp.zad15;

import java.util.Arrays;
import java.util.List;

public enum Car {
    FERRARI(100000, 350, true),
    PORSCHE(10000, 300, true),
    MERCEDES(19900, 290, true),
    BMW(189234, 280, true),
    OPEL(3000, 150, false),
    FIAT(2000, 100, false),
    TOYOTA(4000, 160, false);

    private final double price;
    private final int power;
    private final boolean premium;

    private static final List<Car> premiumCars = Arrays.asList(FERRARI, PORSCHE, MERCEDES, BMW);

    Car(double price, int power, boolean premium) {
        this.price = price;
        this.power = power;
        this.premium = premium;
    }

    public boolean isPremium() {
        return premiumCars.contains(this);
    }

    public boolean isRegular() {
        return premium;
    }

    public boolean isFasterThan(Car car) {
        return this.compareTo(car) < 0;
    }

}
