package org.academiadecodigo.com;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueWords implements Iterable<String> {

    private Set<String> words;

    public UniqueWords() {
        words = new HashSet<>();
    }

    public void add(String str) {
        String[] temp = str.split(" ");
        for (String s : temp) {
            words.add(s);
        }
    }
    
    @Override
    public Iterator<String> iterator() {
        return words.iterator();
    }
}
