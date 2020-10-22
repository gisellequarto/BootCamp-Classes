package org.academiadecodigo.com;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        WordReader wordReader = new WordReader("Lyrics");

        Iterator it = wordReader.iterator();
        while(it.hasNext()) {
            System.out.println(it.next() + " * ");
        }




    }
}
