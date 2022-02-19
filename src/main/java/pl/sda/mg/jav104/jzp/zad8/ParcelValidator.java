package pl.sda.mg.jav104.jzp.zad8;

public class ParcelValidator implements Validator {
    @Override
    public boolean validate(Parcel parcel) {
        //Validator powinien weryfikować czy suma wymiarów (x, y, z) nie przekracza 300
        if (parcel.getxLength() + parcel.getyLength() + parcel.getzLength() > 300) {
            System.out.println("Suma wymiarow wieksza niz 300");
            return false;
        }

        //czy każdy z rozmiarów nie jest mniejszy niż 30
        if (parcel.getxLength() < 30) {
            System.out.println("Rozmiar x mniejszy niz 30");
            return false;
        }

        if (parcel.getyLength() < 30) {
            System.out.println("Rozmiar y mniejszy niz 30");
            return false;
        }

        if (parcel.getzLength() < 30) {
            System.out.println("Rozmiar z mniejszy niz 30");
            return false;
        }

        // czy waga nie przekracza 30.0 dla isExpress=false lub 15.0 dla isExpress=true.
        if (parcel.isExpress() && parcel.getWeight() > 15) {
            System.out.println("isExpress true i waga wieksza niz 15");
            return false;
        }

        if (!parcel.isExpress() && parcel.getWeight() > 30) {
            System.out.println("isExpress false i waga wieksza niz 30");
            return false;
        }

        return true;
    }

    public void validateUsingExceptions(Parcel parcel) {
        //Validator powinien weryfikować czy suma wymiarów (x, y, z) nie przekracza 300
        if (parcel.getxLength() + parcel.getyLength() + parcel.getzLength() > 300) {
            throw new IllegalStateException("Suma wymiarow wieksza niz 300");
        }

        //czy każdy z rozmiarów nie jest mniejszy niż 30
        if (parcel.getxLength() < 30) {
            throw new IllegalStateException("Rozmiar x mniejszy niz 30");
        }

        if (parcel.getyLength() < 30) {
            throw new IllegalStateException("Rozmiar y mniejszy niz 30");
        }

        if (parcel.getzLength() < 30) {
            throw new IllegalStateException("Rozmiar z mniejszy niz 30");
        }

        // czy waga nie przekracza 30.0 dla isExpress=false lub 15.0 dla isExpress=true.
        if (parcel.isExpress() && parcel.getWeight() > 15) {
            throw new IllegalStateException("isExpress true i waga wieksza niz 15");
        }

        if (!parcel.isExpress() && parcel.getWeight() > 30) {
            throw new IllegalStateException("isExpress false i waga wieksza niz 30");
        }
    }
}
