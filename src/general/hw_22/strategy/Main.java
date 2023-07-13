package general.hw_22.strategy;

public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Rectangle rectangle = new Rectangle(6, 2);
        calculator.setShape(rectangle);
        double rectangleArea = calculator.calculateArea();
        System.out.println("The area of a rectangle: " + rectangleArea);

        Triangle triangle = new Triangle(4, 8);
        calculator.setShape(triangle);
        double triangleArea = calculator.calculateArea();
        System.out.println("The area of a triangle: " + triangleArea);
    }
}

//https://refactoring.guru/ru/design-patterns/strategy