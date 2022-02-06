package pl.sda.mg.jav104.jzp.zad1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("asdas", "Asss", "hhhh", "Z", "z");
        sampleList = sort(sampleList);
        System.out.println("Wynik: " + sampleList);

        sampleList = Arrays.asList("asdas", "Asss", "hhhh", "Z", "z");
        sampleList = sortUsingOwnComparator(sampleList);
        System.out.println("Wynik po sortowaniu wlasnym komparatorem:" + sampleList);
    }

    private static List<String> sort(List<String> input) {
        input.sort(CASE_INSENSITIVE_ORDER.reversed());
        return input;
    }

    private static List<String> sortUsingOwnComparator(List<String> input) {
        input.sort(new MyOwnComparator());
        return input;
    }

    private static class MyOwnComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return -s1.toUpperCase().compareTo(s2.toUpperCase());
        }
    }
}
