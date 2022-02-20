package pl.sda.mg.jav104.jzp.zad26;

import pl.sda.mg.jav110.jzp.zad26.model.Car;
import pl.sda.mg.jav110.jzp.zad26.model.CarType;
import pl.sda.mg.jav110.jzp.zad26.model.Manufacturer;
import pl.sda.mg.jav110.jzp.zad26.model.Model;

import java.util.Arrays;
import java.util.List;

public class CarMain {
    public static void main(String[] args) {

        List<Manufacturer> manufacturers = Arrays.asList(
                createVwManufacturer(),
                createRenaultManufacturer()
        );


    }

    private static Manufacturer createVwManufacturer() {
        List<Car> cars = Arrays.asList(
                new Car("VW Golf", "VW Golf description", CarType.HATCHBACK),
                new Car("VW Golf", "VW Golf description", CarType.CABRIO)
        );
        Model model1 = new Model("Golf b5", 1950, cars);

        cars = Arrays.asList(
                new Car("VW Passat", "VW Golf description", CarType.SEDAN),
                new Car("VW Passat", "VW Golf description", CarType.COUPE)
        );
        Model model2 = new Model("Passat b5", 1949, cars);
        List<Model> models = Arrays.asList(
                model1,
                model2
        );
        return new Manufacturer("Volkswagen", 1928, models);
    }

    private static Manufacturer createRenaultManufacturer() {
        List<Car> cars = Arrays.asList(
                new Car("Clio", "Clio description", CarType.HATCHBACK),
                new Car("Clio", "Clio description", CarType.CABRIO)
        );
        Model model1 = new Model("Clio 1", 1952, cars);

        cars = Arrays.asList(
                new Car("Megane", "Megane description", CarType.SEDAN),
                new Car("Megane", "Megane description", CarType.HATCHBACK)
        );
        Model model2 = new Model("Megane 1", 1951, cars);
        List<Model> models = Arrays.asList(
                model1,
                model2
        );
        return new Manufacturer("Renault", 1928, models);
    }



}
