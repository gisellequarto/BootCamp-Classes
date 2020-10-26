package org.academiadecodigo.com;

import java.io.*;
import java.util.*;

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
        private Queue<String> list;

        public BufferIterator(String path) throws FileNotFoundException {
            reader = new FileReader(path);
            bReader = new BufferedReader(reader);
            list = new LinkedList<>();
        }

        public boolean readWords() {
            try {
                String line = "";
                if ((line = bReader.readLine()) != null) {
                    String[] words = line.split(" ");
                    Collections.addAll(list, words);
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }


        @Override
        public boolean hasNext() {
            if (list.isEmpty()) {
                return readWords();
            }

            return true;
        }


        @Override
        public String next() {
            if (hasNext()) {
                return list.poll();
            }
            throw new NoSuchElementException();
        }


        public void close() throws IOException {

            bReader.close();
        }


    }
}
