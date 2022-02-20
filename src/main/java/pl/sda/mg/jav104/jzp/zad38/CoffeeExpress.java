package pl.sda.mg.jav104.jzp.zad38;

public class CoffeeExpress {

    private boolean waterTankEmpty = false;
    private int waterLevel = 3;

    public synchronized void makeCoffee() throws InterruptedException {
        while (waterTankEmpty) {
            wait();
        }

        getWater();
        System.out.printf("%s zrobil kawke!\n", Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void fillWaterTank() throws InterruptedException {
        while (!waterTankEmpty) {
            wait();
        }

        waterLevel = 3;
        waterTankEmpty = false;
        System.out.printf("%s napelnil zbiornik z woda!\n", Thread.currentThread().getName());
        notifyAll();
    }

    private void getWater() {
        waterLevel--;
        if (waterLevel <= 0) {
            waterTankEmpty = true;
        }
    }

}
