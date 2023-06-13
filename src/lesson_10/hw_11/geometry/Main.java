package lesson_10.hw_11.geometry;

import lesson_10.hw_11.geometry.shapes.Circle;
import lesson_10.hw_11.geometry.shapes.Figures;
import lesson_10.hw_11.geometry.shapes.Square;
import lesson_10.hw_11.geometry.shapes.Triangle;

public class Main {

    public static void main(String[] args) {
        Figures[] figures = new Figures[3];
        figures[0] = new Circle(2);
        figures[1] = new Triangle(8,3 );
        figures[2] = new Square(5);

        double totalArea = calculateTotalArea(figures);
        System.out.println("Total area of all figures: " + totalArea);
    }

    public static double calculateTotalArea(Figures[] figures) {
        double totalArea = 0;
        for (Figures figure : figures) {
            totalArea += figure.getArea();
        }
        return totalArea;
    }
}
