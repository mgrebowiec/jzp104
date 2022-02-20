package pl.sda.mg.jav104.jzp.zad14;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> randomList = generateRandomList();
        System.out.println("Rozmiar calej listy: " + randomList.size());
        List<Integer> result = randomList.stream().distinct().collect(Collectors.toList());
        System.out.println("#1: " + result);
        System.out.println("Rozmiar listy unikalnej: " + result.size());


        List<Integer> result2 = getUniqueValues(randomList);
        System.out.println("#2: " + result2);
        System.out.println("Rozmiar naszej listy unikalnej: " + result2.size());

        List<Integer> repeatedValues = getRepeatedValues(randomList);
        System.out.println("Rozmiar listy z powtarzajacymi sie elementami: " + repeatedValues.size());

        List<Integer> result3 = get25(randomList);
        System.out.println("25 najczesciej powtarzajacyh sie liczb: " + result3);

        List<Integer> uniqueValues = generateUniqueValues(randomList);
        System.out.println("Rozmiar listy z unikalnymi wartosciami: " + uniqueValues.size());
        System.out.println("Rozmiar listy z powtarzajacymi sie elementami (powinien byc 0): " + getRepeatedValues(uniqueValues).size());

    }

    private static List<Integer> generateUniqueValues(List<Integer> values) {
        List<Integer> uniqueValues = new ArrayList<>();
        values.forEach(value -> addOrGenerateUniqueValue(uniqueValues, value));
        return uniqueValues;
    }

    private static void addOrGenerateUniqueValue(List<Integer> uniqueValues, Integer value) {
        Random randomGenerator = new Random();
        while (uniqueValues.contains(value)) {
            value = randomGenerator.nextInt();
        }

        uniqueValues.add(value);
    }

    private static List<Integer> get25(List<Integer> values) {
        return getMap(values).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(25)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private static List<Integer> generateRandomList() {
        Random r = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            randomList.add(r.nextInt(100_000));
        }
        return randomList;
    }

    private static List<Integer> getRepeatedValues(List<Integer> values) {
        return getMap(values).entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private static List<Integer> getUniqueValues(List<Integer> values) {
        return getMap(values).entrySet().stream()
//                .filter(entry -> entry.getValue() < 2)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private static Map<Integer, Integer> getMap(List<Integer> randomList) {
        Map<Integer, Integer> result = new HashMap<>();
        randomList.forEach(key -> result.put(key, result.getOrDefault(key, 0) + 1));
        return result;
    }
}
