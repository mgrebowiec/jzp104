package pl.sda.mg.jav104.jzp.zad12;

import java.util.Arrays;
import java.util.List;

public class CarMain {
    public static void main(String[] args) {
        Car polo = new Car("WV Polo", "POLO", 100, 2015,
                Arrays.asList(new Manufacturer("XTZ", 1984, "Germany")),
                EngineType.V6
        );

        Car golf = new Car("WV Golf", "GOLF", 200, 2015,
                Arrays.asList(new Manufacturer("XTZ", 1984, "Germany")),
                EngineType.S4
        );

        Car citroen = new Car("Citroen AX", "AX", 300, 1998,
                Arrays.asList(new Manufacturer("XTZ", 1984, "Germany")),
                EngineType.S4
        );

        System.out.println(polo);
        CarService carService = new CarService();
        carService.add(polo)
                .add(golf)
                .remove(polo)
                .add(citroen)
                .add(polo);


//        carService.getCars().add(null); // ta operacja spowoduje blad programu

        List<Car> carsWithS4Engine = carService.getCarsWithEngine(EngineType.S4);
        System.out.println("Samochody z silnikiem S4: \n" + carsWithS4Engine);

        List<Car> carsWithProductionYearBefore1999 = carService.getCarsProducedBeforeYear(1999);
        System.out.println("Samochody wyprodukowane przed 1999: \n" + carsWithProductionYearBefore1999);

        Car mostExpensiveCar = carService.getMostExpensiveCar();
        System.out.println("Najdrozsze auto to: " + mostExpensiveCar);

        Car cheapestCar = carService.getCheapestCar();
        System.out.println("Najtansze auto to: " + cheapestCar);

    }
}
