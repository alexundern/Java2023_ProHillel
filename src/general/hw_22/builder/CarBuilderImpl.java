package general.hw_22.builder;

public class CarBuilderImpl implements CarBuilder {
    private String engine;
    private String wheels;
    private String body;
    private String color;
    private int seats;
    private String transmission;
    private String navigation;
    private String airConditioner;

    @Override
    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setNavigation(String navigation) {
        this.navigation = navigation;
    }

    @Override
    public void setAirConditioner(String airConditioner) {
        this.airConditioner = airConditioner;
    }
    public Car getResult() {
        return new Car(engine, wheels, body, color, seats, transmission, airConditioner);

    }
}
