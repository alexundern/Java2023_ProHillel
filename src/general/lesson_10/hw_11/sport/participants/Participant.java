package general.lesson_10.hw_11.sport.participants;

import general.lesson_10.hw_11.sport.obstacle.ObstacleEnum;

public interface Participant {

    boolean run(double distance);
    boolean jump(double height);
    boolean overcome(ObstacleEnum obstacle);
    String getName();

}
