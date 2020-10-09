package org.academiadecodigo.com;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniper;
    private int shotsFired;

    public Game(int numberOfObjects) {
        createObjects(numberOfObjects);
        sniper = new SniperRifle();
    }


    public void start() {
        for (GameObject g : gameObjects) {
            if (g instanceof Tree) {
                g.getMessage();
                continue;
            }
            if (g instanceof Destroyable) {
                Destroyable destroyable = (Destroyable) g;
                while (!destroyable.isDestroyed()) {
                    sniper.shoot(destroyable);
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

            if (randomObjectsTypes < 1) {
                gameObjects[i] = new Tree();
            } else if (randomObjectsTypes < 4) {
                gameObjects[i] = new SoldierEnemy();
            } else if (randomObjectsTypes < 7) {
                gameObjects[i] = new ArmouredEnemy();
            } else {
                gameObjects[i] = new Barrel();
            }
        }

        for (GameObject g : gameObjects) {
            System.out.print(g.getClass().getSimpleName() + " ");
        }
        System.out.println(" ");

        return gameObjects;
    }

}
