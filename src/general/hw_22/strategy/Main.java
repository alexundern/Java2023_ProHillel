package general.hw_22.strategy;

public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Rectangle rectangle = new Rectangle(4, 5);
        calculator.setShape(rectangle);
        double rectangleArea = calculator.calculateArea();
        System.out.println("Площадь прямоугольника: " + rectangleArea);

        Triangle triangle = new Triangle(3, 6);
        calculator.setShape(triangle);
        double triangleArea = calculator.calculateArea();
        System.out.println("Площадь треугольника: " + triangleArea);
    }
}

//https://refactoring.guru/ru/design-patterns/strategy