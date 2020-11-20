package org.academia.com;

import org.academiadecodigo.simplegraphics.graphics.Text;

public enum Person {

    BEBETO ("B", "assets/Bebeto.jpeg"),
    //BIA,
    CARLA("C", "assets/Carla.jpeg"),
    CATARINA("C", "assets/Catarina.jpeg"),
    DANIEL("D", "assets/Daniel.jpeg"),
    GISELLE ("G", "assets/Giselle.jpeg"),
    JOAO("j", "assets/Joao.jpeg"),
    LEONARDO("L", "assets/Leo.png"),
    MAITE("M", "assets/Maite.png"),
    MAY("M", "assets/May.jpeg"),
    MEL ("M", "assets/Mel.png"),
    NAIARA ("N", "assets/Naiara.png"),
    RICARDO ("R", "assets/Ricardo.png"),
    RODRIGO ("R", "assets/Rodrigo.jpeg"),
    ROGERIO ("R", "assets/Rogerio.png"),
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
