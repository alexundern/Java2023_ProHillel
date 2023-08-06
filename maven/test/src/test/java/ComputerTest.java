import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
public class ComputerTest {

    @DisplayName("Check all computer moves")
    @Test
    public void testMakeMove() {
        Computer computer = new Computer("Computer");

        Set<Move> moves = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            Move move = computer.makeMove();
            moves.add(move);
        }

        Assertions.assertEquals(3, moves.size());
        Assertions.assertTrue(moves.contains(Move.ROCK));
        Assertions.assertTrue(moves.contains(Move.PAPER));
        Assertions.assertTrue(moves.contains(Move.SCISSORS));
    }
}
