import com.hillel.innitial.Move;
import com.hillel.innitial.Player;
import com.hillel.service.GameService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    public void setup() {
        gameService = new GameService("Computer");
        gameService.setGameService(gameService);
    }

    @DisplayName("Get correct index")
    @Test
    public void testGetIndex() {
        Assertions.assertEquals(0, gameService.getGameService().getIndex(Move.ROCK));
        Assertions.assertEquals(1, gameService.getGameService().getIndex(Move.PAPER));
        Assertions.assertEquals(2, gameService.getGameService().getIndex(Move.SCISSORS));
    }

    @DisplayName("Player Wins")
    @Test
    public void testPlayerWins() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.SCISSORS;
        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
        Assertions.assertEquals(Player.PLAYER, result);
    }

    @DisplayName("Computer Wins")
    @Test
    public void testComputerWins() {
        Move playerMove = Move.PAPER;
        Move computerMove = Move.SCISSORS;
        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
        Assertions.assertEquals(Player.COMPUTER, result);
    }

    @DisplayName("Draw")
    @Test
    public void testDraw() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.ROCK;
        Player result = gameService.getGameService().determineResult(playerMove, computerMove);
        Assertions.assertEquals(Player.DRAW, result);
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