package pl.sda.mg.jav104.jzp.zad26.model;

import java.util.List;

public class Model {
    private String name;
    private int productionStartYear;
    private List<Car> cars;

    public Model(String name, int productionStartYear, List<Car> cars) {
        this.name = name;
        this.productionStartYear = productionStartYear;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public int getProductionStartYear() {
        return productionStartYear;
    }

    public List<Car> getCars() {
        return cars;
    }
}
