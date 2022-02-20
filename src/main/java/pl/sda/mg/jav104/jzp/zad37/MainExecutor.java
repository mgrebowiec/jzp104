package pl.sda.mg.jav104.jzp.zad37;

import pl.sda.mg.jav110.jzp.zad36.ThreadPlaygroundRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i < 11; i++) {
            executorService.execute(new ThreadPlaygroundRunnable("jacek-" + i));
        }

        executorService.shutdown();
    }
}
