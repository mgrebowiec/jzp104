package pl.sda.mg.jav104.jzp.zad38;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        CoffeeExpress coffeeExpress = new CoffeeExpress();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new CoffeeMaker(coffeeExpress));
        executorService.execute(new CoffeeMaker(coffeeExpress));
        executorService.execute(new CoffeeMaker(coffeeExpress));
        executorService.execute(new CoffeeMaker(coffeeExpress));
        executorService.execute(new CoffeeMaker(coffeeExpress));
        executorService.execute(new WaterTankFiller(coffeeExpress));
        executorService.execute(new WaterTankFiller(coffeeExpress));
        executorService.execute(new WaterTankFiller(coffeeExpress));
        executorService.execute(new WaterTankFiller(coffeeExpress));
        executorService.execute(new WaterTankFiller(coffeeExpress));

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            System.out.printf("%s został przerwany!", Thread.currentThread().getName());
        }

        executorService.shutdownNow();
    }

    private static class CoffeeMaker implements Runnable {
        private CoffeeExpress coffeeExpress;

        public CoffeeMaker(CoffeeExpress coffeeExpress) {
            this.coffeeExpress = coffeeExpress;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    coffeeExpress.makeCoffee();
                } catch (InterruptedException e) {
                    System.out.printf("%s konczy swoje dzialanie...\n", Thread.currentThread().getName());
                    return;
                }
            }
        }
    }

    private static class WaterTankFiller implements Runnable {
        private CoffeeExpress coffeeExpress;

        public WaterTankFiller(CoffeeExpress coffeeExpress) {
            this.coffeeExpress = coffeeExpress;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    coffeeExpress.fillWaterTank();
                } catch (InterruptedException e) {
                    System.out.printf("%s konczy swoje dzialanie...\n", Thread.currentThread().getName());
                    return;
                }
            }
        }
    }
}
