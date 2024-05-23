package Practice_6;

// Builder
class Car {
    private String make;
    private String model;
    private int year;

    public static class Builder {
        private String make;
        private String model;
        private int year;

        public Builder withMake(String make) {
            this.make = make;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.make = this.make;
            car.model = this.model;
            car.year = this.year;
            return car;
        }
    }

    private Car() {}

    public void printDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }
}