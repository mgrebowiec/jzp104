package pl.sda.mg.jav104.jzp.zad12;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public enum ComparisonFunction {
    LESS_THAN((supplier, value) -> supplier.get() < value),
    LESS_OR_EQUAL((supplier, value) -> supplier.get() <= value),
    MORE_THAN((supplier, value) -> supplier.get() > value),
    MORE_OR_EQUAL((supplier, value) -> supplier.get() >= value),
    EQUAL((supplier, value) -> supplier.get() == value),
    NOT_EQUAL((supplier, value) -> supplier.get() != value)
    ;

    private final BiFunction<Supplier<Integer>, Integer, Boolean> comparisonFunction;

    ComparisonFunction(BiFunction<Supplier<Integer>, Integer, Boolean> comparisonFunction) {
        this.comparisonFunction = comparisonFunction;
    }

    public Predicate<Manufacturer> getManufacturerPredicate(Integer valueToCompare) {
        return manufacturer -> comparisonFunction.apply(manufacturer::getYear, valueToCompare);
    }
}
