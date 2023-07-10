package general.hw_22.builder;

public interface CarBuilder {
//    CarBuilder setEngine(String engine);
//    CarBuilder setWheels(String wheels);
//    CarBuilder setBody(String body);
//    CarBuilder setColor(String color);
//    Car build();


    void setEngine(String engine);
    void setWheels(String wheels);
    void setBody(String body);
    void setColor(String color);
    void setSeats(int seats);
    void setTransmission(String transmission);
    void setNavigation(String navigation);
    void setAirConditioner(String airConditioner);
    }
