package org.academiadecodigo.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyManager {


    public void copyFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(path + "(copy)");

        byte[] buffer = new byte[1024];
        int n = inputStream.read(buffer);

        while (n != -1) {
            outputStream.write(buffer, 0, n);
            n = inputStream.read(buffer);
        }

        inputStream.close();
        outputStream.close();
    }


}
