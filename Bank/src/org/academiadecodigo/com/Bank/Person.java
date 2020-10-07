package org.academiadecodigo.com.Bank;

public class Person {

    private String name;
    private Bank bank;
    private Wallet wallet;


    public Person(String name, Bank bank, Wallet wallet) {
        this.name = name;
        this.bank = bank;
        this.wallet = wallet;
    }

    public void withdraw (double amount) {
        double money = bank.decrease(amount);
        wallet.increase(money);
    }

    public void deposit (double amount) {
        double money = wallet.decrease(amount);
        bank.increase(money);
    }

    public void spend (int quantity, Product product) {
        double amount = (product.getPrice() * quantity);
        wallet.decrease(amount);
    }

    public void showSavings() {
        System.out.println(name + ", your savings:");
        bank.showAccountStatement();
        wallet.showAmount();
    }

}
