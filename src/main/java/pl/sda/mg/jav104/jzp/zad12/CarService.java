package pl.sda.mg.jav104.jzp.zad12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
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

    public List<Car> getCarsWithManufacturersMinCount(int minCount) {
        return cars.stream()
                .filter(car -> car.getManufacturers().size() >= minCount)
                .collect(Collectors.toList());
    }

    public List<Car> sortCars(SortType sortType, Function<Car, ? extends Comparable> fieldExtractor) {
        return cars.stream()
                .sorted(sortType.getComparator(fieldExtractor))
                .collect(Collectors.toList());
    }

    public boolean hasCar(Car car) {
        return cars.contains(car);
    }

    // sprawdz czy istnieje auto o podanej nazwie i cenie nie wiekszej niz przekazana
    public boolean isCarExistWithNameAndMaxPrice(String name, double maxPrice) {
        // odpowienidk tego co niżej
//        return cars.stream()
//                .filter(car -> car.getName().equals(name) && car.getPrice() <= maxPrice)
//                .findFirst()
//                .orElse(null) != null;


        return cars.stream()
                .anyMatch(car -> car.getName().equals(name) && car.getPrice() <= maxPrice);
    }

    //zwracanie listy aut wyprodukowanych przez konkretnego producenta
    public List<Car> getCarsProducedBy(Manufacturer manufacturer) {
        return cars.stream()
                .filter(car -> car.getManufacturers().contains(manufacturer))
                .collect(Collectors.toList());
    }

    // zwracanie listy aut wyprodukowanych przez producenta z rokiem założenia <,>,<=,>=,=,!= od podanego.
    public List<Car> getCarsProducedByManufacturerWithYear(int year, ComparisonFunction comparisonFunction) {
        return cars.stream()
                .filter(car -> car.getManufacturers().stream().anyMatch(comparisonFunction.getManufacturerPredicate(year)))
                .collect(Collectors.toList());
    }


}
