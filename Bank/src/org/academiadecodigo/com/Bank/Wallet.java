package org.academiadecodigo.com.Bank;

public class Wallet {

    private double walletAmount;

    public Wallet(double savings) {
        walletAmount = savings;
    }

    public void showAmount() {
        String walletShow = ((Double.toString(walletAmount).replace(".", ",")));
        System.out.println("Your wallet has " + walletShow + " €.\n");
    }


    public double decrease (double amount) {
        if(walletAmount >= amount) {
            walletAmount -= amount;
            return amount;
        } else {
            System.out.println("There is not enough money.");
            showAmount();
            return 0.0;
        }
    }

    public void increase (double amount) {
        walletAmount += amount;
    }


}
