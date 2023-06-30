package general.lesson_5_hw_6;

public class Cat extends Animal {
    private static int catCount = 0;
    private static final int maxRunDistance = 500;

    public Cat() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
        if(distance <= maxRunDistance) {
            System.out.println("The cat ran " + distance + " meters");
        } else {
            System.out.println("The cat could not run this distance " + distance + " meters");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("The cat can't swim");
    }
}

