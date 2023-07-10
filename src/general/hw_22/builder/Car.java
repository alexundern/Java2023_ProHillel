package general.hw_22.builder;

public class Car {
    private final String engine;
    private final String wheels;
    private final String body;
    private final String color;
    private final int seats;
    private final String transmission;
    private final boolean navigation;
    private boolean airConditioner;
    private double fuel = 0;


    public Car(String engine, String wheels, String body, String color, int seats,
               String transmission, boolean navigation) {
        this.engine = engine;
        this.wheels = wheels;
        this.body = body;
        this.color = color;
        this.seats = seats;
        this.transmission = transmission;
        this.navigation = navigation;
        this.fuel = fuel;
    }

    public String getEngine() {
        return engine;
    }

    public String getWheels() {
        return wheels;
    }

    public String getBody() {
        return body;
    }

    public String getColor() {
        return color;
    }

    public int getSeats() {
        return seats;
    }

    public String getTransmission() {
        return transmission;
    }

    public boolean isNavigation() {
        return navigation;
    }

    public boolean isAirConditioner() {
        return airConditioner;
    }

    public double getFuel() {
        return fuel;
    }
}
