package org.academiadecodigo.com.Bank;

public class Bank {

    private double balance;

    public Bank (double savings) {
        balance = savings;
    }

    public void showAccountStatement() {
        String bankShow = ((Double.toString(balance).replace(".", ",")));
        System.out.println("Your account balance is " + bankShow + " €.");
    }


    public double decrease (double amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else {
            System.out.println("There is not enough money.");
            showAccountStatement();
            return 0.0;
        }
    }

    public void increase (double amount) {
        balance += amount;
    }

}
