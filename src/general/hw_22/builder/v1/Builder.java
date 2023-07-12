package general.hw_22.builder.v1;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setAirConditioner(AirConditioner airConditioner);
    void setGPSNavigator(GPSNavigator gpsNavigator);
    void setColor(Color color);
}
