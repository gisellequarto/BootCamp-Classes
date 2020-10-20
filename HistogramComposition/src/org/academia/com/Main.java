package org.academia.com;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Histogram histogram = new Histogram();

        histogram.add("hello hello crazy potatos potatos hello crazy hi");



        Iterator it = histogram.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(histogram.getValue("potatos"));
        System.out.println(histogram.getValue("hello"));
        System.out.println(histogram.getValue("hi"));
        System.out.println(histogram.getValue("crazy"));


    }
}
