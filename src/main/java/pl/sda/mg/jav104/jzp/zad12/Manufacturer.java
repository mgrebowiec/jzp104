package pl.sda.mg.jav104.jzp.zad12;

import java.util.Objects;

public class Manufacturer {
    //nazwa, rok założenia, kraj
    private final String name;
    private final int year;
    private final String country;

    public Manufacturer(String name, int year, String country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Manufacturer)) {
            return false;
        }
        Manufacturer that = (Manufacturer) o;
        return year == that.year &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, country);
    }

    @Override
    public String toString() {
        return "Manufacturer[" + name + ", " + year + ", " + country + "]";
    }
}
