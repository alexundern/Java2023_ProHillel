package hillel.innitial;

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
}

