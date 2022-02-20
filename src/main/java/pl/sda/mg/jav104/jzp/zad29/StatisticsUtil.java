package pl.sda.mg.jav104.jzp.zad29;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StatisticsUtil {

    public static <T> double partOf(List<T> elements, Predicate<T> condition) {
        if (elements == null || elements.isEmpty()) {
            return 0;
        }

        long count = elements.stream()
                .filter(condition)
                .count();

        return (double) count / (double) elements.size() * 100;
    }

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 4, 6, 8, 10, 33, 55);
        System.out.println(StatisticsUtil.partOf(elements, element -> element % 2 == 0));
    }
}
