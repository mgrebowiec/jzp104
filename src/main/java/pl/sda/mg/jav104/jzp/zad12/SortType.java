package pl.sda.mg.jav104.jzp.zad12;

import java.util.Comparator;
import java.util.function.Function;

public enum SortType {
    ASC,
    DESC;

    public Comparator<Car> getComparator(Function<Car, ? extends Comparable> fieldExtractor) {
        Comparator<Car> defaultComparator = Comparator.comparing( c -> fieldExtractor.apply(c));
        if (this == DESC) {
            defaultComparator = defaultComparator.reversed();
        }
        return defaultComparator;
    }
}
