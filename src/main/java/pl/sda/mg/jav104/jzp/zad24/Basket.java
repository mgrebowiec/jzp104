package pl.sda.mg.jav104.jzp.zad24;

import pl.sda.mg.jav104.jzp.zad24.exception.unchecked.BasketEmptyException;
import pl.sda.mg.jav104.jzp.zad24.exception.unchecked.BasketFullException;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final int basketSize;
    private List<String> products = new ArrayList<>();

    public Basket(int basketSize) {
        this.basketSize = basketSize;
    }

    public Basket addToBasket(String product) {
        if (products.size() >= basketSize) {
            throw new BasketFullException("Koszyk jest pelny! Nie mozna dodac produktu " + product);
        }

        products.add(product);
        return this;
    }

    public Basket removeFromBasket() {
        if (products.size() < 1) {
            throw new BasketEmptyException("Koszyk jest pusty, nie mozemy nic usunac!");
        }

        products.remove(products.size() - 1);
        return this;
    }

    public Basket addToBasket2(String product) throws pl.sda.mg.jav104.jzp.zad24.exception.checked.BasketFullException {
        if (products.size() >= basketSize) {
            throw new pl.sda.mg.jav104.jzp.zad24.exception.checked.BasketFullException("Koszyk jest pelny! Nie mozna dodac produktu " + product);
        }

        products.add(product);
        return this;
    }

    public Basket removeFromBasket2() throws pl.sda.mg.jav104.jzp.zad24.exception.checked.BasketEmptyException {
        if (products.size() < 1) {
            throw new pl.sda.mg.jav104.jzp.zad24.exception.checked.BasketEmptyException("Koszyk jest pusty, nie mozemy nic usunac!");
        }

        products.remove(products.size() - 1);
        return this;
    }
}
