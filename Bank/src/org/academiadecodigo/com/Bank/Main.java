package org.academiadecodigo.com.Bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(1000.0);

        Person p1 = new Person("Giselle", bank, new Wallet(50.0));

        Person p2 = new Person("Catarina", bank, new Wallet(80.0));

        p1.showSavings();
        p2.showSavings();

        p1.withdraw(150.0);
        p2.withdraw(380.0);

        p1.showSavings();
        p2.showSavings();

        p1.deposit(30.0);
        p2.deposit(20.0);

        p1.showSavings();
        p2.showSavings();

        p1.spend(50, Product.BEER);
        p2.spend(30, Product.JUICE);

        p1.showSavings();
        p2.showSavings();




    }
}
