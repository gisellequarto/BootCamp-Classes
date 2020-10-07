package org.academiadecodigo.com.paperrock;

public class Game {

    private Player p1;
    private Player p2;
    int maxVictories = 5;

    public Game (Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }


    public void start(){

        while (!endGame()){
            int round = compareHands(p1.showHand(), p2.showHand());

            while (round == 3) {
                round = compareHands(p1.showHand(), p2.showHand());
            }

            if (round == 1) {
                p1.addVictory();
            } else if (round == 2) {
                p2.addVictory();
            }

        }

    }

    public int compareHands (HandType h1, HandType h2) {
        if (h1 == h2) {
            System.out.println(">>>TRY AGAIN<<<\n\n");
            return 3;
        } else if ((h1 == HandType.PAPER && (h2 == HandType.ROCK || h2 == HandType.SPOCK)) || (h1 == HandType.ROCK && (h2 == HandType.SCISSORS || h2 == HandType.LIZARD)) ||
                (h1 == HandType.SCISSORS && (h2 == HandType.PAPER || h2 == HandType.LIZARD)) || (h1 == HandType.SPOCK && (h2 == HandType.ROCK || h2 == HandType.SPOCK)) ||
                (h1 == HandType.LIZARD && (h2 == HandType.SPOCK || h2 == HandType.PAPER))) {
            return 1;
        } else {
            return 2;
        }
    }


    public boolean endGame() {
        if(p1.getVictory() >= maxVictories) {
            System.out.println(p1.getName() + " is the WINNER!!!");
            return true;
        } else if (p2.getVictory() >= maxVictories) {
            System.out.println(p2.getName() + " is the WINNER!!!");
            return true;
        } else {
            return false;
        }
    }




}
