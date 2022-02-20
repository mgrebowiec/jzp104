package pl.sda.mg.jav104.jzp.zad26.model;

public class Car {
    private String name;
    private String description;
    private CarType carType;

    public Car(String name, String description, CarType carType) {
        this.name = name;
        this.description = description;
        this.carType = carType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CarType getCarType() {
        return carType;
    }
}
