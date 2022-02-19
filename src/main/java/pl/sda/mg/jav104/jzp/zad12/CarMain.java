package pl.sda.mg.jav104.jzp.zad12;

import java.util.Arrays;

public class CarMain {
    public static void main(String[] args) {
        Car polo = new Car("WV Polo", "POLO", 100, 2015,
                Arrays.asList(new Manufacturer("XTZ", 1984, "Germany")),
                EngineType.V6
        );

        System.out.println(polo);
    }
}
