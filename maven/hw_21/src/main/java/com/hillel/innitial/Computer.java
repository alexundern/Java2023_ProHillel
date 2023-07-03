package com.hillel.innitial;

import java.util.Random;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public Move makeMove() {
        Random random = new Random();
        int index = random.nextInt(Move.values().length);
        return Move.values()[index];
    }

    public String getName() {
        return name;
    }
}
