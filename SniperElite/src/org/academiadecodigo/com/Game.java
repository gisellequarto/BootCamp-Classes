package org.academiadecodigo.com;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniper;
    private int shotsFired;

     public Game (int numberOfObjects) {
         createObjects(numberOfObjects);
         sniper = new SniperRifle();
     }


     public void start() {
       for(GameObject g : gameObjects) {
           if (g instanceof Tree){
               g.getMessage();
               continue;
           }
           if (g instanceof Enemy) {
                Enemy enemy = (Enemy) g;
               while(!enemy.isDead()) {
                    sniper.shoot(enemy);
                    shotsFired++;
           }
           }
       }

         System.out.println("\nShots: " + shotsFired);


     }


    public GameObject[] createObjects(int numberOfObjects) {
        gameObjects = new GameObject[numberOfObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            int randomObjectsTypes = ((int) (Math.random() * 10));
            if (randomObjectsTypes < 2) {
                gameObjects[i] = new Tree();
            } else if (randomObjectsTypes >= 2 && randomObjectsTypes < 6) {
                gameObjects[i] = new SoldierEnemy();
            } else if (randomObjectsTypes >= 6) {
                gameObjects[i] = new ArmouredEnemy();
            }
        }

        for(GameObject g : gameObjects) {
            System.out.print(g.getClass().getSimpleName() + " ");
        }
        System.out.println(" ");

        return gameObjects;
    }

}
