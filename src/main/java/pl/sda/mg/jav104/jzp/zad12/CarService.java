package pl.sda.mg.jav104.jzp.zad12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public CarService add(Car car) {
        cars.add(car);
        return this;
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public CarService remove(Car car) {
        cars.remove(car);
        return this;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void printCars() {
        System.out.println(cars);
    }

    public List<Car> getCarsWithEngine(EngineType engineType) {
        return cars.stream()
                .filter(car -> engineType == car.getEngineType())
                .collect(Collectors.toList());
    }

    public List<Car> getCarsProducedBeforeYear(int year) {
        return cars.stream()
                .filter(car -> car.getYear() < year)
                .collect(Collectors.toList());
    }

    public Car getMostExpensiveCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }

    public Car getCheapestCar() {
        return cars.stream()
                .min(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }

}
