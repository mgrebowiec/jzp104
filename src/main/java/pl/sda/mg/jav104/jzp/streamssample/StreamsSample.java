package pl.sda.mg.jav104.jzp.streamssample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsSample {

    public static void main(String[] args) {
        List<String> sampleStrings = Arrays.asList("asdasd","sdfsdf","879k", "123");
        String textToSearch = "d";

        System.out.println("Klasyczna petla foreach:");
        for (String text: sampleStrings) {
            if (text.contains(textToSearch)) {
                System.out.println(text);
            }
        }

        System.out.println("Klasyczna petla for:");
        for (int i = 0; i < sampleStrings.size(); i++) {
            if (sampleStrings.get(i).contains(textToSearch)) {
                System.out.println(sampleStrings.get(i));
            }
        }

        System.out.println("Streams:");
        String result = sampleStrings.stream()
                .filter(new StringPredicate(textToSearch))
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);


        System.out.println("Streams using lambda:");
        result = sampleStrings.stream()
                .filter(text -> text.contains(textToSearch))
                .map(text -> text.toUpperCase())
                .map(text -> text.length()) // mapujemy z String do int
                .map(length -> String.valueOf(length)) // mapujemy z int do String
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);

        List<Integer> elementsContaingSearchText = sampleStrings.stream()
                .filter(text -> text.contains(textToSearch))
                .map(text -> text.length())
                .collect(Collectors.toList());

        List<String> resultList = getListContainingText(sampleStrings, textToSearch);

    }

    private static List<String> getListContainingText(List<String> input, String searchText) {
        return input.stream()
                .filter(text -> text.contains(searchText))
                .collect(Collectors.toList());
    }

    private static Stream<String> getSampleStringStream() {
        return Stream.of("pierwszy element", "drugi element", "trzeci element");
    }

    private static class StringPredicate implements Predicate<String> {

        private final String textToSearch;

        private StringPredicate(String textToSearch) {
            this.textToSearch = textToSearch;
        }

        @Override
        public boolean test(String s) {
            return s.contains(textToSearch);
        }
    }
}
