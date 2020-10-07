package org.academiadecodigo.com;

public class SniperRifle {

    private int bulletDamage;

    public SniperRifle(){
        bulletDamage = 10;
    }

    public void shoot(Enemy enemy){
        int fatalShot = ((int) (Math.random() * 10));
        if (fatalShot <= 2) {
            enemy.kill();
            System.out.println("FATAL SHOT!");
            return;
        }
        System.out.println("BANG! DIE " + enemy.getClass().getSimpleName() + "!");
        enemy.hit(bulletDamage);
    }




}
