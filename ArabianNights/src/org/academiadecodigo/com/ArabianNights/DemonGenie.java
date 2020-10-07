package org.academiadecodigo.com.ArabianNights;

public class DemonGenie extends Genie{

    private boolean usedDemonPower;

    public DemonGenie(int wishes){
        super(wishes);
    }

    @Override
    public void grantWish() {
        if (usedDemonPower == false) {
            System.out.println("Your wish is a order! TCHARAM!");
            return;
        }
        System.out.println("I lost my power, my friend!");
    }

    public boolean getUsedDemonPower() {
        return usedDemonPower;
    }

    public void setUsedDemonPower() {
        usedDemonPower = true ;
    }




}
