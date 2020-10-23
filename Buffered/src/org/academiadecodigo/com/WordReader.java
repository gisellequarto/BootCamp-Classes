package org.academiadecodigo.com;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class WordReader implements Iterable<String> {

    BufferIterator bufferIterator;

    public WordReader(String path) {
        try {
            bufferIterator = new BufferIterator(path);
        } catch (FileNotFoundException e) {
            System.err.println("No such file was found");
        }
    }

    @Override
    public Iterator iterator() {
        return bufferIterator;
    }

    public void close() {
        try {
            bufferIterator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class BufferIterator implements Iterator<String> {

        private FileReader reader;
        private BufferedReader bReader;
        private List<String> list;

        public BufferIterator(String path) throws FileNotFoundException {
            reader = new FileReader(path);
            bReader = new BufferedReader(reader);
            list = new LinkedList<>();
        }

        public boolean readLine() {
            try {
                String line = "";
                if ((line = bReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (String s : words) {
                        list.add(s);
                    }
                    return true;
                } else {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }


        @Override
        public boolean hasNext() {
            if (list.isEmpty()) {
                if (!readLine()) {
                    return false;
                }
            }
            return true;
        }


        @Override
        public String next() {
            if (hasNext()) {
                return list.remove(0);
            }
            throw new NoSuchElementException();
        }


        public void close() throws IOException {

            bReader.close();
        }


    }
}
