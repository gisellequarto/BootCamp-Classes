package org.academiadecodigo.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Range implements Iterable<Integer> {

    LinkedList<Integer> list;
    Integer first;
    Integer last;

    public Range(int first, int last) {
        this.first = first;
        this.last = last;
        list = new LinkedList<>();

    }


    private void add (int first) {
        for (int i = 0; i <= last - first; i++) {
            list.add(first);
            first++;
        }
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer action) {
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

}
