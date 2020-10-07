package org.academiadecodigo.com.ArabianNights;

public class MagicLamp {

    private int numberOfGenies;
    private int numberOfResets;
    private int numberOfReleasedGenies;

    public MagicLamp (int numberOfGenies) {
        this.numberOfGenies = numberOfGenies;
    }


    public Genie rubbed (int wishes) {
     numberOfReleasedGenies++;
        if (numberOfReleasedGenies > numberOfGenies) {
            return new DemonGenie(wishes);
        }

        if (numberOfReleasedGenies % 2 == 0) {
            return new FriendlyGenie(wishes);
        }
        return new GrumpyGenie(wishes);
        }


    public void resetLamp(Genie demon){
        if (demon instanceof DemonGenie) {
            DemonGenie recyclableDemon = (DemonGenie) demon;

            if (recyclableDemon.getUsedDemonPower()) {
                numberOfReleasedGenies = 0;
                numberOfResets++;
                recyclableDemon.setUsedDemonPower();
            }
        }
    }


    public boolean compare(MagicLamp other) {

        boolean sameGenies = numberOfGenies == other.numberOfGenies;
        boolean sameRemainGenies = (numberOfGenies - numberOfReleasedGenies) == (other.numberOfGenies - other.numberOfReleasedGenies);
        boolean sameResets = numberOfResets == other.numberOfResets;

        return  (sameGenies && sameRemainGenies && sameResets);
    }


}
