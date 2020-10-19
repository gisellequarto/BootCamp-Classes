package org.academiadecodigo.com;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Histogram hist = new Histogram();

        hist.add("hello hello crazy potatos hi hi hi");


        Iterator it = hist.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(hist.get("crazy"));
        System.out.println(hist.get("hi"));
        System.out.println(hist.get("potatos"));
        System.out.println(hist.get("hello"));




    }
}
