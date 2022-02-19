package pl.sda.mg.jav104.jzp.zad12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    //nazwa, model, cena, rok produkcji, lista producentów (Manufacturer), oraz typ silnika
    private final String name;
    private final String model;
    private final double price;
    private final int year;
    private List<Manufacturer> manufacturers = new ArrayList<>();
    private final EngineType engineType;

    public Car(String name, String model, double price, int year, List<Manufacturer> manufacturers, EngineType engineType) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.year = year;
        this.manufacturers = manufacturers;
        this.engineType = engineType;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                year == car.year &&
                Objects.equals(name, car.name) &&
                Objects.equals(model, car.model) &&
                Objects.equals(manufacturers, car.manufacturers) &&
                engineType == car.engineType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, price, year, manufacturers, engineType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", manufacturers=" + manufacturers +
                ", engineType=" + engineType +
                '}';
    }
}
