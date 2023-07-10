package general.hw_22.builder;

public class test {

    public class Car {
        //required parameters
        private String engineType;
        private String wheels;
        private String body;

        //optional parameters
        private String color;
        private boolean navigation;
        private boolean airConditioner;

        //getters
        public String getEngineType() {
            return engineType;
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

        public boolean isNavigation() {
            return navigation;
        }

        public boolean isAirConditioner() {
            return airConditioner;
        }

        //private constructor with Builder as argument
        private Car(CarBuilder builder) {
            this.engineType = builder.engineType;
            this.wheels = builder.wheels;
            this.body = builder.body;
            this.color = builder.color;
            this.navigation = builder.navigation;
            this.airConditioner = builder.airConditioner;
        }

        //Builder class
        public static class CarBuilder {
            //required parameters
            private String engineType;
            private String wheels;
            private String body;

            //optional parameters
            private String color;
            private boolean navigation;
            private boolean airConditioner;

            //public constructor with required parameters
            public CarBuilder(String engineType, String wheels, String body) {
                this.engineType = engineType;
                this.wheels = wheels;
                this.body = body;
            }

            //methods to set optional parameters
            public CarBuilder setColor(String color) {
                this.color = color;
                return this; //return the same Builder object
            }

            public CarBuilder setNavigation(boolean navigation) {
                this.navigation = navigation;
                return this; //return the same Builder object
            }

            public CarBuilder setAirConditioner(boolean airConditioner) {
                this.airConditioner = airConditioner;
                return this; //return the same Builder object
            }

            //method to return the final Car object
            public Car build() {
                return new Car(this); //pass the Builder object to the Car constructor
            }

        }
    }


    ----------------------------------------------------------------------

    Car car1 = new Car.CarBuilder("electric", "alloy", "sedan")
            .setColor("red")
            .setNavigation(true)
            .build(); //create a red electric sedan with navigation

    Car car2 = new Car.CarBuilder("diesel", "steel", "SUV")
            .setAirConditioner(true)
            .build(); //create a diesel SUV with air conditioner



}
