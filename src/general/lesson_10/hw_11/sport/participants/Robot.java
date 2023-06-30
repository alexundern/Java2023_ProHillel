package general.lesson_10.hw_11.sport.participants;

import general.lesson_10.hw_11.sport.obstacle.ObstacleEnum;

public class Robot implements Participant {

    private String name;
    private double runLimit;
    private double jumpLimit;

    public Robot(String name, double runLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public boolean run(double distance) {
        return performAction("Robot", "run", distance, runLimit);
    }

    public boolean jump(double height) {
        return performAction("Robot", "jump", height, jumpLimit);
    }

    public boolean overcome(ObstacleEnum obstacle) {
        if (obstacle == null) {
            return false;
        }

        if (obstacle == ObstacleEnum.RUN) {
            return run(obstacle.getValue());
        } else if (obstacle == ObstacleEnum.JUMP) {
            return jump(obstacle.getValue());
        }
        return false;
    }

    public String getName() {
        return name;
    }

    private boolean performAction(String participantType, String action, double value, double limit) {
        StringBuilder sb = new StringBuilder();
        sb.append(participantType)
                .append(" ")
                .append(name)
                .append(" ")
                .append(action)
                .append(" ")
                .append(value)
                .append(" meters");

        if (value <= limit) {
            System.out.println(sb.toString());
            return true;
        } else {
            sb.insert(0, "cannot ");
            System.out.println(sb.toString());
            return false;
        }
    }
}
