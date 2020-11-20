package org.academiadecodigo.lambdas;

import java.nio.charset.IllegalCharsetNameException;
import java.util.List;

public class Main {

    public static int counter = 1;

    public static void main(String[] args) {

        Machine<String> stringMachine = new Machine();

        stringMachine.execute("hello", "world", (x, y) -> System.out.println(x.concat(" " + y)));

        stringMachine.execute("oi", x -> System.out.println(x.repeat(10)));

        Machine<Integer> integerMachine = new Machine<>();

        integerMachine.execute(5, x -> System.out.println(x * 71));

        integerMachine.execute(9, 8, (x, y) -> System.out.println( (x + y) * 4 / 2 * 10));

        Oven o1 = new Oven();
        Oven o2 = new Oven();
        Oven o3 = new Oven();


        Machine<Oven> ovenMachine = new Machine<>();

        MonoOperation<Oven> ovenLambda =  x-> {
            x.setInitialTemperature(30);
            System.out.println(x.toString(counter));
            counter++;
        };

        ovenMachine.execute(o1, ovenLambda);
        ovenMachine.execute(o2, ovenLambda);
        ovenMachine.execute(o3, ovenLambda);


    }
}
