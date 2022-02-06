package pl.sda.mg.jav104.jzp.zad6;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> sampleMap = new TreeMap<>();
        sampleMap.put("first", "1");
        sampleMap.put("second", "2");
        sampleMap.put("third", "3");
        sampleMap.put("fourth", "4");

        printFirstAndLastElement(sampleMap);

    }

    private static void printFirstAndLastElement(TreeMap<String, String> sampleMap) {
        Map.Entry<String, String> firstEntry = sampleMap.firstEntry();
        System.out.println("First entry[" + firstEntry.getKey() + ", " + firstEntry.getValue() + "]");

        Map.Entry<String, String> lastEntry = sampleMap.lastEntry();
        System.out.println("Last entry[" + lastEntry.getKey() + ", " + lastEntry.getValue() + "]");
    }
}
