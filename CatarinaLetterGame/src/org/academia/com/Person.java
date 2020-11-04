package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Text;

public enum Person {
/*
    BEBETO,
    BIA,*/
    CARLA("M", "assets/Carla.jpeg"),
   // CATARINA
    DANIEL("D", "assets/Daniel.jpeg"),
    //GISELLE,
    JOAO("J", "assets/Joao.jpeg"),
    //LEONARDO,
    //MAITE,*/
    MAY("M", "assets/May.jpeg"),
   /* MEL,
    NAIARA,
    RICARDO,
    RODRIGO,
    ROGERIO*/
    VANIA("V", "assets/Vania.jpeg");

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
