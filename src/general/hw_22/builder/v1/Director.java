package general.hw_22.builder.v1;

public class Director {
    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setAirConditioner(new AirConditioner());
        builder.setGPSNavigator(new GPSNavigator());
        builder.setColor(Color.RED);
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setAirConditioner(new AirConditioner());
        builder.setGPSNavigator(new GPSNavigator());
        builder.setColor(Color.YELLOW);
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setAirConditioner(new AirConditioner());
        builder.setGPSNavigator(new GPSNavigator());
        builder.setColor(Color.BLACK);
    }
}
