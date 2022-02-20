package pl.sda.mg.jav104.jzp.zad36;

public class ThreadPlaygroundRunnable implements Runnable {
    private String name;

    public ThreadPlaygroundRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i < 11; i++) {
            System.out.printf("%s (%s): #%d\n", Thread.currentThread().getName(), name, i);
        }
    }
}
