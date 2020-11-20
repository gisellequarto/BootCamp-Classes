package org.academiadecodigo.fileanalyzer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class FileManipulator {

    private Stream<String> reader(String path) {
        try {
            return Files.lines(Paths.get(path))
                    .map(line -> line.split(" "))
                    .flatMap(Stream::of);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void countWords(String path) {
        System.out.println(reader(path).count());
    }

    public void findFirstLonger(String path, int n) {
        Optional<String> maybeWord = reader(path).filter(str -> str.length() > n).findFirst();
        maybeWord.ifPresent(System.out::println);
    }


    public void findLongestWords(String path, int n) {

        Comparator<String> lenghtComparator = Comparator.comparingInt(String::length).reversed();

        Set<String> list = new HashSet<>();

        reader(path).filter(list::add).sorted(lenghtComparator).limit(n).map(s -> s + " ").forEach(System.out::print);

    }

    public void findEqualWords(String path, String otherFilePath) {

        Stream<String> stream1 = reader(path);
        Stream<String> stream2 = reader(otherFilePath);

        Set<String> list = new HashSet<>();

        stream1.filter(list::add).forEach(list::add);
        stream2.filter(s -> !list.add(s)).map(s -> s + " ").forEach(System.out::print);

    }


}
