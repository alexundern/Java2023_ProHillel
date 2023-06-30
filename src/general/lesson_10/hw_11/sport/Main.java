package general.lesson_10.hw_11.sport;

import general.lesson_10.hw_11.sport.obstacle.ObstacleEnum;
import general.lesson_10.hw_11.sport.participants.Cat;
import general.lesson_10.hw_11.sport.participants.Human;
import general.lesson_10.hw_11.sport.participants.Participant;
import general.lesson_10.hw_11.sport.participants.Robot;

import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Human("Erica", 300, 2));
        participants.add(new Robot("Volli", 400, 1.5));
        participants.add(new Cat("Myrka", 250, 2.5));

        List<ObstacleEnum> obstacles = new ArrayList<>();
        obstacles.add(ObstacleEnum.JUMP);
        obstacles.add(ObstacleEnum.RUN);

        for (Participant participant : participants) {
            boolean passedAllObstacles = true;
            for (ObstacleEnum obstacle : obstacles) {
                if (!participant.overcome(obstacle)) {
                    passedAllObstacles = false;
                    System.out.println(participant.getName() + " did not pass the obstacle "
                            + obstacle.name() + " at a distance " + obstacle.getValue());
                    break;
                }
            }
            if (passedAllObstacles) {
                System.out.println(participant.getName() + " passed all obstacles successfully");
            }
            System.out.println();

        }
    }
}
