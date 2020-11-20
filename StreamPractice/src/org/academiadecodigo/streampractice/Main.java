package org.academiadecodigo.streampractice;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";


        System.out.println(outGarbage(message));


    }

    public static String outGarbage(String str) {
        return Stream.of(str.split(" "))
                .filter(s -> !s.equals("garbage"))
                .map(String::toUpperCase)
                .reduce("", (s, w) -> s + " " + w);
    }

}
