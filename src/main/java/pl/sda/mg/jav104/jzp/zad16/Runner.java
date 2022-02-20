package pl.sda.mg.jav104.jzp.zad16;

import java.util.stream.Stream;

public enum Runner {
    BEGINNER(15, 40),
    INTERMEDIATE(8, 14),
    ADVANCED(3, 7);

    private final int minTime;
    private final int maxTime;

    Runner(int minTime, int maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public static Runner getFitnessLevel(int time) {
        return Stream.of(values())
                .filter(runner -> runner.minTime <= time && runner.maxTime >= time)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nie ma poziomu dla przekazanego czasu: " + time));
    }
}
