package com.hillel;

import com.hillel.innitial.GameResult;
import com.hillel.innitial.Move;
import com.hillel.innitial.Player;
import com.hillel.service.GameService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors Game!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter the number of games to play: ");
        int numberOfGames = scanner.nextInt();

        scanner.nextLine();

        GameService gameService = new GameService("Computer");

        Map<String, Move> validMoves = new HashMap<>();
        validMoves.put("R", Move.ROCK);
        validMoves.put("P", Move.PAPER);
        validMoves.put("S", Move.SCISSORS);


        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Game " + (i + 1));
            System.out.print("Enter your move (R for ROCK, P for PAPER, S for SCISSORS): ");
            String playerMoveStr = scanner.nextLine().toUpperCase();

            if (playerMoveStr.equalsIgnoreCase("QUIT")) {
                break;
            }

            Move playerMove = validMoves.get(playerMoveStr);

            if (playerMove == null) {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            GameResult gameResult = gameService.play(playerMove);

            System.out.println("_________________________________");
            System.out.println("Player chose: " + gameResult.getPlayerMove());
            System.out.println("Computer chose: " + gameResult.getComputerMove());
            System.out.println("Result: " + getResultString(gameResult.getResult()));
        }

        gameService.printStatistics();
    }

    private static String getResultString(Player result) {
        switch (result) {
            case PLAYER:
                return "PLAYER";
            case COMPUTER:
                return "COMPUTER";
            case DRAW:
                return "DRAW";
            default:
                return "";
        }
    }
}
