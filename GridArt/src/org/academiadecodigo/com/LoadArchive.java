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
    private List<Boolean> savedStatus;

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
            if(line.contains("true")){
                savedStatus.add(true);
                continue;
            }
            savedStatus.add(false);
        }
    }

    public List<Boolean> getSavedStatus() {
        return savedStatus;
    }
}
