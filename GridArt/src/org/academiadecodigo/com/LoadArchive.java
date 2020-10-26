package org.academiadecodigo.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LoadArchive {

    private FileReader fileReader;
    private BufferedReader bReader;
    private List<Integer[]> savedStatus;

    public LoadArchive(String filePath) {
        try {
            savedStatus = new LinkedList<>();
            fileReader = new FileReader(filePath);
            bReader = new BufferedReader(fileReader);
            textToStatus();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void textToStatus () throws IOException {
        String line = "";
        while ((line = bReader.readLine()) != null) {
            String[] temp = line.split(" ");
            Integer[] status = {Integer.valueOf(temp[0]), Integer.valueOf(temp[1])};
            savedStatus.add(status);
        }
    }

    public List<Integer[]> getSavedStatus() {
        return savedStatus;
    }






}
