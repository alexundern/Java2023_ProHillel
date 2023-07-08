package hillel.innitial;

import java.util.Random;

public record Computer(String name) {
    public Move makeMove() {
        Random random = new Random();
        int index = random.nextInt(Move.values().length);
        return Move.values()[index];
    }
}
