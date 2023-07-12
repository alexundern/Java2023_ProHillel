package general.hw_22.builder.v1;

public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private AirConditioner airConditioner;
    private final GPSNavigator gpsNavigator;
    private final Color color;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               AirConditioner airConditioner, GPSNavigator gpsNavigator, Color color) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.airConditioner = airConditioner;
        if (this.airConditioner != null) {
            this.airConditioner.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
        this.color = color;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public AirConditioner getAirConditioner() {
        if (airConditioner == null) {
            airConditioner = new AirConditioner();
            airConditioner.setCar(this);
        }
        return airConditioner;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public Color getColor() {
        return color;
    }
}
