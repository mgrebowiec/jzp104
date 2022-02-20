package pl.sda.mg.jav104.jzp.zad24.exception.unchecked;

public class BasketEmptyException extends RuntimeException {
    public BasketEmptyException(String message) {
        super(message);
    }
}
