package org.academiadecodigo.com;

import java.util.HashMap;
import java.util.Iterator;

public class Histogram extends HashMap<String, Integer> implements Iterable {

    public void add(String str) {
        String[] temp = str.split(" ");
        for (String s : temp) {
            if (this.containsKey(s)) {
                this.put(s, this.get(s) + 1);
                continue;
            }
            this.put(s, 1);
        }
    }

    @Override
    public Iterator iterator() {
        return this.keySet().iterator();
    }
}
