package pl.sda.mg.jav104.jzp.zad3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> sampleMap = new TreeMap<>();
        sampleMap.put("pierwszy", 1);
        sampleMap.put("drugi", 2);
        sampleMap.put("trzeci", 3);
        sampleMap.put("czwarty", 4);
        sampleMap.put("piaty", 5);
        System.out.println("Zawartosc TreeMap: " + sampleMap);

        printMap(sampleMap);
        System.out.println("-------------------------");
        printMapUsingIterator(sampleMap);
        System.out.println("-------------------------");
        printMapUsingStream(sampleMap);

//        sampleMap = new HashMap<>();
////        sampleMap.put("pierwszy", 1);
////        sampleMap.put("drugi", 2);
////        sampleMap.put("trzeci", 3);
////        sampleMap.put("czwarty", 4);
////        sampleMap.put("piaty", 5);
////        System.out.println("Zawartosc HashMap: " + sampleMap);

    }

    private static void printMapUsingIterator(Map<String, Integer> sampleMap) {
        Iterator<Map.Entry<String, Integer>> sampleIterator = sampleMap.entrySet().iterator();
        while (sampleIterator.hasNext()) {
            Map.Entry<String, Integer> mapEntry = sampleIterator.next();
            StringBuilder row = new StringBuilder("Klucz: ");
            row.append(mapEntry.getKey())
                    .append(", Wartość: ")
                    .append(mapEntry.getValue());

            if (!sampleIterator.hasNext()) {
                row.append(".");
            } else {
                row.append(",");
            }

            System.out.println(row);
        }
    }

    private static void printMap(Map<String, Integer> sampleMap) {
        Set<Map.Entry<String, Integer>> entries = sampleMap.entrySet();
        int iterationNumber = 1;
        for (Map.Entry<String, Integer> mapEntry : entries) {
            // "Klucz: " + mapEntry.getKey() + ", Wartość: " + mapEntry.getValue()
            StringBuilder row = new StringBuilder("Klucz: ");
            row.append(mapEntry.getKey())
                    .append(", Wartość: ")
                    .append(mapEntry.getValue());

            if (iterationNumber == entries.size()) {
                row.append(".");
            } else {
                row.append(",");
            }
            System.out.println(row);
            iterationNumber++;
        }
    }


    private static void printMapUsingStream(Map<String, Integer> sampleMap) {
        String message = sampleMap.entrySet().stream()
                .map(mapEntry -> "Klucz: " + mapEntry.getKey() + ", Wartość: " + mapEntry.getValue())
                .collect(Collectors.joining(",\n", "", "."));

        System.out.println(message);
    }

    // to samo co metoda #printMapUsingStream, tylko zamiast wyrażenia lambda użyliśmy
    // anonimowej klasy
    private static void printMapUsingStreamAndAnonymousClass(Map<String, Integer> sampleMap) {
        String message = sampleMap.entrySet().stream()
                .map(new Function<Map.Entry<String, Integer>, String>() {
                    @Override
                    public String apply(Map.Entry<String, Integer> mapEntry) {
                        return "Klucz: " + mapEntry.getKey() + ", Wartość: " + mapEntry.getValue();
                    }
                })
                .collect(Collectors.joining(",\n", "", "."));

        System.out.println(message);
    }

}
