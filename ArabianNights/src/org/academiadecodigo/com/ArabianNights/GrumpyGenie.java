package org.academiadecodigo.com.ArabianNights;

public class GrumpyGenie extends Genie{

    private boolean wishGranted;

    public GrumpyGenie(int wishes){
        super(wishes);
    }

    @Override
    public void grantWish() {
       if (wishGranted) {
           System.out.println("No more wishes!  I have more things to do!");
           return;
       }
       super.grantWish();
       wishGranted = true;
    }


}
