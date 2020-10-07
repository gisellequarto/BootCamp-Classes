package org.academiadecodigo.com.ArabianNights;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        MagicLamp oldLamp = new MagicLamp(3);

        Genie g1 = oldLamp.rubbed(2);
        System.out.println("\nGenie grumpy:");
        g1.grantWish();
        g1.grantWish();

        Genie g2 = oldLamp.rubbed(2);
        System.out.println("\nGenie friendly:");
        g2.grantWish();
        g2.grantWish();
        g2.grantWish();


        Genie g3 = oldLamp.rubbed(1);
        System.out.println("\nGenie grumpy:");
        g3.grantWish();
        g3.grantWish();
        g3.grantWish();

        Genie g4 = oldLamp.rubbed(1);
        System.out.println("\nGenie demon:");
        g4.grantWish();
        g4.grantWish();


        System.out.println("\nGenie demon:(after recycle)");
        oldLamp.resetLamp(g4);
        g4.grantWish();

        Genie gTestReset = oldLamp.rubbed(2);
        System.out.println("\nReset Test: Another Grumpy");
        gTestReset.grantWish();
        gTestReset.grantWish();
        gTestReset.grantWish();

        MagicLamp ultraModernLamp = new MagicLamp(2);
        Genie g5 = ultraModernLamp.rubbed(1);

        System.out.println("\nCompare1: " + oldLamp.compare(ultraModernLamp));

        MagicLamp fashionLamp = new MagicLamp(2);


        System.out.println("\nCompare2: " + fashionLamp.compare(ultraModernLamp));

        fashionLamp.rubbed(5);

        System.out.println("\nCompare3: " + fashionLamp.compare(ultraModernLamp));
    }
}
