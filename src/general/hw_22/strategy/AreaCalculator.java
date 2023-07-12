package general.hw_22.strategy;

public class AreaCalculator {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double calculateArea() {
        if (shape == null) {
            throw new IllegalStateException("Shape is not set.");
        }
        return shape.calculateArea();
    }
}
