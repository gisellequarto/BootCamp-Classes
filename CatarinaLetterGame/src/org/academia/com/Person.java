package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Text;

public enum Person {
/*
    BEBETO,
    BIA,
    CATARINA,
    DANIEL,
    GISELLE,
    JOAO,
    LEONARDO,
    MAITE,*/
    MAY("M", "assets/May.jpeg");
   /* MEL,
    NAIARA,
    RICARDO,
    RODRIGO,
    ROGERIO;
*/
    private String letter;
    private String picturePath;

    Person(String letter, String picturePath) {
        this.letter = letter;
        this.picturePath = picturePath;
    }

    public String getLetter() {
        return letter;
    }

    public String getPicturePath() {
        return picturePath;
    }
}
