package org.academia.com;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Histogram hist = new Histogram();

        hist.add("hello hello crazy potatos potatos hello crazy hi");



        Iterator it = hist.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(hist.getValue("potatos"));
        System.out.println(hist.getValue("hello"));
        System.out.println(hist.getValue("hi"));
        System.out.println(hist.getValue("crazy"));


    }
}
