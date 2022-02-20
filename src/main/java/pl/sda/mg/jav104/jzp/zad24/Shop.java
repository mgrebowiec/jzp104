package pl.sda.mg.jav104.jzp.zad24;

import pl.sda.mg.jav104.jzp.zad24.exception.checked.BasketFullException;

public class Shop {
    public static void main(String[] args) {
        Basket basket = new Basket(3);
        basket.addToBasket("1")
                .addToBasket("2")
                .addToBasket("3")
                .removeFromBasket()
                .addToBasket("4")
                .removeFromBasket()
                .removeFromBasket()
                .removeFromBasket();

        try {
            basket.addToBasket2("10")
            .addToBasket2("11")
            .addToBasket2("12")
            .addToBasket2("13");
        } catch (BasketFullException e) {
            System.out.println(e.getMessage());
        }

    }
}
