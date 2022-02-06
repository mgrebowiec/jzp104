package pl.sda.mg.jav104.jzp.zad4;

import java.util.HashMap;

public class StorageMain {

    public static void main(String[] args) {
        Storage storage = new Storage(new HashMap<>());
        storage.addToStorage("jablko", "kasztel");
        storage.addToStorage("jablko", "ligol");
        storage.addToStorage("jablko", "jonagold");
        storage.addToStorage("banan", "fajny");
        storage.addToStorage("samochod", "opel");
        storage.addToStorage("samochod", "mazda");


        storage.printValues("jablko");

        System.out.println("---------------");

        storage.findValues("ligol");
    }
}
