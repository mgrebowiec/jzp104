package pl.sda.mg.jav104.jzp.zad4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    private Map<String, List<String>> sampleMap = new HashMap<>();

    public Storage(Map<String, List<String>> sampleMap) {
        this.sampleMap = sampleMap;
    }

    public void addToStorage(String key, String value) {
        if (sampleMap.containsKey(key)) {
            sampleMap.get(key).add(value);
        } else {
            List<String> values = new ArrayList<>();
            values.add(value);
            sampleMap.put(key, values);
        }
    }

    public void printValues(String key) {
        System.out.println("wartosci dla klucza " + key + ": " + sampleMap.get(key));
    }

    public void findValues(String value) {
        String message = sampleMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(value))
                .map(entry -> entry.getKey())
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("Klucze zawierajace wartosc " + value + ": " + message);
    }
}
