package org.academiadecodigo.lambdas;

public class Machine<T> {

    public void execute (T typeX, T typeY,  BiOperation<T> biOperation) {
        biOperation.execute(typeX, typeY);
    }

    public void execute(T type, MonoOperation<T> monoOperation) {
        monoOperation.execute(type);
    }


}
