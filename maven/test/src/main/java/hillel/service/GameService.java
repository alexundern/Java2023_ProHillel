package hillel.service;

import hillel.innitial.Computer;
import hillel.innitial.GameResult;
import hillel.innitial.Move;
import hillel.innitial.Player;


public class GameService {
    private final Computer computer;
    private int totalGames;
    private int playerWins;
    private int computerWins;
    private int draws;
    private GameService gameService;

    public GameService getGameService() {
        return this.gameService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    private static final String[][] RESULT_MATRIX = {
            {"DRAW", "PLAYER", "COMPUTER"},
            {"COMPUTER", "DRAW", "PLAYER"},
            {"PLAYER", "COMPUTER", "DRAW"}
    };

    public GameService(String computerName) {
        this.computer = new Computer(computerName);
        this.totalGames = 0;
        this.playerWins = 0;
        this.computerWins = 0;
        this.draws = 0;
    }

    public GameResult play(Move playerMove) {
        Move computerMove = computer.makeMove();
        Player result = determineResult(playerMove, computerMove);
        updateStatistics(result);
        return new GameResult(playerMove, computerMove, result);
    }

    public void printStatistics() {
        System.out.println("_________________________________");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Player wins: " + playerWins);
        System.out.println("Computer wins: " + computerWins);
        System.out.println("Draws: " + draws);
    }

    public Player determineResult(Move playerMove, Move computerMove) {
        int playerIndex = getIndex(playerMove);
        int computerIndex = getIndex(computerMove);
        return Player.valueOf(RESULT_MATRIX[computerIndex][playerIndex]);
    }

    public int getIndex(Move move) {
        return switch (move) {
            case ROCK -> 0;
            case PAPER -> 1;
            case SCISSORS -> 2;
            default -> throw new IllegalArgumentException("Invalid move: " + move);
        };
    }

    private void updateStatistics(Player result) {
        totalGames++;
        switch (result) {
            case PLAYER -> playerWins++;
            case COMPUTER -> computerWins++;
            case DRAW -> draws++;
        }
    }

    public void setComputer(Computer computer) {
    }
}
