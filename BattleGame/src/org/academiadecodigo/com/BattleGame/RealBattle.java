package org.academiadecodigo.com.BattleGame;

public class RealBattle {

    public static void main(String[] args) {

        Fighter[] fightersGi = {new Troll("Maumau"),
                                new Troll("Daniel"),
                                new Gladiator("Thor"),
                                new Wizard("Merlin"),
                                new Wizard("Joana")};

        Fighter[] fightersRod = {new Troll("Aline Priscilla"),
                                 new Wizard("Marcelo"),
                                 new Gladiator("Spider"),
                                 new Wizard("Bernardo"),
                                 new Troll("Bia")};

        Player p1 = new Player("Giselle", fightersGi);
        Player p2 = new Player("Rodrigo", fightersRod);

        Arena arena = new Arena(p1, p2);
        arena.battle();


    }



}
