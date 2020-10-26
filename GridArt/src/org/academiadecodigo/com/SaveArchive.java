package org.academiadecodigo.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveArchive {

    private FileWriter writer;
    private BufferedWriter bWriter;
    private List<Boolean> statusList;
    private String text;

    public SaveArchive(List<Boolean> statusList, String filePath) {
        this.statusList = statusList;
        text = "";
        try {
            writer = new FileWriter(filePath);
            bWriter = new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void statusToText() {
        for (Boolean b : statusList) {
            text += (b.toString()) + "\n";
        }
    }

    public void save() {
        try {
            statusToText();
            bWriter.write(text);
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
