import hillel.innitial.Move;
import hillel.innitial.Player;
import hillel.service.GameService;
import hillel.innitial.GameResult;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService("Computer");
    }

    @DisplayName("Player Win")
    @Test
    void testPlay_PlayerWins() {
        GameResult gameResult = gameService.play(Move.PAPER);

        Assertions.assertEquals(Move.PAPER, gameResult.playerMove());
        Assertions.assertNotNull(gameResult.computerMove());
        Assertions.assertEquals(Player.PLAYER, gameResult.result());
    }

    @DisplayName("Computer Win")
    @Test
    void testPlay_ComputerWins() {
        GameResult gameResult = gameService.play(Move.SCISSORS);

        Assertions.assertEquals(Move.SCISSORS, gameResult.playerMove());
        Assertions.assertNotNull(gameResult.computerMove());
        Assertions.assertEquals(Player.COMPUTER, gameResult.result());
    }

    @DisplayName("Draw")
    @Test
    void testPlay_Draw() {
        GameResult gameResult = gameService.play(Move.ROCK);

        Assertions.assertEquals(Move.ROCK, gameResult.playerMove());
        Assertions.assertNotNull(gameResult.computerMove());
        Assertions.assertEquals(Player.DRAW, gameResult.result());
    }

    @DisplayName("Result")
    @Test
    void testPrintStatistics() {
        gameService.play(Move.PAPER);
        gameService.play(Move.SCISSORS);
        gameService.play(Move.ROCK);
        gameService.printStatistics();
    }
}

//    private GameService gameService;
//
//    @BeforeEach
//    public void setup() {
//        gameService = new GameService("Computer");
//        gameService.setGameService(gameService);
//    }
//
//    @DisplayName("Get correct index")
//    @Test
//    public void testGetIndex() {
//        assertEquals(0, gameService.getGameService().getIndex(Move.ROCK));
//        assertEquals(1, gameService.getGameService().getIndex(Move.PAPER));
//        assertEquals(2, gameService.getGameService().getIndex(Move.SCISSORS));
//    }
//
//    @DisplayName("Player Wins")
//    @Test
//    public void testPlayerWins() {
//        Move playerMove = Move.ROCK;
//        Move computerMove = Move.SCISSORS;
//        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
//        assertEquals(Player.PLAYER, result);
//    }
//
//    @DisplayName("Computer Wins")
//    @Test
//    public void testComputerWins() {
//        Move playerMove = Move.PAPER;
//        Move computerMove = Move.SCISSORS;
//        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
//        assertEquals(Player.COMPUTER, result);
//    }
//
//    @DisplayName("Draw")
//    @Test
//    public void testDraw() {
//        Move playerMove = Move.ROCK;
//        Move computerMove = Move.ROCK;
//        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
//        assertEquals(Player.DRAW, result);
//    }
//}

//    private GameService gameService;
//
//    @BeforeEach
//    void setUp() {
//        gameService = new GameService("Computer");
//    }
//
//    @DisplayName("Player Win")
//    @Test
//    void testPlay_PlayerWins() {
//        GameResult gameResult = gameService.play(Move.PAPER);
//
//        Assertions.assertEquals(Move.PAPER, gameResult.playerMove());
//        Assertions.assertNotNull(gameResult.computerMove());
//        Assertions.assertEquals(Player.PLAYER, gameResult.result());
//    }
//
//    @DisplayName("Computer Win")
//    @Test
//    void testPlay_ComputerWins() {
//        GameResult gameResult = gameService.play(Move.SCISSORS);
//
//        Assertions.assertEquals(Move.SCISSORS, gameResult.playerMove());
//        Assertions.assertNotNull(gameResult.computerMove());
//        Assertions.assertEquals(Player.COMPUTER, gameResult.result());
//    }
//
//    @DisplayName("Draw")
//    @Test
//    void testPlay_Draw() {
//        GameResult gameResult = gameService.play(Move.ROCK);
//
//        Assertions.assertEquals(Move.ROCK, gameResult.playerMove());
//        Assertions.assertNotNull(gameResult.computerMove());
//        Assertions.assertEquals(Player.DRAW, gameResult.result());
//    }
//
//    @DisplayName("Result")
//    @Test
//    void testStatistics() {
//        gameService.play(Move.PAPER);
//        gameService.play(Move.SCISSORS);
//        gameService.play(Move.ROCK);
//        gameService.printStatistics();
//    }
//}




