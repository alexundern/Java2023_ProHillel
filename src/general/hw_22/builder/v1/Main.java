package general.hw_22.builder.v1;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSUV(builder);
        builder.setColor(Color.PURPLE);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());
        System.out.println("Color: " + car.getColor());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSUV(manualBuilder);
        manualBuilder.setColor(Color.BLACK);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
        System.out.println("Color: " + carManual.getColor());
    }
}
