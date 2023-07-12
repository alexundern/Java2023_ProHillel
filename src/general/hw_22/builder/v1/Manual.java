package general.hw_22.builder.v1;

public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final AirConditioner airConditioner;
    private final GPSNavigator gpsNavigator;
    private final Color color;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                  AirConditioner airConditioner, GPSNavigator gpsNavigator, Color color) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.airConditioner = airConditioner;
        this.gpsNavigator = gpsNavigator;
        this.color = color;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Color: " + color + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        info += "Transmission: " + transmission + "\n";
        if (this.airConditioner != null) {
            info += "Air Conditioner: Functional" + "\n";
        } else {
            info += "Air Conditioner: N/A" + "\n";
        }
        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Functional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }

}
