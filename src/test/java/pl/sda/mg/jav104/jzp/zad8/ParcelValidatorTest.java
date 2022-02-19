package pl.sda.mg.jav104.jzp.zad8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParcelValidatorTest {

    ParcelValidator parcelValidator = new ParcelValidator();

    @ParameterizedTest
    @MethodSource("validParcels")
    void shouldReturnTrueForValidParcel(Parcel parcel) {
        boolean result = parcelValidator.validate(parcel);
        assertEquals(true, result);
    }

    @ParameterizedTest
    @MethodSource("nonValidParcels")
    void shouldReturnFalseForNonValidParcel(Parcel parcel) {
        boolean result = parcelValidator.validate(parcel);
        assertEquals(false, result);
    }

    private static Stream<Parcel> validParcels() {
        return Stream.of(
                new Parcel(30, 30, 30, 15, true),
                new Parcel(30, 30, 30, 30, false),
                new Parcel(30, 30, 30, 0, true),
                new Parcel(200, 30, 30, 15, true)
        );
    }

    private static Stream<Parcel> nonValidParcels() {
        return Stream.of(
                new Parcel(30, 30, 30, 16, true),
                new Parcel(30, 30, 30, 31, false),
                new Parcel(29, 30, 30, 15, true),
                new Parcel(30, 29, 30, 15, true),
                new Parcel(30, 30, 29, 15, true),
                new Parcel(100, 100, 101, 15, true)
        );
    }

}