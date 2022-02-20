package pl.sda.mg.jav104.jzp.zad36;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadPlaygroundRunnable("jacek"));
        Thread t2 = new Thread(new ThreadPlaygroundRunnable("placek"));

        t1.start();
        t2.start();

        try {
            t1.interrupt();
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("t1 zostal przerwany");
        }
        System.out.println(Thread.currentThread().getName());
    }
}
