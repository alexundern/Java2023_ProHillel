package general.lesson_10.hw_11.sport.obstacle;

public enum ObstacleEnum {

    JUMP(2),
    RUN(300);

    private int value;

    ObstacleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
