package pl.sda.mg.jav104.jzp.zad7;

import java.util.ArrayList;
import java.util.List;

public class Gun {
    private final int maxSize;
    private List<String> bullets = new ArrayList<>();

    public Gun(int maxSize) {
        this.maxSize = maxSize;
    }

    public void loadBullet(String bullet) {
        if (bullets.size() >= maxSize) {
            System.out.println("Nie mozna dodac do magazynku naboju: " + bullet);
        } else {
            bullets.add(bullet);
        }
    }

    public boolean isLoaded() {
        return bullets.size() > 0;
    }

    public void shot() {
        if (!isLoaded()) {
            System.out.println("Magazynek jest pusty, nie mozemy strzelac!");
            return;
        }

        String bullet = bullets.remove(bullets.size() - 1);
        System.out.println("Wystrzelono kule: " + bullet);

        if (!isLoaded()) {
            System.out.println("Magazynek jest pusty!");
        }

    }
}
