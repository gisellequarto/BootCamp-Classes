package org.academiadecodigo.com;

import java.util.*;
import java.util.function.Consumer;

public class Range implements Iterable<Integer> {

    private Integer first;
    private Integer last;
    private boolean directionDown;

    public Range(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public void changeDirection(boolean change) {
        directionDown = change;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (directionDown) {
            return new Iterator() {
                private int actual = last;
                private int min = first;

                @Override
                public boolean hasNext() {
                    return actual >= min;
                }

                @Override
                public Object next() {
                    if (hasNext()) {
                        return actual--;
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        return new Iterator() {
            private int actual = first;
            private int max = last;

            @Override
            public boolean hasNext() {
                return actual <= max;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    return actual++;
                }
                throw new NoSuchElementException();
            }
        };
    }


}
