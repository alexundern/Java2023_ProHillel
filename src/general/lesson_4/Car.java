package general.lesson_4;

public class Car {
    final double fuelTankCapacity;
    double fuelLevel;
    final double fuelConsumptionPer100km;

    public Car(double fuelTankCapacity, double fuelLevel, double fuelConsumptionPer100km) {
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelLevel = fuelLevel;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }

    public void fillTank() {
//        double fuelToFill = this.fuelTankCapacity - Math.max(0, this.fuelLevel);
        this.fuelLevel = this.fuelTankCapacity;
    }

    public double calculateFuelLeft(double distance) {
        double fuelConsumed = (distance / 100) * this.fuelConsumptionPer100km;
        return this.fuelLevel - fuelConsumed;
    }

    public double calculateFuelToRefill(double distance) {
        double fuelConsumed = (distance / 100) * this.fuelConsumptionPer100km;
        double fuelToRefill = this.fuelLevel - fuelConsumed;
        if (fuelToRefill < 0) {
            return 0;
        }
            return fuelToRefill;
        }
}
