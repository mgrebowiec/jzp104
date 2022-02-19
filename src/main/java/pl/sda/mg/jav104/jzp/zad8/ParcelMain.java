package pl.sda.mg.jav104.jzp.zad8;

public class ParcelMain {

    public static void main(String[] args) {
        Parcel parcel = new Parcel(30, 30, 30, 45, true);
        ParcelValidator parcelValidator = new ParcelValidator();

        System.out.println("Wynik walidacji: " + parcelValidator.validate(parcel));

        try {
            parcelValidator.validateUsingExceptions(parcel);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
