package lesson_10.hw_11.geometry.shapes;

public class Square implements Figures {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
