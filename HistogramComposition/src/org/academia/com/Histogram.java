package org.academia.com;

import java.util.*;

public class Histogram implements Iterable {

    private Map<String, Integer> histogram;

    public Histogram() {
        histogram = new HashMap<String, Integer>();
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

}
