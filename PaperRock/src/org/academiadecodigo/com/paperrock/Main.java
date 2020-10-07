package org.academiadecodigo.com.paperrock;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Catarina");
        Player p2 = new Player("Manoela");

        Game game = new Game(p1, p2);
        game.start();







    }

}
