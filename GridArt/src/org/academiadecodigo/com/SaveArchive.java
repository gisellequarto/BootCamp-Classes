package org.academiadecodigo.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveArchive {

    private FileWriter writer;
    private BufferedWriter bWriter;
    private List<Integer[]> statusList;
    private String text;

    public SaveArchive(List<Integer[]> statusList, String filePath) {
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
        for (Integer[] i : statusList) {
            text += i[0] + " ";
            text += i[1] + "\n";
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
