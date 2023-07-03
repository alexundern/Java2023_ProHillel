import com.hillel.innitial.Move;
import com.hillel.innitial.Player;
import com.hillel.service.GameService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    public void setup() {
        gameService = new GameService("Computer");
    }

    @DisplayName("Get correct index")
    @Test
    public void testGetIndex() {
        assertEquals(0, gameService.getIndex(Move.ROCK));
        assertEquals(1, gameService.getIndex(Move.PAPER));
        assertEquals(2, gameService.getIndex(Move.SCISSORS));
    }

    @DisplayName("Player Wins")
    @Test
    public void testPlayerWins() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.SCISSORS;
        Player result = gameService.determineResult(playerMove, computerMove);
        assertEquals(Player.PLAYER, result);
    }

    @DisplayName("Computer Wins")
    @Test
    public void testComputerWins() {
        Move playerMove = Move.PAPER;
        Move computerMove = Move.SCISSORS;
        Player result = gameService.determineResult(playerMove, computerMove);
        assertEquals(Player.COMPUTER, result);
    }

    @DisplayName("Draw")
    @Test
    public void testDraw() {
        Move playerMove = Move.ROCK;
        Move computerMove = Move.ROCK;
        Player result = gameService.determineResult(playerMove, computerMove);
        assertEquals(Player.DRAW, result);
    }
}
