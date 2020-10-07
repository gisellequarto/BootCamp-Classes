package org.academiadecodigo.com.BattleGame;

public class Arena {

    Player playerOne;
    Player playerTwo;

    public Arena (Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }


    public void battle() {
        int roundCounter = 1;

        while (this.isSomeoneDead() == false) {
            System.out.println(">>> ROUND " + roundCounter + " <<<");
            System.out.println(playerOne.getName() + " turn:");
            playerOne.attack(playerTwo);
            if (this.isSomeoneDead() == false) {

                System.out.println(playerTwo.getName() + " turn:");
                playerTwo.attack(playerOne);
                System.out.println("");
                roundCounter++;
            }
        }

        System.out.println(this.theWinner().getName() + " IS THE WINNER!!!!");



    }

    private boolean isSomeoneDead() {
        return playerOne.lost() || playerTwo.lost();
    }

    private Player theWinner () {
        if (playerOne.lost()){
            return playerTwo;
        }
        return playerOne;
    }

}
