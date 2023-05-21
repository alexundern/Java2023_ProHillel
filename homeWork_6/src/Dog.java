public class Dog extends Animal{
    private static int dogCount = 0;
    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    public Dog() {
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        super.run(distance);
        if(distance <= maxRunDistance) {
            System.out.println("The dog ran " + distance + " meters");
        } else {
            System.out.println("The dog could not run this distance " + distance + " meters");
        }
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
        if(distance <= maxSwimDistance) {
            System.out.println("The dog swim " + distance + " meters");
        } else {
            System.out.println("The dog could not swim this distance " + distance + " meters");
        }
    }
}
