package org.academiadecodigo.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class RangeIterator implements Iterator<Integer>{

    private int actual;
    private int last;

    public RangeIterator(int first, int last) {
        actual = first;
        this.last = last;
    }

    @Override
    public boolean hasNext() {
        if (actual <= last) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return actual++;
        }
        return null;
    }

}
