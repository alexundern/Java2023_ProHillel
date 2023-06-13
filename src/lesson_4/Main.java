package lesson_4;
public class Main {
    public static void main(String[] args) {
        double distanceOdessaToKriveOzero = 180;
        double distanceKriveOzeroToZhashkiv = 152;
        double distanceZhashkivToKiev = 149;
        double fuelCostPerLiter = 47.5;

        double totalCostOfRefueling = 0.0; // Declare a variable for the total cost of refueling

        Car car = new Car(50, 50, 7);

        System.out.println("Car parameters:" + "\n_____________________________");
        System.out.printf("Fuel tank capacity: %.2f liters.%n", car.fuelTankCapacity);
        System.out.printf("Fuel level: %.2f liters.%n", car.fuelLevel);
        System.out.printf("Fuel consumption per 100km: %.2f liters.%n%n",
                car.fuelConsumptionPer100km);

        System.out.println("Refueling at Krive Ozero:");
        double fuelToRefill2 = car.calculateFuelToRefill(distanceOdessaToKriveOzero);
        double costToRefill2 = fuelToRefill2 * fuelCostPerLiter;
        car.fillTank();

        // Add the cost of refueling at Krive Ozero to the total cost
        totalCostOfRefueling += costToRefill2;

        System.out.printf("Fuel to refill at Krive Ozero: %.2f liters.%n", fuelToRefill2);
        System.out.printf("Cost to refill at Krive Ozero: %.2f UAH.%n%n", costToRefill2);

        // Refill the tank at Krive Ozero
        car.fillTank();

        System.out.println("Refueling at Zhashkiv:");

        double fuelToRefill3 = car.calculateFuelToRefill(distanceKriveOzeroToZhashkiv);
        double costToRefill3 = fuelToRefill3 * fuelCostPerLiter;

        // Add the cost of refueling at Zhashkiv to the total cost
        totalCostOfRefueling += costToRefill3;

        System.out.printf("Fuel to refill at Zhashkiv: %.2f liters.%n", fuelToRefill3);
        System.out.printf("Cost to refill at Zhashkiv: %.2f UAH.%n%n", costToRefill3);

        // Refill the tank at Zhashkiv
        car.fillTank();

        System.out.println("Calculating fuel left after trip:");
        double fuelLeft = car.calculateFuelLeft(distanceOdessaToKriveOzero
                + distanceKriveOzeroToZhashkiv + distanceZhashkivToKiev);
        System.out.printf("Fuel left after the trip: %.2f liters.%n", fuelLeft);

        // Print out the total cost of refueling
        System.out.printf("Total cost of refueling: %.2f UAH.%n", totalCostOfRefueling);
    }
}
