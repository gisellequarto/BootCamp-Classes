package org.academiadecodigo.fileanalyzer;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        String file = "test.txt";
        String file2 = "test2.txt";

        FileManipulator fileManipulator = new FileManipulator();

        System.out.print("Count words: ");
        fileManipulator.countWords(file);

        System.out.print("First longer: ");
        fileManipulator.findFirstLonger(file, 6);

        System.out.print("Find all longest: ");
        fileManipulator.findLongestWords(file, 2);

        System.out.print("\nCommon words: ");
        fileManipulator.findEqualWords(file, file2);


    }


}
