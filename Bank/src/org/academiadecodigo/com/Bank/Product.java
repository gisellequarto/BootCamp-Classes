package org.academiadecodigo.com.Bank;

public enum Product {
    BEER(0.80),
    WINE(2.50),
    PORT_WINE(3.00),
    WATER(1.00),
    JUICE(1.80);

    private double price;

    Product (double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

}
