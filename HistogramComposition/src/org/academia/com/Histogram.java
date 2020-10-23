package org.academia.com;

import java.util.*;

public class Histogram implements Iterable {

    private Map<String, Integer> histogram;

    public Histogram() {
        histogram = new TreeMap<>();
    }

    public void add(String str) {
        String[] temp = str.split(" ");
        for (String s : temp) {
            if (histogram.containsKey(s)) {
                histogram.put(s, histogram.get(s) + 1);
                continue;
            }
            histogram.put(s, 1);
        }
    }

    public Integer getValue(String s) {
        return histogram.get(s);
    }

    @Override
    public Iterator iterator() {
        return histogram.keySet().iterator();
    }

<<<<<<< HEAD
=======

>>>>>>> 611e565511e000b4ac9a039b06f12f1ee9b28479
}
