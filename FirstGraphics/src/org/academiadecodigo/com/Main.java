package org.academiadecodigo.com;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        
        Picture picture = new Picture(10, 10, "assets/city.jpg");
        picture.draw();

        int counter = 0;

        while (counter < 50) {
            picture.translate(0, 10);
            Thread.sleep(1500L);
            counter++;
        }





    }
}
