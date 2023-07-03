package com.hillel.innitial;

public enum Move {
    ROCK("R"),
    PAPER("P"),
    SCISSORS("S");

    private final String abbreviation;

    Move(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static Move fromAbbreviation(String abbreviation) {
        for (Move move : Move.values()) {
            if (move.abbreviation.equalsIgnoreCase(abbreviation)) {
                return move;
            }
        }
        return null;
    }

    public boolean defeats(Move otherMove) {
        return (this == SCISSORS && otherMove == PAPER) ||
                (this == ROCK && otherMove == SCISSORS) ||
                (this == PAPER && otherMove == ROCK);
    }

}
