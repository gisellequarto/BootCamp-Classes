package org.academiadecodigo.bootcamp.containers;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("Catarina");
        stringList.add("Gustavo");
        stringList.add("Bárbara");
        stringList.add("Simão");
        stringList.add("Antônio");
        stringList.add("Beatriz");

        //stringList.add(4);

        System.out.println(stringList.get(3));

        LinkedList<Integer> numList = new LinkedList<>();

        numList.add(4);
        numList.add(0);
        numList.add(2);
        numList.add(6);
        numList.add(3);
        numList.add(9);
        numList.add(5);

        System.out.println(numList.get(5));
        System.out.println(numList.indexOf(6));

        // numList.add("Hello");


    }

}