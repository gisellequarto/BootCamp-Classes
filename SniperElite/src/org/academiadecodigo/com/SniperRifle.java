package org.academiadecodigo.com;

public class SniperRifle {

    private int bulletDamage;

    public SniperRifle(){
        bulletDamage = 10;
    }

    public void shoot(Destroyable destroyable){
        int fatalShot = ((int) (Math.random() * 10));
        if (fatalShot <= 2) {
            System.out.println("MISSED SHOT!");
            return;
        }
        if (destroyable instanceof Barrel) {
            destroyable.hit(bulletDamage);
            System.out.println("BANG! Fucking " + ((Barrel) destroyable).getMessage());
            return;
        }
        System.out.println("BANG! DIE " + destroyable.getClass().getSimpleName() + "!");
        destroyable.hit(bulletDamage);
    }




}
