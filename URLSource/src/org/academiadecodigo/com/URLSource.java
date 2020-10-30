package org.academiadecodigo.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLSource {

    private static URL url;
    private static byte[] buffer = new byte[2048];
    private static InputStreamReader in;
    private static BufferedReader bReader;

    public static void createURL(String spec) {
        try {
            url = new URL(spec);
        } catch (MalformedURLException e) {
            System.out.println("Create URL bug " + e.getMessage());
        }
    }

    public static void getContents() {
        try {
            URLConnection urlConnection = url.openConnection();
            in = new InputStreamReader(urlConnection.getInputStream());
        } catch (IOException e) {
            System.out.println("Contents bug " + e.getMessage());
        }
    }

    public static void readContents() throws IOException {
        bReader = new BufferedReader(in);
        String line = "";
        String result = "";
        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }
        System.out.println(result);
    }


    public static void main(String[] args) {

        String web = "https://www.google.pt";

        createURL(web);
        getContents();
        try {
            readContents();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
