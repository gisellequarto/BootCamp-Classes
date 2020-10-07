package org.academiadecodigo.com;

public class NumberRandom {

    public static int chooseANumber(int max) {
        int chosen = (int) (Math.random() * max + 1);
        return chosen;
