package pl.sda.mg.jav104.jzp.zad26.model;

import java.util.List;

public class Manufacturer {
    private String name;
    private int yearOfCreation;
    List<Model> models;

    public Manufacturer(String name, int yearOfCreation, List<Model> models) {
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public List<Model> getModels() {
        return models;
    }
}
