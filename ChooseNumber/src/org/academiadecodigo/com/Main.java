package org.academiadecodigo.com;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("Francisco");
        Player player2 = new Player("Sid");
        Player player3 = new Player("Vando");

        Player[] players = {player1, player2, player3};

        Game game = new Game();
        game.start(players);



    }
}
