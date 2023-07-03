package com.hillel.innitial;

public class GameResult {
    private final Move playerMove;
    private final Move computerMove;
    private final Player result;

    public GameResult(Move playerMove, Move computerMove, Player result) {
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public Player getResult() {
        return result;
    }
}
