package general.hw_22.builder.v1;

public class AirConditioner {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void turnOn() {
        System.out.println("Air Conditioner turned on");
    }

    public void turnOff() {
        System.out.println("Air Conditioner turned off");
    }
}
