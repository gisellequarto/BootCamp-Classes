package org.academiadecodigo.com;

public class Main {

    public static void main(String[] args) {

        Range range = new Range(5, 10);

        System.out.println("Go UP:");
        for (Integer i : range) {
            System.out.println(i);
        }

        range.changeDirection(true);

        System.out.println("\nGo DOWN:");
        for (Integer i : range) {
            System.out.println(i);
        }


    }


}
