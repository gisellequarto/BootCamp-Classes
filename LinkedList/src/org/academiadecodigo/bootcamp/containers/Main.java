package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

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

        for (String str : stringList) {
            System.out.println(str);
        }

        LinkedList<Integer> numList = new LinkedList<>();

        numList.add(4);
        numList.add(0);
        numList.add(2);
        numList.add(6);
        numList.add(3);
        numList.add(9);
        numList.add(5);

       for (Integer n : numList){
           System.out.println(n);
       }


        System.out.println("---------- Teste Personalizado ---------");
        Iterator<Integer> it = numList.iterator();
       while (it.hasNext()) {
           System.out.println(it.next());
       }

        // numList.add("Hello");


    }

}