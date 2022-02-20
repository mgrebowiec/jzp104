package pl.sda.mg.jav104.jzp.zad27;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joiner<T> {
    private final String delimeter;

    public Joiner(String delimeter) {
        this.delimeter = delimeter;
    }

    public String join(T... elements) {
        return Stream.of(elements)
                .map(element -> element.toString())
                .collect(Collectors.joining(delimeter));
    }
}
