package com.practive.overriding;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Parent1 parent1 = new Parent1();
        //[Parent1.method1] - test1
        //[Parent1.method2] - test2
        parent1.method1();

        Parent1 parent11 = new Child1();

        //[Parent1.method1] - test1
        //[Child1.method2] - test2
        parent11.method1();
    }

}
