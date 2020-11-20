package org.academiadecodigo.sandbox;

public class CodeWarsSandBox {

    public static void main(String[] args) {

        int[] test = {5, -3, 4};

        System.out.println(squareSum(test));




    }


    public static int squareSum(int[] n) {
        int result = 0;
        for (int num : n) {
            result += (Math.pow(num, 2));
        }
        return result;
    }
}
